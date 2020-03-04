package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 *  �ļ��������ļ��ֽ����롢�����
 *
 */

public class Copy {

	/*
	 * ˼�������õݹ� �����ļ��еĿ���
	 * 
	 */
	public static void main(String[] args) {
     copy ("src/com/sxt/io/Copy.java","copy.txt");	
	}
	
	
	public static void copy(String srcPath,String destPath) {
		//1������Դ
//		File src =new File("p.png"); //Դͷ
//		File dest =new File("pcopy.png"); //Ŀ�ĵ�
		File src =new File(srcPath); //Դͷ
		File dest =new File(destPath); //Ŀ�ĵ�
		//2��ѡ����
		InputStream is =null;
		OutputStream os = null;
		try {
	    is =new FileInputStream(src);	
		os =new FileOutputStream(dest,true); //׷��
		
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

	}
	
	public static void copy2(String srcPath,String destPath) {
		//1������Դ
//		File src =new File("p.png"); //Դͷ
//		File dest =new File("pcopy.png"); //Ŀ�ĵ�
		File src =new File(srcPath); //Դͷ
		File dest =new File(destPath); //Ŀ�ĵ�
		//2��ѡ����
		
		try(InputStream is=new FileInputStream(src);
			OutputStream os=new FileOutputStream(dest,true);) {
	  
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
		}
		
	}
}