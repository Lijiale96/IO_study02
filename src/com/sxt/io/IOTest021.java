package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 * ��һ����������������  ��׼
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * 
 */

public class IOTest021 {

	public static void main(String[] args) {
		//1������Դ
		File src =new File("abc.txt");
		//2��ѡ����
		InputStream is =null;
		
		try {
			is = new FileInputStream(src);
		//3��������ȡ	
			int temp;
			while ((temp=is.read())!=-1) {
				System.out.println((char)temp);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
//		InputStream is =null;
//		try {
//			 is =new FileInputStream(src);
//	    //3����������ȡ��
//			int temp;
//			while ((temp=is.read())!=-1) {
//				System.out.println((char)temp);
//			}
//		
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//		//4���ͷ���Դ
//			try {
//				if (null!=is) {
//					is.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
