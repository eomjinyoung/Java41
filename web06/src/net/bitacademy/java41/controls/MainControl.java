package net.bitacademy.java41.controls;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;

public class MainControl implements PageControl {
	ProjectDao projectDao;
	
	public MainControl setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		Member member = (Member)session.getAttribute("member");
		
		List<MemberProject> list = 
				projectDao.listByMember(member.getEmail());
		
		session.setAttribute("myprojects", list);
	
		return "/main.jsp";
	}

}












