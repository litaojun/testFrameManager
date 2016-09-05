package com.frame.test.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestCaseManagr {
	//private TestCaseStyle[] caseList =null;
	private ArrayList<String[]> caseidlist = new ArrayList<String[]>();
	private HashMap<String,List<TestCaseStyle>> curmap = new HashMap<String,List<TestCaseStyle>>();
	
	public HashMap<String,List<TestCaseStyle>> getCurmap()
	{
		return this.curmap;
	}
//	public TestCaseManagr(String path,String weet,int row) throws IOException
//	{
////		   List<TestCaseStyle> curList = new ArrayList<TestCaseStyle>();
////			ExcelCommon a=new ExcelCommon(path,weet);
////			String b[][] = a.readSheetToArray(row,7);
////			caseList = new TestCaseStyle[row];
////			for(int i=0;i<b.length;i++)
////			{
////				//System.out.println("i=========================="+i);
////				caseList[i]=new TestCaseStyle(b[i]);
////				curList.add(caseList[i]);
////				//System.out.println(caseList[i].toString());
////			}
////			curmap.put(weet, curList);
//	}
	public ArrayList<String[]> getCaseidlist()
	{
		return this.caseidlist;
	}
	
	public void addTestCase(String path,String weet,int row) throws IOException
	{
		List<TestCaseStyle> curList = new ArrayList<TestCaseStyle>();
		ExcelCommon a=new ExcelCommon(path,weet);
		String b[][] = a.readSheetToArray(row,7);
		TestCaseStyle[] caseList = new TestCaseStyle[row];
		for(int i=1;i<b.length;i++)
		{
			//System.out.println("i=========================="+i);
			caseList[i]=new TestCaseStyle(b[i]);
			caseidlist.add(new String[]{caseList[i].getCaseid(),caseList[i].getFunctionPoint()});
			curList.add(caseList[i]);
			//System.out.println(caseList[i].toString());
		}
		curmap.put(weet, curList);
	}
	public String getCaseInputData(String infname,String caseid)
	{
		List<TestCaseStyle> a = curmap.get(infname);
		for(TestCaseStyle tem:a)
		{
			if(tem.cmpcsid(caseid))
				return tem.getInputData();
		}
		return null;
	}
	public String getCaseExpectedResult(String infname,String caseid)
	{
		List<TestCaseStyle> a = curmap.get(infname);
		for(TestCaseStyle tem:a)
		{
			if(tem.cmpcsid(caseid))
				return tem.getExpectedResult();
		}
		return null;
	}
	public String getCaseRetData(String infname,String caseid)
	{
		List<TestCaseStyle> a = curmap.get(infname);
		for(TestCaseStyle tem:a)
		{
			if(tem.cmpcsid(caseid))
				return tem.getRetData();
		}
		return null;
	}

	public void setCaseRetData(String infname,String caseid,String ret)
	{
		List<TestCaseStyle> a = curmap.get(infname);
		for(TestCaseStyle tem:a)
		{
			if(tem.cmpcsid(caseid))
				tem.setRetData(ret);
		}
	}
	public void setCaseResultData(String infname,String caseid,String ret)
	{
		List<TestCaseStyle> a = curmap.get(infname);
		for(TestCaseStyle tem:a)
		{
			if(tem.cmpcsid(caseid))
				tem.setTestResult(ret);
		}
	}
//	public Collection getCurList(String[] classPara)
//	{
//		List a =new LinkedList();
//		for(int i = 0;i<this.curList.size();i++)
//		{
//			a.add(new Object[]{this.curList.get(i),classPara});
//		}
//		return a;
//	}
//	public Collection traveCollection()
//	{
//		List a =new LinkedList();
//		//System.out.println("caseList.length="+caseList.length);
//		for(int i=0;i<caseList.length;i++)
//		{
//			//System.out.println("i="+i);
//			a.add(caseList[i].traveToDataArray());
//		}
//		return a;
//	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try {
			TestCaseManagr a = new TestCaseManagr();
			a.addTestCase("E:\\环境文档\\测试用例.xlsx","Sheet1",2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
