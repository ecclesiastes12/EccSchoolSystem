package com.sch.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("") //path declared in the properties file(context-path)
	public String viewHomPage() {
		return "index";
	}
}
