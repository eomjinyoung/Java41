package net.bitacademy.java41.services;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceImpl implements AuthService {
	@Autowired MemberDao memberDao;
	
	public Member getUserInfo(String email, String password) throws Exception {
		return memberDao.getMember(email, password);
	}
}














