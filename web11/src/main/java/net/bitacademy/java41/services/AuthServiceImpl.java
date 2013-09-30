package net.bitacademy.java41.services;

import java.util.HashMap;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired MemberDao memberDao;
	
	public Member getUserInfo(String email, String password) throws Exception {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		
		return memberDao.getMember(paramMap);
	}
}














