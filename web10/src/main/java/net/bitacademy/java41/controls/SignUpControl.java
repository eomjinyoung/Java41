package net.bitacademy.java41.controls;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/signup")
public class SignUpControl {
	@Autowired ServletContext sc;
	@Autowired MemberService memberService;
	long currTime = 0;
	int count = 0;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "/member/signupForm.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String signup(
			Member member,
			MultipartFile photo,
			HttpSession session) throws Exception {
		String filename = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + filename;
		photo.transferTo(new File(path));
		
		member.setPhotos(new String[]{filename});
		
		memberService.signUp(member);
		session.setAttribute("member", member);
		
		return "redirect:../main.do";
	}
	
	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis(); //1000
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "member_" + millis + "_" + (++count);
	}
}











