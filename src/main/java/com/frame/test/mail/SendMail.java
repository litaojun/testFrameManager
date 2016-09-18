package com.frame.test.mail;

public class SendMail {  
    
    public static void main(String[] args) {  
        SendMail.send_163();  
    }  
      
    // 163邮箱  
    public static void send_163() {  
        // 这个类主要是设置邮件  
        MailSenderInfo mailInfo = new MailSenderInfo();  
//        mailInfo.setMailServerHost("smtp.163.com");  
//        mailInfo.setMailServerPort("25");  
//        mailInfo.setValidate(true);  
//        mailInfo.setUserName("18916899938"); // 实际发送者  
//        mailInfo.setPassword("Bestv001");// 您的邮箱密码  
        //mailInfo.setFromAddress("18916899938@163.com"); // 设置发送人邮箱地址  
        mailInfo.setToAddress("78069455@qq.com"); // 设置接受者邮箱地址  
        mailInfo.setSubject("请查看附件内ddd容，重要");  
        mailInfo.setContent("中国龙室怎,asfd as发生发射点发啊十分大师傅的啊手动阀十分大师傅的啊手动阀十分大师傅的阿斯顿发生法发射点发生");  
        // 这个类主要来发送邮件  
        SimpleMailSender sms = new SimpleMailSender();  
        sms.sendTextMail(mailInfo); // 发送文体格式  
        //sms.sendHtmlMail(mailInfo); // 发送html格式  
    }  
}  