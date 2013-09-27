package net.bitacademy.java41.services;

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
public class MemberService {
	@Autowired PlatformTransactionManager txManager;
	@Autowired MemberDao memberDao;

	public void signUp(Member member) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		try {
			memberDao.add(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				for (String path : photos) {
					memberDao.addPhoto(member.getEmail(), path);
				}
			}
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
		if (memberDao.changePassword(email, oldPassword, newPassword) > 0) {
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
			
			String[] photos = member.getPhotos();
			if (photos != null) {
				for (String path : photos) {
					memberDao.addPhoto(member.getEmail(), path);
				}
			}
			txManager.commit(txStatus);
			
		} catch (Exception e) {
			txManager.rollback(txStatus);
			throw e;
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
