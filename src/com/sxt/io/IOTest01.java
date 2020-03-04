package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 * ��һ����������������
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * 
 */

public class IOTest01 {

	public static void main(String[] args) {
		//1������Դ
		File src =new File("abc.txt");
		//2��ѡ����
		try {
			InputStream is =new FileInputStream(src);
	   //3����������ȡ��
			int data1= is.read();//��һ������  h
			int data2= is.read();//�ڶ�������  e
			int data3= is.read();//����������  l
			int data4= is.read();//���ĸ�����  �������ݣ��ļ��Ľ�β����-1
			System.out.println((char)data1);
			System.out.println((char)data2);
			System.out.println((char)data3);
			System.out.println(data4);
		//4���ͷ���Դ
		is.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
  
	}

}
