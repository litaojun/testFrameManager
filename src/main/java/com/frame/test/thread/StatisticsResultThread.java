package com.frame.test.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.frame.test.core.TestManageContorl;
import com.frame.test.util.HttpRequest;

public class StatisticsResultThread extends Thread 
{
	public void run()
	{
		HashMap<String,ArrayList<String[]>>  a = TestManageContorl.tsmanager.getCasehashmap();
		Iterator it = a.keySet().iterator();
		while(it.hasNext())
		{
		    TestcaseRun tr = new TestcaseRun(a.get(it.next()));
		    try {
				tr.join();
				tr.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
