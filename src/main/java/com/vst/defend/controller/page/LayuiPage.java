package com.vst.defend.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Layui框架
 * @author lhp
 * @date 2018-8-29 下午03:47:07
 * @version
 */
@Controller
public class LayuiPage {

	/**
	 * 测试页面
	 * @return
	 */
	@RequestMapping("/layui_hello")
	public String toLayuiHello(){
		return "layui/layui_hello";
	}
	
	/**
	 * 表单页面
	 * @return
	 */
	@RequestMapping("/layui_form")
	public String toLayuiForm(){
		return "layui/layui_form";
	}
}
