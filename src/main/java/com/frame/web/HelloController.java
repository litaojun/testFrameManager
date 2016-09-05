package com.frame.web;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.*;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/19 下午1:27.
 * @blog http://blog.didispace.com
 */
@RestController
public class HelloController {
	private ObjectMapper objectMapper = new ObjectMapper();
    @RequestMapping(value = "/casereqdata", method = RequestMethod.GET)
    public UserAddInfo hello1(@RequestParam String name) 
    {
    	System.out.println("name="+name);
    	UserAddInfo uaf = new UserAddInfo();
    	uaf.setNickname("litaojun");
    	uaf.setUsername("litj");
    	uaf.setPassword("111111");
        return uaf;
    }
    @RequestMapping(value = "/caseretcodedata", method = RequestMethod.GET)
    public String hello2(@RequestParam String name) throws JsonGenerationException, JsonMappingException, IOException 
    {
    	UserAddInfo uaf = new UserAddInfo();
    	uaf.setNickname("litaojun");
    	uaf.setUsername("litj");
    	uaf.setPassword("111111");
        HashMap<String,Object> hmp = new HashMap<String,Object>();
        hmp.put("retcode", 2);
        hmp.put("user", uaf);
        String stra = objectMapper.writeValueAsString(hmp);
        return stra;
    }
    @RequestMapping(value = "/yqresultdata", method = RequestMethod.GET)
    public String hello3(@RequestParam String name) throws JsonGenerationException, JsonMappingException, IOException 
    {
    	 HashMap<String,Object> hmp = new HashMap<String,Object>();
         hmp.put("retcode", 2);
         hmp.put("errstr", "sdfasdfasfd");
         String stra = objectMapper.writeValueAsString(hmp);
        return stra;
    }

}
