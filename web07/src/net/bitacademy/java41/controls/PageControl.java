package net.bitacademy.java41.controls;

import java.util.Map;

/* 프론트컨트롤러와 페이지 컨트롤러의 호출 규칙
 * DispatcherServlet은 다음 규칙에 따라 페이지 컨트롤러를 호출해야 한다.
 * - 사용자의 요청을 페이지 컨트롤러에 위임할 때, 
 *   파라미터 데이터를 Map에 담아서 넘긴다. 
 */
public interface PageControl {
	String execute(Map<String,Object> model) throws Exception;
}
