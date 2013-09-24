package net.bitacademy.java41.controls.project;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;

@Component("/project/addForm.do")
public class ProjectAddFormControl implements PageControl {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return "/project/newForm.jsp";
	}
}













