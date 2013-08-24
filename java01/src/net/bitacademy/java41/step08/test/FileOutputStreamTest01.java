package net.bitacademy.java41.step08.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Computer { 
	public void m1() {}
}
class DesktopPC extends Computer {
	public void m2() {}
}
class Notebook extends Computer {
	public void m3() {}
}
class Nono extends Computer {
	
}

public class FileOutputStreamTest01 {
	
	/* 다형성 : 다형적 변수(polymorphic variables)
	 * - X의 참조 변수는 X의 인스턴스 및 X의 서브 클래스의 인스턴스를 가리킬 수 있다.
	 */
	public void test() {
		DesktopPC c1 = new DesktopPC();
		c1.m1();
		c1.m2();
		//c1.m3();
		
		Notebook c2 = new Notebook();
		c2.m1();
		c2.m3();
		//c2.m2();
		
		Computer c3 = new DesktopPC();
		c3.m1();
		//c3.m2();
		
		Computer c32 = new Computer();
		Computer c4 = new Notebook();
		c4.m1();
		//c4.m3();
		
		//Notebook c5 = new DesktopPC();
		//Notebook c6 = new Computer();
		//c6.m3();
		
		//DesktopPC c7 = new Notebook();
		//DesktopPC c7 = new Computer();
	}
	
	public static void main(String[] args) 
			throws FileNotFoundException, IOException {
		FileOutputStream out = new FileOutputStream("test1.data");
		
		byte b = 0x34;
		short s = 0x0a34;
		int i = 0x0a0b0c34;
		char c = 0xac01;
		//boolean b = true;
		
		out.write(b);
		out.write(s >> 8);
		out.write(s);
		out.write(i >> 24);
		out.write(i >> 16);
		out.write(i >> 8);
		out.write(i);
		out.write(c >> 8);
		out.write(c);
		//out.write(b); 불가능
		
		out.close();
		
	}

}










