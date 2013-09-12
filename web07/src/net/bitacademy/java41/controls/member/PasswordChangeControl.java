package net.bitacademy.java41.controls.member;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.dao.MemberDao;

public class PasswordChangeControl implements PageControl {
	MemberDao memberDao;
	
	public PasswordChangeControl setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		
		if (params.get("password") == null) {
			return form();
		} else {
			return changePassword(model);
		}
	}
	
	protected String form() {
		return "/member/passwordForm.jsp";
	}
	
	protected String changePassword(Map<String, Object> model)
			throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 
				(Map<String,String[]>)model.get("params");
		
		String email = params.get("email")[0];
		String oldPassword = params.get("password")[0];
		String newPassword = params.get("newPassword")[0];
		String newPassword2 = params.get("newPassword2")[0];
		
		if (newPassword.equals(newPassword2)) {
			if (memberDao.changePassword(email, oldPassword, newPassword) > 0) {
				model.put("status", "SUCCESS");
			} else {
				model.put("status", "OLD_PASSWORD_ERROR");
			}
		} else {
			model.put("status", "NEW_PASSWORD_ERROR");
		}
		
		return "/member/passwordChangeResult.jsp";
	}
}











