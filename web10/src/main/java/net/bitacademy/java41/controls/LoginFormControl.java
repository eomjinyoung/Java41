package net.bitacademy.java41.controls;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
/*
 * @Conroller 애노테이션
 * . DispatcherServlet(프론트 컨트롤러)에게 이 객체가 페이지 컨트롤러임을 선언한다.
 * . @RequestMapping(요청URL) 정보를 읽어서 '요청URL'과 같은 요청이 들어오면,
 *   해당 메서드를 호출할 것을 지정한다.
 *   
 * @Component 애노테이션
 * . 만약 이 애노테이션을 선언하게 되면, DipatcherServlet은 일반 객체로 취급한다.
 * . 요청처리와 상관없게 된다.
 * 
 */
@Controller
public class LoginFormControl implements PageControl {
	
	@RequestMapping("/auth/loginForm.do")
	@Override
	public String execute(Map<String,Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String> cookies = (Map<String,String>)model.get("cookies");
		
		/*
		String email = "";
		boolean isSaveId = false;
		if (cookies.get("email") != null) {
			email = cookies.get("email");
			isSaveId = true;
		}
		*/
		String email = "";
		boolean isSaveId = false;
		
		model.put("email", email);
		model.put("isSaveId", isSaveId);
		
		return "/auth/LoginForm.jsp";
	}
}







