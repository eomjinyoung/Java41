package net.bitacademy.java41.test;

import java.io.File;

// File이라는 클래스를 이용하여 폴더를 탐색하는 방법
public class FileExplorerTest {

	public static void main(String[] args) throws Exception {
		File file = new File("./");
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		
		// 폴더에 포함되어 있는 자식 폴더 또는 파일들 목록을 리턴한다.
		/*
		File[] items = file.listFiles();
		for (File f : items) {
			System.out.println(f.getCanonicalPath());
		}*/
		
		printFileInfo(file);
		
		
	}
	
	public static void printFileInfo(File file) throws Exception {
		if (file.isFile()) {
			System.out.println(file.getName());
			
		} else if (file.isDirectory()) {
			System.out.println(file.getCanonicalPath());
			File[] childs = file.listFiles(); 
			for(File f : childs) {
				printFileInfo(f);
			}
		}
	}
	
}





