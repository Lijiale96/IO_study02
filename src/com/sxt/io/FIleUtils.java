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
 * 1����װ����
 * 2����װ�ͷ���Դ
 */

public class FIleUtils {
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
	 * 
	 */
	
	public static void copy(InputStream is, OutputStream os) {
		
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
			//4���ͷ���Դ  �ֱ�ر� �ȴ򿪵ĺ�ر�
			close(is,os);
			
		}

	}
	
	/*
	 * �ͷ���Դ
	 * 
	 * 
	 */
	public static void close(InputStream is,OutputStream os) {
	try {	
		if (null != os) {
			os.close();
		} 
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		if (null!=is) {
			is.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

/*
 * �ͷ���Դ
 * 
 */
public static void close(Closeable... ios) {
	for (Closeable io : ios) {
		try {
			if (null!=io) {
				io.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
}
