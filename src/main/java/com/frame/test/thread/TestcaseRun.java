package com.frame.test.thread;

import java.io.IOException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.frame.test.core.TestManageContorl;
import com.frame.test.util.HttpRequest;

public class TestcaseRun extends Thread {
	private ArrayList<String[]> datals = null;

	public TestcaseRun(ArrayList<String[]> als)
	{
		this.datals = als;
	}
	public void run()
	{
		for(String[] caseid:this.datals)
		{
			String retstr = HttpRequest.sendGet("http://localhost:8080/interfaces",String.format("caseid=%s&intfacename=%s",caseid));
			TestManageContorl.getTestCaseManagr().setCaseRetData(caseid[1], caseid[0], retstr);
			//System.out.println("retstr="+retstr);
			String cmrresult = HttpRequest.sendGet("http://localhost:8080/resultCompare",String.format("caseid=%s&intfacename=%s",caseid));
			TestManageContorl.getTestCaseManagr().setCaseResultData(caseid[1], caseid[0], cmrresult);
			//System.out.println("cmrresult="+cmrresult);
			int sign = 2;
			JSONObject data = JSON.parseObject(cmrresult);
			if(data.containsKey("retcode"))
			   sign = data.getIntValue("retcode");
			TestManageContorl.trdata.addNum(sign, caseid[0],caseid[1]);
		}
	}

}
