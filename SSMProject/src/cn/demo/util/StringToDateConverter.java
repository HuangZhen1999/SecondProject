package cn.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 *	将String转换为Date的自定义转换器 
 * @author 黄震
 *
 */

public class StringToDateConverter implements Converter<String , Date>{

	private String datePattern;
	
	public StringToDateConverter() {}
	
	public StringToDateConverter(String datePattern) {
		this.datePattern = datePattern;
	}
	
	@Override
	public Date convert(String source) {
		Date date = null;
		try {
			date = new SimpleDateFormat(datePattern).parse(source);
		} catch (ParseException e) {
			e.printStackTrace(); 
		}
		return date;
	}
}
