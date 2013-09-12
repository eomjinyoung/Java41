package net.bitacademy.java41.controls.member;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.MemberService;

public class MemberListControl implements PageControl {
	MemberService memberService;
	
	public MemberListControl setMemberService(MemberService memberService) {
		this.memberService = memberService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("list", memberService.getMemberList());
		
		return "/member/list.jsp";
	}
}













