package net.bitacademy.java41.controls;

import java.util.Map;

public class SigninFormControl implements PageControl {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return "/member/signinForm.jsp";
	}
}











