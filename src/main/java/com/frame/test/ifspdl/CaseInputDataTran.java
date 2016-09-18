package com.frame.test.ifspdl;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.frame.test.util.IfsPreDeal;

public class CaseInputDataTran 
{

	@IfsPreDeal(infname = "useradd")
	public String UserAddData(String inputdata) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String retdata=null;
		HashMap<String,String> hmap = new HashMap<String,String>();
		String[] item = inputdata.split("\n");
		for(String a:item)
		{
			String[] tm = a.split("=");
			hmap.put(tm[0], tm[1]);
		}
		retdata = objectMapper.writeValueAsString(hmap);
		return retdata;
	}
}
