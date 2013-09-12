package net.bitacademy.java41.controls.member;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.dao.MemberDao;

public class MemberViewControl implements PageControl {
	MemberDao memberDao;
	
	public MemberViewControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		String email = params.get("email")[0];
		model.put("memberInfo", memberDao.get(email));
		
		return "/member/view.jsp";
	}
}













