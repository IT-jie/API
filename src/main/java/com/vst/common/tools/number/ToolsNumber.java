package com.vst.common.tools.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vst.common.tools.string.ToolsString;

/**
 * @author Administrator
 *
 */
public class ToolsNumber {

	/**
	 * 写日志
	 */
	private static final Log logger = LogFactory.getLog(ToolsNumber.class);
	
	private ToolsNumber(){
		
	}
	
	/**
	 * 格式化字符串成数字
	 * @param str
	 * @return
	 */
	public static int parseInt(String str){
		// 如果字符串为空，直接返回-1
		return parseInt(str, -1);
	}
	
	/**
	 * 格式化字符串成数字
	 * @param str
	 * @return
	 */
	public static int parseInt(String str, int defaultValue){
		// 如果字符串为空，直接返回defaultValue
		if(ToolsString.isEmpty(str)){
			return defaultValue;
		}
		
		int result = defaultValue;
		try {
			if(isNumber(str) && str.trim().length() < 12){
				result = Integer.parseInt(str.trim());
			}
		} catch (NumberFormatException e) {
			logger.error("Format number error. ERROR:" + e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * 格式化字符串成数字
	 * @param str
	 * @return
	 */
	public static long parseLong(String str){
		return parseLong(str, -1L);
	}
	
	/**
	 * 格式化字符串成数字
	 * @param str
	 * @return
	 */
	public static long parseLong(String str, long defaultValue){
		// 如果字符串为空，直接返回-1
		if(ToolsString.isEmpty(str)){
			return defaultValue;
		}
		
		long result = defaultValue;
		try {
			if(isNumber(str) && str.trim().length() < 20){
				result = Long.parseLong(str.trim());
			}
		} catch (NumberFormatException e) {
			logger.error("Format number error. ERROR:" + e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * 格式化字符串成数字
	 * @param str
	 * @return
	 */
	public static double parseDouble(String str){
		return parseDouble(str, -1.0d);
	}
	
	/**
	 * 格式化字符串成数字
	 * @param str
	 * @return
	 */
	public static double parseDouble(String str, double defaultValue){
		// 如果字符串为空，直接返回-1
		if(ToolsString.isEmpty(str)){
			return defaultValue;
		}
		
		double result = defaultValue;
		try {
			if(isDecimal(str)){
				result = Double.parseDouble(str.trim());
			}
		} catch (NumberFormatException e) {
			logger.error("Format number error. ERROR:" + e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * 格式化字符串成数字
	 * @param str
	 * @return
	 */
	public static float parseFloat(String str){
		return parseFloat(str, -1L);
	}
	
	/**
	 * 格式化字符串成数字
	 * @param str
	 * @return
	 */
	public static float parseFloat(String str, float defaultValue){
		// 如果字符串为空，直接返回-1
		if(ToolsString.isEmpty(str)){
			return defaultValue;
		}
		
		float result = defaultValue;
		try {
			if(isNumber(str) && str.trim().length() < 20){
				result = Float.parseFloat(str.trim());
			}
		} catch (NumberFormatException e) {
			logger.error("Format number error. ERROR:" + e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * 判断字符串是否是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		if(ToolsString.isEmpty(str)) return false;
		if(Pattern.matches("^(-)?[0-9]+$", str.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否是数字
	 * @param str
	 * @return
	 */
	public static boolean isDecimal(String str){
		if(ToolsString.isEmpty(str)) return false;
		if(Pattern.matches("^(-)?[0-9]+((.)[0-9]+)?$", str.trim())){
			return true;
		}
		return false;
	}
	
	public static String formatHits(long hits){
		if(hits > 10000 && hits < 100000000){
			DecimalFormat df = new DecimalFormat("#.0");
			return df.format((double)hits / 10000) + "万次";
		}
		
		if(hits > 100000000){
			DecimalFormat df = new DecimalFormat("#.0");
			return df.format((double)hits / 10000) + "亿次";
		}
		return hits + "次";
	}
	
	public static String formatHits(long hits, String cell){
		if(hits > 10000 && hits < 100000000){
			DecimalFormat df = new DecimalFormat("#.00");
			return df.format((double)hits / 10000) + "万" + cell;
		}
		
		if(hits > 100000000){
			DecimalFormat df = new DecimalFormat("#.00");
			return df.format((double)hits / 100000000) + "亿" + cell;
		}
		return hits + cell;
	}
	
	/**
	 * 数字型汉字转换成阿拉伯数字
	 * 2014-10-9
	 * @param s
	 * @return
	 */
	public static Long ZWToNumber(String s){
		String[] str = {"一","二","三","四","五","六","七","八","九","十","十一","十二","十三","十四","十五","十六","十七","十八","十九","二十","二十一","二十二","二十三","二十四","二十五","二十六","二十七","二十八","二十九","三十"};
		Long[] l = {1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L,13L,14L,15L,16L,17L,18L,19L,20L,21L,22L,23L,24L,25L,26L,27L,28L,29L,30L};
		for(int i = 0;i < str.length; i ++){
			if(str[i].equals(s)){
				return l[i]; 
			}
		}
		
		return null;
	}
	
	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}
}
