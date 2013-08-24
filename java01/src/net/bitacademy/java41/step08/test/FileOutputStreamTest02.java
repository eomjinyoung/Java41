package net.bitacademy.java41.step08.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 상속
 * - 기존의 코드를 손대지 않고 기능을 확장하는 방법.
 * 		=> 기존의 코드를 건드리지 않으면 버그가 있을 가능성이 줄어든다.
 * - 기존의 소스 코드가 필요없다.
 */

class MyFileOutputStream extends FileOutputStream {

	public MyFileOutputStream(String name) throws FileNotFoundException {
		super(name);
	}
	
	public void writeBoolean(boolean i) throws IOException {
		if (i/* == true */) {
			write(1);
		} else {
			write(0);
		}
	}
	
	public void writeChar(char i) throws IOException {
		write(i >> 8);
		write(i);
	}
	
	public void writeShort(short i) throws IOException {
		write(i >> 8);
		write(i);
	}
	
	public void writeInt(int i) throws IOException {
		write(i >> 24);
		write(i >> 16);
		write(i >> 8);
		write(i);
	}
	
}

public class FileOutputStreamTest02 {
	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		MyFileOutputStream out = new MyFileOutputStream("test2.data");
		
		byte b = 0x11;
		short s = 0x0a11;
		int i = 0x0a0b0c11;
		char c = 0xac11;
		boolean bool = true;
		
		out.write(b);
		out.writeShort(s);
		out.writeInt(i);
		out.writeChar(c);
		out.writeBoolean(bool);
		
		out.close();
		
	}

}










