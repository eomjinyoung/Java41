package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class MemberServiceImpl implements MemberService {
	@Autowired PlatformTransactionManager txManager;
	@Autowired MemberDao memberDao;

	public void signUp(Member member) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		try {
			memberDao.add(member);
			addMemberPhoto(member.getEmail(), member.getPhotos());

			txManager.commit(txStatus);
			
		} catch (Exception e) {
			txManager.rollback(txStatus);
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
	
	public void updateMember(Member member) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		try {
			if (memberDao.udpate(member) == 0) {
				throw new Exception("멤버 변경 오류!");
			}
			
			memberDao.deleteAllPhoto(member.getEmail());
			addMemberPhoto(member.getEmail(), member.getPhotos());
			
			txManager.commit(txStatus);
			
		} catch (Exception e) {
			txManager.rollback(txStatus);
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
	
	public void deleteMember(String email) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		try {
			memberDao.deleteAllPhoto(email);
			memberDao.delete(email);
			
			txManager.commit(txStatus);
			
		} catch (Exception e) {
			txManager.rollback(txStatus);
			throw e;
		}
	}
}
