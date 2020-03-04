package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 *
 * try...with...resource
 * 
 * 
 */

public class FIleUtils2 {
	public static void main(String[] args) {
		//�ļ����ļ�
		try {
			InputStream is = new FileInputStream("abc.txt");
			OutputStream os = new FileOutputStream("abc-copy.txt");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�ļ����ֽ�����
		byte[] datas = null;
		try {
			InputStream is = new FileInputStream("p.png");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is,os);
		    datas = os.toByteArray();
			System.out.println(datas.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//�ֽ����鵽�ļ�
		try {
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("p-copy.png");
			copy(is,os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * �Խ����������
	 * try...with...resource
	 * 
	 */
	
	
	public static void copy(InputStream is,OutputStream os) {
	//	try(is;os){   //JDK 9
		try {
		//3���������ֶζ�ȡ��
		byte[] flush = new byte[1024*1];//��������
		int len =-1;//���ܳ���
		while ((len=is.read(flush))!=-1) {
			os.write(flush, 0,len);//3���������ֶ�д����
		}
		os.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
		//4���ͷ���Դ
		try {
			if (null != os) {
				os.close();
			} 
		} catch (Exception e) {
			
		}
	
		}
	}
}

