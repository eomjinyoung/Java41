package net.bitacademy.java41.step08.test;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	
	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		/*
		 * Data sink stream class
		 * - 데이터를 직접 읽고 쓰는 클래스 
		 * 예) FileInputStream/FileOutputStream, FileReader/FileWriter
		 * ByteArrayInputStream/ByteArrayOutputStream,
		 * CharArrayReader/CharArrayWriter
		 * StringReader/StringWriter
		 * PopedInputStream/PopedOutputStream
		 * PopedReader/PopedWriter
		 */
		FileOutputStream out = new FileOutputStream("test1.data");
		
		/*
		 * Data processing stream class
		 * - 중간에서 데이터를 가공하는 역할
		 * - 위의 클래스를 제외한 모든 클래스
		 * - 구분하는 방법: 생성자에서 다른 스트림을 요구한다면 
		 *   이것은 혼자 입.출력을 할 수 없다는 뜻이기 때문에
		 *   데이터 가공 클래스라 할 수 있다.
		 */
		DataOutputStream out2 = new DataOutputStream(out);
		
		byte b = 0x34;
		short s = 0x0a34;
		int i = 0x0a0b0c34;
		char c = 0xac01;
		boolean bool = true;
		
		out2.writeByte(b);
		out2.writeShort(s);
		out2.writeInt(i);
		out2.writeChar(c);
		out2.writeBoolean(bool);
		
		out2.close();
		out.close();
		
		
	}

}










