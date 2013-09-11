package net.bitacademy.java41.test;

import java.util.ArrayList;

public class ChainTest {
	interface OperatorProcessor {
		int execute(String op, int a, int b);
	}
	
	interface Filter {
		void doFilter();
	}
	
	public static void main(String[] args) {
		//old();
		//chain();
		filter();
	}
	
	public static void filter() {
		class LogFilter implements Filter {
			Filter next;
			public LogFilter(Filter next) {	this.next = next;}
			public void doFilter() {
				System.out.println("로그 처리 작업을 수행....");
				if (next != null) {
					next.doFilter();
				}
			}
		}
		
		class EncryptFilter implements Filter {
			Filter next;
			public EncryptFilter(Filter next) {	this.next = next;}
			public void doFilter() {
				System.out.println("암호해제 수행....");
				if (next != null) {
					next.doFilter();
				}
			}
		}
		
		class UnzipFilter implements Filter {
			Filter next;
			public UnzipFilter(Filter next) {	this.next = next;}
			public void doFilter() {
				System.out.println("압축 풀기 수행....");
				if (next != null) {
					next.doFilter();
				}
			}
		}
		
		class MyWork implements Filter {
			Filter next;
			public MyWork(Filter next) {	this.next = next;}
			public void doFilter() {
				System.out.println("원래 작업 수행....");
				if (next != null) {
					next.doFilter();
				}
			}
		}
		
		MyWork f1 = new MyWork(null);
		
		//EncryptFilter f3 = new EncryptFilter(f1);
		LogFilter f4 = new LogFilter(f1);
		//UnzipFilter f2 = new UnzipFilter(f4);
		
		f4.doFilter();
		
	}
	
	public static void chain() {
		class PlusOp implements OperatorProcessor {
			public int execute(String op, int a, int b) {
				if (op.equals("+")) {
					return a + b;
				} else {
					throw new RuntimeException("내꺼 아님!");
				}
			}
		}
		
		class MultipleOp implements OperatorProcessor {
			public int execute(String op, int a, int b) {
				if (op.equals("*")) {
					return a * b;
				} else {
					throw new RuntimeException("내꺼 아님!");
				}
			}
		}
		
		class DivideOp implements OperatorProcessor {
			public int execute(String op, int a, int b) {
				if (op.equals("/")) {
					return a / b;
				} else {
					throw new RuntimeException("내꺼 아님!");
				}
			}
		}
		
		ArrayList<OperatorProcessor> opList = new ArrayList<OperatorProcessor>();
		opList.add(new PlusOp());
		opList.add(new MultipleOp());
		opList.add(new DivideOp());
		
		String op = "/";
		int a = 20;
		int b = 30;
		
		for(OperatorProcessor operator : opList) {
			try {
				System.out.println(operator.execute(op, a, b));
				break;
			} catch (RuntimeException e) {}
		}

	}
	
	public static void old() {
		class Calculator {
			public int exec(String op, int a, int b) {
				if ("+".equals(op)) {
					return plus(a, b);
				} else if ("*".equals(op)) {
					return multiple(a, b);
				} else {
					throw new RuntimeException("해당 연산을 지원하지 않습니다.");
				}
			}
			private int plus(int a, int b) {
				return a + b;
			}
			private int multiple(int a, int b) {
				return a * b;
			}
		}
		
		Calculator calc = new Calculator();
		
		int result = calc.exec("*", 10, 20);
		
		System.out.println(result);
	}

}










