package net.bitacademy.java41.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;

@WebServlet("/member")
@SuppressWarnings("serial")
public class MemberServlet extends GenericServlet {
	private MemberDao memberDao;
	
	public MemberServlet() {
		DBConnectionPool dbpool = new DBConnectionPool(
				"jdbc:mysql://localhost/test", 
				"test", 
				"test",
				System.getProperty("driverClass"));
		memberDao = new MemberDao(dbpool);
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		//요청URL: http://localhost:9999/web01/member?command=list
		
		String command = request.getParameter("command");
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			if ("list".equals(command)) {
				list(request, response);
			} else if ("add".equals(command)) {
				// .../member?command=add&name=홍길동&phone=111&email=aaa&blog=aaa&age=12
				add(request, response);
			} else if ("view".equals(command)) {
				// .../member?command=view&email=aaa
				view(request, response);
			} else if ("delete".equals(command)) {
				// .../member?command=delete&email=aaa
				delete(request, response);
			} else if ("update".equals(command)) {
				// .../member?command=update&email=aaa&name=오호라2
				update(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("해당 명령어를 지원하지 않습니다!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void list(ServletRequest request, ServletResponse response) 
		throws Exception 
	{
		PrintWriter out = response.getWriter();
		List<Member> list = memberDao.list();

		for(Member m : list) {
			out.println(m.getName() + ","
				+ m.getPhone() + ","
				+ m.getEmail());
		}
	}

	private void add(ServletRequest request, ServletResponse response)
		throws Exception
	{
		Member m = new Member()
				.setName(request.getParameter("name"))
				.setPhone(request.getParameter("phone"))
				.setEmail(request.getParameter("email"))
				.setBlog(request.getParameter("blog"))
				.setAge( Integer.parseInt( request.getParameter("age") ) );

		memberDao.add(m);
		PrintWriter out = response.getWriter();
		out.println("등록되었습니다!");
	}

	private Member view(ServletRequest request, ServletResponse response) 
			throws Exception 
	{
		Member member = memberDao.get(request.getParameter("email"));
		
		PrintWriter out = response.getWriter();
		if (member != null) {
			out.println("이름:" + member.getName());
			out.println("전화:" + member.getPhone());
			out.println("이메일:" + member.getEmail());
			out.println("블로그:" + member.getBlog());
			out.println("나이:" + member.getAge());
			out.printf("등록일:%1$tY-%1$tm-%1$td \n", member.getRegDate());
			
			return member;
		} else {
			out.println("해당 이메일의 멤버가 없습니다.");
			return null;
		}
	}
	
	private void update(ServletRequest request, ServletResponse response) 
			throws Exception 
	{
		Member member = memberDao.get(request.getParameter("email"));
		Member copy = member.clone();
		
		String value = request.getParameter("name");
		if (value != null) {
			copy.setName(value);
		}
		
		value = request.getParameter("phone");
		if (value != null) {
			copy.setPhone(value);
		}
		
		value = request.getParameter("blog");
		if (value != null) {
			copy.setBlog(value);
		}
		
		value = request.getParameter("age");
		if (value != null) {
			copy.setAge( Integer.parseInt(value) );
		}

		int count = memberDao.change(copy);
		
		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.println("변경되었습니다!");
		} else {
			out.println("해당 이메일의 멤버를 찾을 수 없습니다.");
		}
	}

	private void delete(ServletRequest request, ServletResponse response) 
			throws Exception 
	{
		int count = memberDao.remove(request.getParameter("email"));
		
		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.println("삭제되었습니다!");
		} else {
			out.println("해당 이메일의 멤버를 찾을 수 없습니다!");
		}
	}
}
