package com.frame.test.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class BytesHexStringTran {
	
	/** 
     * 读取流中的数据: 将字节输入流中的数据转变成字节数组 
     *  
     * @param inputStream:要转化的输入流 
     */  
    public static byte[] read(InputStream inputStream) {  

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        try {  
            byte[] buffer = new byte[inputStream.available()];  
            System.out.println(buffer.length);  
            int len = 0;  
            while ((len = inputStream.read(buffer)) != -1) {  
                outStream.write(buffer, 0, len);      
            }  
            inputStream.close();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
        	System.out.println("error");
            e.printStackTrace();  
        }  
        /** 
         * Returns the contents of this ByteArrayOutputStream as a byte 
         * array. Any changes made to the receiver after returning will not 
         * be reflected(反射)in the byte array returned to the caller. 
         **/  
        return outStream.toByteArray();  
    }  

    /** 
     * Convert byte[] to hex string.
     * @param src byte[] data 
     * @return hex string 
     */     
    public static String bytesToHexString(byte[] src){  
        StringBuilder stringBuilder = new StringBuilder("");  
        if (src == null || src.length <= 0) {  
            return null;  
        }  
        for (int i = 0; i < src.length; i++) {  
            int v = src[i] & 0xFF;  
            String hv = Integer.toHexString(v);  
            if (hv.length() < 2) 
            {  
                stringBuilder.append(0);  
            }
            stringBuilder.append(hv);  
        }  
        return stringBuilder.toString();  
    }  
    /** 
     * Convert hex string to byte[] 
     * @param hexString the hex string 
     * @return byte[] 
     */  
    public static byte[] hexStringToBytes(String hexString) {  
        if (hexString == null || hexString.equals("")) {  
            return null;  
        }  
        hexString = hexString.toUpperCase();  
        int length = hexString.length() / 2;  
        char[] hexChars = hexString.toCharArray();  
        byte[] d = new byte[length];  
        for (int i = 0; i < length; i++) {  
            int pos = i * 2;  
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
        }  
        return d;  
    }  
    /** 
     * Convert char to byte 
     * @param c char 
     * @return byte 
     */  
    public static byte charToByte(char c) {  
        return (byte) "0123456789ABCDEF".indexOf(c);  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
