package net.bitacademy.java41.step08.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferTest {

	public static void main(String[] args) throws Exception {
		testWithoutBuffer();
		testWithBuffer();
	}
	
	public static void testWithoutBuffer() throws Exception {
		long start = System.currentTimeMillis();
		FileInputStream in = new FileInputStream("Android_DDMS.pdf");
		int i;
		while(true) {
			i = in.read();
			if (i == -1)
				break;
		}
		in.close();
		long end = System.currentTimeMillis();
		
		System.out.println("경과된 시간(초): " + (end - start) );
	}
	
	public static void testWithBuffer() throws Exception {
		long start = System.currentTimeMillis();
		FileInputStream in = new FileInputStream("Android_DDMS.pdf");
		BufferedInputStream in2 = new BufferedInputStream(in);
		int i;
		while(true) {
			i = in2.read();
			if (i == -1)
				break;
		}
		in2.close();
		in.close();
		long end = System.currentTimeMillis();
		
		System.out.println("경과된 시간(초): " + (end - start) );
	}

}
