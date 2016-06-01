package com.ziduye.modules.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "${adminPath}")
public class IndexController{

	
	@RequestMapping(value = {"/"})
	public String index() {
		return "index";
	}

}
