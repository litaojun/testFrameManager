package com.frame.test.mail;

import java.io.IOException;
import java.io.InputStream;
/**  
 * 发送邮件需要使用的基本信息  
 */  
import java.util.Properties;

import com.frame.test.util.SendMail;  
  
public class MailSenderInfo {  
      
    // 发送邮件的服务器的IP和端口  
    private String mailServerHost;  
    private String mailServerPort = "25";  
    // 邮件发送者的地址  
    private String fromAddress;  
    // 邮件接收者的地址  
    private String toAddress;  
    // 登陆邮件发送服务器的用户名和密码  
    private String userName;  
    private String password;  
    // 是否需要身份验证  
    private boolean validate = false;  
    // 邮件主题  
    private String subject;  
    // 邮件的文本内容  
    private String content;  
    // 邮件附件的文件名  
    private String[] attachFileNames;  
    private Properties p = new Properties();  
  
    public MailSenderInfo()
    {
    	//Properties p = new Properties();  
        InputStream in = MailSenderInfo.class.getResourceAsStream("MailServer.properties");
        try {
            p.load(in);
            this.mailServerHost = p.getProperty("mail.smtp.host");
            this.mailServerPort = p.getProperty("mail.smtp.port");
            this.userName = p.getProperty("mail.sender.username");
            this.password = p.getProperty("mail.sender.password");
            this.validate = p.getProperty("mail.smtp.auth").equals("true");
            this.fromAddress = p.getProperty("mail.sender.addr");
//            this.mailHost = properties.getProperty("mail.smtp.host");
//            this.sender_username = 
//            this.sender_password = properties.getProperty("mail.sender.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** 
     * 获得邮件会话属性 
     */  
    public Properties getProperties() {  
    	
//        Properties p = new Properties();  
//        InputStream in = MailSenderInfo.class.getResourceAsStream("MailServer.properties");
//        try {
//            p.load(in);
//            this.userName = p.getProperty("mail.sender.username");
//            this.password = p.getProperty("mail.sender.password");
////            this.mailHost = properties.getProperty("mail.smtp.host");
////            this.sender_username = 
////            this.sender_password = properties.getProperty("mail.sender.password");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        p.put("mail.smtp.host", this.mailServerHost);  
//        p.put("mail.smtp.port", this.mailServerPort);  
//        p.put("mail.smtp.auth", validate ? "true" : "false");  
        return p;  
    }  
  
    public String getMailServerHost() {  
        return mailServerHost;  
    }  
  
    public void setMailServerHost(String mailServerHost) {  
        this.mailServerHost = mailServerHost;  
    }  
  
    public String getMailServerPort() {  
        return mailServerPort;  
    }  
  
    public void setMailServerPort(String mailServerPort) {  
        this.mailServerPort = mailServerPort;  
    }  
  
    public boolean isValidate() {  
        return validate;  
    }  
  
    public void setValidate(boolean validate) {  
        this.validate = validate;  
    }  
  
    public String[] getAttachFileNames() {  
        return attachFileNames;  
    }  
  
    public void setAttachFileNames(String[] fileNames) {  
        this.attachFileNames = fileNames;  
    }  
  
    public String getFromAddress() {  
        return fromAddress;  
    }  
  
    public void setFromAddress(String fromAddress) {  
        this.fromAddress = fromAddress;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public String getToAddress() {  
        return toAddress;  
    }  
  
    public void setToAddress(String toAddress) {  
        this.toAddress = toAddress;  
    }  
  
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
    public String getSubject() {  
        return subject;  
    }  
  
    public void setSubject(String subject) {  
        this.subject = subject;  
    }  
  
    public String getContent() {  
        return content;  
    }  
  
    public void setContent(String textContent) {  
        this.content = textContent;  
    }  
}  