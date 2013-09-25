package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberService {
	@Autowired MemberDao memberDao;

	public void signUp(Member member) throws Exception {
		try {
			memberDao.add(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				for (String path : photos) {
					memberDao.addPhoto(member.getEmail(), path);
				}
			}
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	
	public List<Member> getMemberList() throws Exception {
		//return memberDao.list();
		return null;
	}
	
	public Member getMember(String email) throws Exception {
		//return memberDao.get(email);
		return null;
	}
	
	public boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
//		if (memberDao.changePassword(email, oldPassword, newPassword) > 0) {
//			return true;
//		} else {
//			return false;
//		}
		return true;
	}
}
