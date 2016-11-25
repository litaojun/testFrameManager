package com.frame.test.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.frame.test.util.TestCaseStyle;
@CrossOrigin
@RestController
public class TestController {
	

	   @RequestMapping(value = "/user.do",method= RequestMethod.POST)
	    public HashMap<String,String> ajaxLoginUserPost(@RequestBody TestCaseStyle  tcsl) 
	   {
	        String errorMessage="0";
	        HashMap<String,String> hmp = new HashMap<String,String>();
//	        String username = request.getParameter("username");
	        System.out.println("username="+tcsl.getCaseid());
	        hmp.put("retcode", "1");
	        return hmp;

	    }
}
