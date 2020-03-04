package com.sxt.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * �ֽ���������
 * 1������Դ:�ڲ�ά��
 * 2��ѡ������������Դ
 * 3��������д������)
 * 4���ͷ���Դ ���Բ���
 * 
 * 
 * ��ȡ���ݣ� toByteArray()
 */

public class IOTest08 {

	public static void main(String[] args) {
		//1������Դ
		byte[] dest = null;
		//2��ѡ����(����������
		ByteArrayOutputStream baos = null;
		try {
		baos =new ByteArrayOutputStream(); 
		//3��������д����
		String msg ="show me the code";
		byte[] datas = msg.getBytes();//�ַ���-->�ֽ����飨���룩
		baos.write(datas, 0, datas.length);
		baos.flush();
		//��ȡ����
		dest = baos.toByteArray();
		System.out.println(dest.length+"-->"+new String(dest,0,baos.size()));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4���ͷ���Դ
			try {
				if (null != baos) {
					baos.close();
				} 
			} catch (Exception e) {
				
			}
		}

	}

}
