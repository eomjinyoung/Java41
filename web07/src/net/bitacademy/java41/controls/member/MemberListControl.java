package net.bitacademy.java41.controls.member;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.dao.MemberDao;

public class MemberListControl implements PageControl {
	MemberDao memberDao;
	
	public MemberListControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("list", memberDao.list());
		
		return "/member/list.jsp";
	}
}













