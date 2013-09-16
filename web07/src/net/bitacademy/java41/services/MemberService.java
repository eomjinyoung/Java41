package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

@Component
public class MemberService {
	MemberDao memberDao;
	
	public MemberService setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	public void signUp(Member member) throws Exception {
		memberDao.add(member);
	}
	
	public List<Member> getMemberList() throws Exception {
		return memberDao.list();
	}
	
	public Member getMember(String email) throws Exception {
		return memberDao.get(email);
	}
	
	public boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		if (memberDao.changePassword(email, oldPassword, newPassword) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
