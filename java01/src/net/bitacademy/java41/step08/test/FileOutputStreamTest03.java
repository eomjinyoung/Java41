package net.bitacademy.java41.step08.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class MyFileOutputStream2 extends OutputStream {
	private OutputStream origin;
	
	public MyFileOutputStream2(OutputStream origin) throws FileNotFoundException {
		this.origin = origin;
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

	@Override
	public void write(int b) throws IOException {
		origin.write(b);
	}
	
}

public class FileOutputStreamTest03 {
	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		FileOutputStream out1 = new FileOutputStream("test3.data");
		MyFileOutputStream2 out2 = new MyFileOutputStream2(out1);
		
		byte b = 0x11;
		short s = 0x0a11;
		int i = 0x0a0b0c11;
		char c = 0xac11;
		boolean bool = true;
		
		out2.write(b);
		out2.writeShort(s);
		out2.writeInt(i);
		out2.writeChar(c);
		out2.writeBoolean(bool);
		
		out2.close();
		out1.close();
	}

}










