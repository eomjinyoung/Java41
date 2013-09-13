package net.bitacademy.java41.test;

import java.util.ArrayList;

/* Iterator 패턴
 * - 창고로부터 값을 꺼내는 방법을 객체화 
 * - 값을 꺼내려는 개발자는 일관된 방식으로 메서드를 호출하여 값을 꺼낼 수 있다.
 * - 예)
 * 저장소: [ , , , , , ...]
 * 
 * AscendentIterator : 값을 앞에서부터 뒤로 순차적으로 꺼낸다.
 * DescendantIterator : 값을 뒤에서 앞으로 순차적으로 꺼낸다.
 * EvenIterator : 짝수번째 값만 순차적으로 꺼낸다.
 * 
 * 프로그래밍의 일관성을 위해서 모든 꺼내는 역할자는 다음의 규칙을 따른다.
 * - hasNext() : 꺼낼게 있냐?
 * - next() : 꺼내라!
 */

interface Iterator {
	boolean hasNext();
	Object next();
}

class AscendentIterator implements Iterator {
	ArrayList list;
	int cursor = 0;
	
	public AscendentIterator(ArrayList list) {
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		if (list.size() > cursor) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		Object value = list.get(cursor);
		cursor++;
		return value;
	}
	
}

class DescendantIterator implements Iterator {
	ArrayList list;
	int cursor;
	
	public DescendantIterator(ArrayList list) {
		this.list = list;
		cursor = list.size() - 1;
	}
	
	@Override
	public boolean hasNext() {
		if (cursor < 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		Object value = list.get(cursor);
		cursor--;
		return value;
	}
	
}

class EvenIterator implements Iterator {
	ArrayList list;
	int cursor;
	
	public EvenIterator(ArrayList list) {
		this.list = list;
		cursor = 0;
	}
	
	@Override
	public boolean hasNext() {
		if (cursor < list.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		Object value = list.get(cursor);
		cursor += 2;
		return value;
	}
	
}

public class IteratorTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1111");
		list.add("2222");
		list.add("33333");
		list.add("4444");
		list.add("5555");
		list.add("6666");
		list.add("7777");
		list.add("8888");
		list.add("9999");
		
		//Iterator iterator = new AscendentIterator(list);
		//Iterator iterator = new DescendantIterator(list);
		Iterator iterator = new EvenIterator(list);
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		

	}

}









