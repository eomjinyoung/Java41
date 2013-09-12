package net.bitacademy.java41.services;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

public class MemberService {
	MemberDao memberDao;
	
	public MemberService setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	public void signUp(Member member) throws Exception {
		memberDao.add(member);
	}
}
