package com.fengcone.caption.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileHandler {
	private static Integer index = 0;

	public static void main(String[] args) throws Exception {
		PrintWriter writer = new PrintWriter(new File("D:\\Result0-1000.txt"));
		File file = new File("D:\\Down");
		getC(file, writer);
	}

	private static void getC(File file, PrintWriter writer) throws Exception {
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.isDirectory()) {
				getC(file2, writer);
			}
			if (file2.isFile()) {
				BufferedReader reader = new BufferedReader(
						new FileReader(file2));
				String line = "";
				while ((line = reader.readLine()) != null) {
					index++;
					if (index % 1000 == 0) {
						System.out.println(index);
						writer.close();
						String filename = "D:\\Result" + (index - 1000) + "-"
								+ index + ".txt";
						writer = new PrintWriter(new File(filename));
					}
					writer.println(line);
				}
				reader.close();
			}
		}
	}
}
