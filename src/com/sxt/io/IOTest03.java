package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 *�ĸ����裺�ֶζ�ȡ �ļ��ֽ�������
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 * 
 */

public class IOTest03 {

	public static void main(String[] args) {
		//1������Դ
		File src =new File("abc.txt");
		//2��ѡ����
		InputStream is =null;
		
		try {
			 is =new FileInputStream(src);
	    //3���������ֶζ�ȡ��
			byte[] flush = new byte[1024];//��������
			int len =-1;//���ܳ���
			while ((len=is.read(flush))!=-1) {
				//�ֽ�����-->�ַ��������룩
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
				if (null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}