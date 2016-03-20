package com.fengcone.caption.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

public class CaptionFilehandler {
	public static void main(String[] args) {
		File file = new File("D:\\Caption\\字幕资料文件");
		Set<String> fileNames = new HashSet<String>();
		CC(file, fileNames);
		for (String string : fileNames) {
			System.out.println(string);
		}
		
	}
	
	private static void CC(File file0 ,Set<String> fileNames){
		File [] files = file0.listFiles();
		for (File file : files) {
			try {
				if (file.isDirectory()) {
					CC(file, fileNames);
				}else {
					if (file.getName().contains("英文")&& file.getName().endsWith("srt")) {
						File newFile = new File("D:\\Caption\\ass\\"+file.getName());
						newFile.createNewFile();
						copyFile(file, newFile);
						break;
					}
					System.out.println(file.getAbsolutePath());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
	}
	
	private static void copyFile(File oldFile,File newFile) throws Exception{
		FileInputStream fis = new FileInputStream(oldFile);
		FileOutputStream fos = new FileOutputStream(newFile);
		int length;
		byte []b = new byte[1024];
		while ((length = fis.read(b))!=-1) {
			fos.write(b,0,length);
		}
		fos.flush();
		fis.close();
		fos.close();
	}
}
