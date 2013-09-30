package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.vo.Member;

public interface MemberService {
	void signUp(Member member) throws Exception;
	
	List<Member> getMemberList() throws Exception;
	
	Member getMember(String email) throws Exception;
	
	boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception;
	
	void updateMember(Member member) throws Exception;
	
	void deleteMember(String email) throws Exception;
}
