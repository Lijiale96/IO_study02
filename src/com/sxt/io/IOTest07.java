package com.sxt.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

/*
 * �ĸ����裺�ֽ�����������
 * 1������Դ:�ֽ����鲻Ҫ̫��
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ�����Բ��ô���
 */

public class IOTest07 {

	public static void main(String[] args) {
		//1������Դ
		byte[] src ="talk is cheap show me the code".getBytes();
		//2��ѡ����
          InputStream is =null;
		
		try {
			 is =new ByteArrayInputStream(src);
	    //3���������ֶζ�ȡ��
			byte[] flush = new byte[5];//��������
			int len =-1;//���ܳ���
			while ((len=is.read(flush))!=-1) {
				//�ֽ�����-->�ַ��������룩
			String str = new String(flush,0,len);
			System.out.println(str);
			}
		
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