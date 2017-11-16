package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	//在handler执行之前处理
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("handler执行之前。。。。。Interceptor2");
		//判断是否是登录页面的url
		String requestURI = request.getRequestURI();
		if (requestURI.contains("login.action") || 
				requestURI.contains("loginSubmit.action")) {
			return true;
		}
		//判断用户是否登录
		String username = (String) request.getSession().getAttribute("username");
		if (null != username && !"".equals(username)) {
			return true;
		}
		//用户未登录跳转到登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		//返回true处理继续执行
		//返回false处理中断
		return false;
	}

	//在handler执行之后，返回ModelAndView之前执行
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//可以对modelAndView做一些处理
		System.out.println("handler执行之后。。。。。Interceptor2");
	}

	//整个流程处理完成之后执行
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//可以处理异常信息
		System.out.println("handler执行完成。。。。。Interceptor2");
	}

	

}
