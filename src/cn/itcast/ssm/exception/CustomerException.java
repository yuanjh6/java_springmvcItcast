package cn.itcast.ssm.exception;
/**
 * 自定义异常
 * <p>Title: CustomerException</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.入云龙
 * @date	2015-5-29下午2:50:43
 * @version 1.0
 */
public class CustomerException extends Exception {

	private String message;
	
	public CustomerException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
