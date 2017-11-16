package cn.itcast.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 全局异常处理类
 * <p>Title: GlobalExceptionResolver</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.入云龙
 * @date	2015-5-29下午2:53:21
 * @version 1.0
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception exception) {
		
		String message = "";
		//判断异常类型
		if (exception instanceof CustomerException) {
			message = exception.getMessage();
		} else {
			message = "未知错误，请克服一下哦~~~";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
