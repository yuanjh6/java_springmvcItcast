package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {

	//在handler执行之前处理
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("handler执行之前。。。。。Interceptor1");
		//返回true处理继续执行
		//返回false处理中断
		return true;
	}

	//在handler执行之后，返回ModelAndView之前执行
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//可以对modelAndView做一些处理
		System.out.println("handler执行之后。。。。。Interceptor1");
		
	}

	//整个流程处理完成之后执行
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//可以处理异常信息
		System.out.println("handler执行完成。。。。。Interceptor1");
	}

	

}
