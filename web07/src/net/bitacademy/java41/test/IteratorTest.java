package net.bitacademy.java41.test;

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







public class IteratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
