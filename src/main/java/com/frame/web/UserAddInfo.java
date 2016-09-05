package com.frame.web;

public class UserAddInfo 
{
   String username;
   String password;
   String nickname;
   public void setUsername(String username)
   {
	   this.username = username;
   }
   public void setPassword(String passwd)
   {
	   this.password = passwd;
   }
   public void setNickname(String nicknm)
   {
	   this.nickname = nicknm;
   }
   public String getUsername()
   {
	   return this.username;
   }
   public String getPassword()
   {
	   return this.password;
   }
   public String getNickname()
   {
	   return this.nickname;
   }
}
