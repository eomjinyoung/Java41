package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired PlatformTransactionManager txManager;
	@Autowired MemberDao memberDao;

	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor=Throwable.class)
	public void signUp(Member member) throws Exception {
		try {
			memberDao.add(member);
			addMemberPhoto(member.getEmail(), member.getPhotos());
		} catch (Exception e) {
			throw e;
		} 
	}
	
	public List<Member> getMemberList() throws Exception {
		return memberDao.list();
	}
	
	public Member getMember(String email) throws Exception {
		Member member = memberDao.get(email);
		List<String> photos = memberDao.listPhoto(email);
		
		if (photos.size() > 0) {
			String[] photoNames = new String[photos.size()];
			photos.toArray(photoNames);
			member.setPhotos(photoNames);
		}
		
		return member;
	}
	
	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor=Throwable.class)
	public boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("oldPassword", oldPassword);
		paramMap.put("newPassword", newPassword);
		
		if (memberDao.changePassword(paramMap) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor=Throwable.class)
	public void updateMember(Member member) throws Exception {
		try {
			if (memberDao.update(member) == 0) {
				throw new Exception("멤버 변경 오류!");
			}
			
			memberDao.deleteAllPhoto(member.getEmail());
			addMemberPhoto(member.getEmail(), member.getPhotos());
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void addMemberPhoto(String email, String[] photoPaths) throws Exception {
		if (photoPaths != null) {
			HashMap<String,String> paramMap = new HashMap<String,String>();;
			paramMap.put("email", email);
			
			for (String path : photoPaths) {
				paramMap.put("path", path);
				memberDao.addPhoto(paramMap);
			}
		}
	}
	
	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor=Throwable.class)
	public void deleteMember(String email) throws Exception {
		try {
			memberDao.deleteAllPhoto(email);
			memberDao.delete(email);
		} catch (Exception e) {
			throw e;
		}
	}
}
