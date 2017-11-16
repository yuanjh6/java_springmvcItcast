package cn.itcast.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 自定义日期类型转换
 * <S, T>：S：Source 源数据类型 T：Target目标数据类型
 * <p>Title: MyConverter</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.入云龙
 * @date	2015-5-28下午5:42:01
 * @version 1.0
 */
public class MyConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {

		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
