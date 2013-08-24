package net.bitacademy.java41.step08.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 학습목표: 
// - 객체를 저장 => ObjectInputStream/ObjectOutputStream (Data Process Stream)
// - java.io.Serializable 인터페이스의 의미 
// - SerialUID 변수

// * java.io.Serializable
// - 이 인터페이스를 구현한 클래스 만이 인스턴스를 바이트 배열로 자동 변환할 수 있다.(serialize)
//   또는 바이트 배열을 인스턴스로 복원할 수 있다.(deserialize)
class Member implements java.io.Serializable {
	// Serialize한 데이터를 구분하기 위한 버전 번호이다.
	// 이것은 읽을 때 구분 용도로 사용한다.
	// 선택이다. 그러나 serialize 대상 클래스라면 설정하는 것이 좋다.
	private static final long serialVersionUID = 1L;
	
	// - 만약, 개발자가 명시적으로 serialVersionUID를 선언하지 않는다면,
	//   컴파일러가 인스턴스의 타입과 변수, 개수에 의존하여 자동으로 버전 번호를 생성한다.
	// - 순서가 달라도 변수의 개수와, 이름과 타입이 같다면 버전 번호도 같다.
	
	
	String name;
	String tel;
	int age;
	int gender;
}

public class ObjectIOTest {

	public static void main(String[] args) throws Exception {
		//save();
		// 2. serialize 된 데이터를 읽어서 인스턴스로 복원하기
		read();
	}

	private static void read() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		FileInputStream in = new FileInputStream("members.data");
		ObjectInputStream in2 = new ObjectInputStream(in);
		
		Member x1 = (Member)in2.readObject();
		Member x2 = (Member)in2.readObject();
		
		in2.close();
		in.close();
		
		System.out.println(x1.name);
		System.out.println(x2.name);
	}

	private static void save() throws FileNotFoundException, IOException {
		// 1. 객체 출력
		Member m1 = new Member();
		m1.name = "홍길동";
		m1.tel = "111-1111";
		m1.age = 20;
		
		Member m2 = new Member();
		m2.name = "임꺽정";
		m2.tel = "222-2222";
		m2.age = 30;
		
		FileOutputStream out = new FileOutputStream("members.data");
		ObjectOutputStream out2 = new ObjectOutputStream(out);
		
		out2.writeObject(m1);
		out2.writeObject(m2);
		
		out2.close();
		out.close();

		System.out.println("저장 완료되었습니다!");
	}

}









