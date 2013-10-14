package net.bitacademy.java41.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.vo.LoginInfo;
import net.bitacademy.java41.vo.Member;

public interface MemberDao {
	LoginInfo getLoginInfo(Map<String,String> paramMap) throws Exception;
	
	int add(Member member) throws Exception;
	
	List<Member> list() throws Exception;
	
	Member get(String email) throws Exception;
	
	int changePassword (Map<String,String> paramMap) throws Exception;
	
	int update(Member member) throws Exception;
	
	int delete(String email) throws Exception;

	void addPhoto(Map<String,String> paramMap) throws Exception;
	
	List<String> listPhoto(String email) throws Exception;
	
	void deleteAllPhoto(String email) throws Exception;
}




