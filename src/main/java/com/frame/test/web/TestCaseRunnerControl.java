package com.frame.test.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frame.test.core.MethodContext;
import com.frame.test.core.TestManageContorl;
import com.frame.test.thread.StatisticsResultThread;
import com.frame.test.thread.TestResultData;
import com.frame.test.util.HttpRequest;
import com.frame.test.util.TestCaseStyle;


@RestController
public class TestCaseRunnerControl 
{

	@RequestMapping("/caserun.do")
    public String interfaces() throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException 
	{
		final TestManageContorl tmcl = new TestManageContorl();
		new Thread(){
			public void run()
			{
				ArrayList<String[]> als = TestManageContorl.getTestCaseManagr().getCaseidlist();
				for(String[] caseid:als)
				{
					String retstr = HttpRequest.sendGet("http://localhost:8080/interfaces",String.format("caseid=%s&intfacename=%s",caseid));
					tmcl.getTestCaseManagr().setCaseRetData(caseid[1], caseid[0], retstr);
					//System.out.println("retstr="+retstr);
					String cmrresult = HttpRequest.sendGet("http://localhost:8080/resultCompare",String.format("caseid=%s&intfacename=%s",caseid));
					tmcl.getTestCaseManagr().setCaseResultData(caseid[1], caseid[0], cmrresult);
					//System.out.println("cmrresult="+cmrresult);
				}
			}
		}.start();
        return "0";
    }
	
	@RequestMapping("/caseinputdata.do")
	public String getCaseInputdata(@RequestParam("intfacename") String name,@RequestParam("caseid") String caseid) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		TestManageContorl tmcl = new TestManageContorl();
		MethodContext mct = tmcl.interfacemethod.get(name);
		String inputdata = tmcl.getTestCaseManagr().getCaseInputData(name, caseid);
		if(tmcl.interfacemethod.containsKey(name))
		{
		   inputdata = tmcl.interfacemethod.get(name).invokeMethod(null, new String[]{inputdata});
		}
		return inputdata;
	}
	
	@RequestMapping("/caseouputdata.do")
	public String getCaseOuputdata(@RequestParam("intfacename") String name,@RequestParam("caseid") String caseid) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		TestManageContorl tmcl = new TestManageContorl();
		//MethodContext mct = tmcl.interfacemethod.get(name);
		String ouputdata = tmcl.getTestCaseManagr().getCaseRetData(name, caseid);
//		if(tmcl.resultmethod.containsKey(name))
//		{
//		MethodContext mct = tmcl.resultmethod.get(name);
//		try {
//			ouputdata = mct.invokeMethod(null, new String[]{ouputdata});
//		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
//				| InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
		return ouputdata;
	}
	
	@RequestMapping("/yqresultdata.do")
	public String getCaseYqresultdata(@RequestParam("intfacename") String name,@RequestParam("caseid") String caseid) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		TestManageContorl tmcl = new TestManageContorl();
		//MethodContext mct = tmcl.interfacemethod.get(name);
		String expectrst = tmcl.getTestCaseManagr().getCaseExpectedResult(name, caseid);
		if(tmcl.resultmethod.containsKey(name))
		{
		MethodContext mct = tmcl.resultmethod.get(name);
		try {
			expectrst = mct.invokeMethod(null, new String[]{expectrst});
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return expectrst;
	}
	@RequestMapping("/caselist.do")
	public String getCaseListdata(@RequestParam("intfacename") String name) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		TestManageContorl tmcl = new TestManageContorl();
		//MethodContext mct = tmcl.interfacemethod.get(name);
		//
		HashMap<String,List<TestCaseStyle>> hmlist = tmcl.getTestCaseManagr().getCurmap();
		String ouputdata = objectMapper.writeValueAsString(hmlist);
		return ouputdata;
	}
	
	
	@RequestMapping("/caserunsync.do")
    public String caserunsync() throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException 
	{
		final TestManageContorl tmcl = new TestManageContorl();
		StatisticsResultThread thr = new StatisticsResultThread();
		thr.start();
        return "0";
    }
	
	
	@RequestMapping("/result.do")
    public TestResultData result() throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException 
	{
		TestResultData trd = TestManageContorl.trdata;
		if(trd==null)
			trd = new TestResultData();
        return trd;
    }
	
}
