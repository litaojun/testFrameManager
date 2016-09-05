package com.frame.test.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.mina.core.buffer.IoBuffer;
import org.xml.sax.SAXException;
//import com.gw.dzhyun.httptest.StorageProxyTest;
public class ReadFileUtil {
	public static ArrayList readFileToArrayList() throws FileNotFoundException,IOException
	{
		ArrayList sb = new ArrayList();
		FileReader reader;
		reader = new FileReader("c://litaojun.dat");
        BufferedReader br = new BufferedReader(reader);
        String str = null;
		while((str = br.readLine()) != null)
		{
			      sb.add(str);
			      //System.out.println(str);
		}
        br.close();
        reader.close();
        return sb;
	}
	public static ArrayList readFileToArrayListByFilePath(String filepath) throws FileNotFoundException,IOException
	{
		ArrayList sb = new ArrayList();
		FileReader reader;
		reader = new FileReader(filepath);
        BufferedReader br = new BufferedReader(reader);
        String str = null;
		while((str = br.readLine()) != null)
		{
			      sb.add(str);
			      //System.out.println(str);
		}
        br.close();
        reader.close();
        return sb;
	}
	public static void addArrayListToFile(ArrayList<String> al) throws IOException
	{
		  FileWriter writer;
		  writer = new FileWriter("c://test2.txt");
          BufferedWriter bw = new BufferedWriter(writer);
          for(String mystr:al)
          {
              bw.write(mystr+"\n");
          }
          bw.close();
          writer.close();
	}
	public static void writeByteToFile(String pathstr,ArrayList<byte[]> buffers) throws IOException 
	{
		FileOutputStream os = new FileOutputStream(pathstr);
		for(byte[] buffer:buffers)
		{
			writeByteToFile(os,buffer);
		}
		os.close();
	}
	public static void writeByteToFile(FileOutputStream os,byte[] buffer) throws IOException
	{
		//System.out.println("ReadFileUtil->writeByteToFile"+",buffer.len="+buffer.length);
		byte[] buff = formateByteArr(buffer);
		//System.out.println("ReadFileUtil->writeByteToFile---litaojun");
		printByte(buff);
		
		
		if(buff==null && buff.length == 0)
			return;
		int offset = 0;
		while(true)
		{
			//System.out.println("ReadFileUtil->writeByteToFile"+"offset="+offset+",buff.len="+buff.length);
			if(offset+1024 < buff.length)
		        os.write(buff, offset, 1024);
			else
			{
				os.write(buff, offset, buff.length - offset);
				break;
			}
			offset+=1024;
		}
		
	}
	public static byte[] formateByteArr(byte[] buffer)
	{
		if(buffer==null && buffer.length == 0)
			return null;
		IoBuffer buf = IoBuffer.allocate(buffer.length).setAutoExpand(true);
		int len = buffer.length;
		buf.putInt(len);
		buf.put(buffer);
		buf.flip();
		byte[] b = new byte[buf.limit()];  
		buf.get(b);   
		return b;
	}
	public static ArrayList<byte[]> iobuffToTypeArr(IoBuffer buf)
	{
		ArrayList<byte[]> bualt = new ArrayList<byte[]>();
		while(true)
		{
			//System.out.println("xxxbuf.limit = "+buf.limit()+",buf.position="+buf.position());
			if(buf.limit() == buf.position())
				break;
			int len = buf.getInt();
			byte[] tmb = new byte[len];
			buf.get(tmb);
			//printByte(tmb);
			bualt.add(tmb);
		}
		return bualt;
		
	}
	public static byte[] getByteArrSub(byte[] src,int len)
	{
		if(src == null && src.length<len)
			return src;
		byte[] retByte = new byte[len];
		for(int i=0;i<len;i++)
		{
			retByte[i] = src[i];
		}
		return retByte;
	}
	
	public static ArrayList<byte[]>  readFileToByteArr(String pathstr) throws IOException
	{
		IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);
		FileInputStream fis = new FileInputStream(pathstr);  
		byte[] buffer = new byte[1024];
		int temp  =0;
		while(true){
            temp = fis.read(buffer,0,buffer.length);
            //System.out.println("ReadFileUtil---->readFileToByteArr");
            //printByte(buffer);
            if(temp == -1){
                break;
            }
            if(temp<1024)
            {
            	 byte[]  tmpby = getByteArrSub(buffer,temp);
            	 buf.put(tmpby);
            }
            else
               buf.put(buffer);
	    }
		buf.flip();
		return iobuffToTypeArr(buf);
	}
	public static void printByte(byte[] bff)
	{
		//System.out.println("TestSvcStkinfoData->printByte--buffarr.length="+bff.length);
		for(byte a : bff)
		{
			System.out.println(a);
		}
	}
	public static void printByteArr(ArrayList<byte[]> buffs)
	{
		for(byte[] buffarr : buffs)
		{
			//System.out.println("TestSvcStkinfoData->print--buffarr.length="+buffarr.length);
			for(byte a : buffarr)
			{
				System.out.println(a);
			}
			System.out.println("\r\n");
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException ,IOException
	{
		 
	}
		
}
