package net.bitacademy.java41.services;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

public class AuthService {
	MemberDao memberDao;
	
	public AuthService setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	public Member getUserInfo(String email, String password) throws Exception {
		return memberDao.getMember(email, password);
	}
}














