package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/*
 * �������裺�ֶζ�ȡ �ļ��ַ�������
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * 
 */

public class IOTest05 {

	public static void main(String[] args) {
		//1������Դ
		File src =new File("abc.txt");
		//2��ѡ����
		Reader reader =null;
		
		try {
			 reader =new FileReader(src);
	    //3���������ֶζ�ȡ��
			char[] flush = new char[1024];//��������
			int len =-1;//���ܳ���
			while ((len=reader.read(flush))!=-1) {
				//�ֽ�����-->�ַ�����
			String str = new String(flush,0,len);
			System.out.println(str);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
		//4���ͷ���Դ
			try {
				if (null!=reader) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
