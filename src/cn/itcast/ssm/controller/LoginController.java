package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户登录Controller
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.入云龙
 * @date	2015-5-29下午5:27:42
 * @version 1.0
 */
@Controller
public class LoginController {

	//跳转到登录页面，没有参数
	@RequestMapping("/login")
	public String login() throws Exception {
		return "login";
	}
	
	@RequestMapping("/loginSubmit")
	public String loginSubmit(String username, String password, 
			HttpSession session) throws Exception {
		session.setAttribute("username", username);
		//登录成功跳转到商品列表
		return "redirect:/items/list.action";
	}
}
