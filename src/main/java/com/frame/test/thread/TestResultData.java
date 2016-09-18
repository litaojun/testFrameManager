package com.frame.test.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestResultData 
{
	public TestResultData()
	{
		
	}
	private static long signnum = 1122332122L;
	private  Lock lock=new ReentrantLock();
	private  Condition condition_con=lock.newCondition();
	private int totalNum=0;
	private int sucessNum=0;
	private int failNum=0;
	private int exceptionNum=0;
	private ArrayList<String[]> sucesslist =new ArrayList<String[]>(),falllist=new ArrayList<String[]>(),exceptionlist=new ArrayList<String[]>();
	public void addNum(int ty,String caseid,String funstr)
	{
		lock.lock();
		totalNum++;
		switch(ty)
		{
		case 0:
		{
			sucesslist.add(new String[]{caseid,funstr});
			sucessNum++;
			break;
		}
		case 1:
		{
			falllist.add(new String[]{caseid,funstr});
			failNum++;
			break;
		}
		case 2:
		{
			exceptionlist.add(new String[]{caseid,funstr});
			exceptionNum++;
			break;
		}
		}
		lock.unlock();
	}
	public void setTotalNum(int num)
	{
		this.totalNum = num;
	}
	public void setSucessNum(int num)
	{
		this.sucessNum = num;
	}
	public void setFailNum(int num)
	{
		this.failNum = num;
	}
	public int getTotalNum()
	{
		return this.totalNum;
	}
	public int getSucessNum()
	{
		return this.sucessNum;
	}
	public int getFailNum()
	{
		return this.failNum;
	}
	public int getExceptionNum()
	{
		return this.exceptionNum;
	}
}
