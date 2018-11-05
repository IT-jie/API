package com.vst.common.tools.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author weiwei(joslyn)
 * @date 2016-8-5 下午08:49:57
 * @decription
 * @version 
 */
@SuppressWarnings("unchecked")
public class ToolsString {
	/**
	 *  null
	 */
	public static final String _NULL = null;
	
	/**
	 * 空字符串
	 */
	public static final String _EMPTY = "";
	
	/**
	 * 九宫格
	 */
	private static final Map<String, String> keynumMap = new HashMap<String, String>(9);
	
	/**
	 * 九宫格转字母
	 * @param keynum
	 * @return
	 */
	public static String getLetterByKeynum(String keynum){
		if(keynumMap.size() == 0){
			keynumMap.put("1", "1");
			keynumMap.put("2", "a,b,c");
			keynumMap.put("3", "d,e,f");
			keynumMap.put("4", "g,h,i");
			keynumMap.put("5", "j,k,l");
			keynumMap.put("6", "m,n,o");
			keynumMap.put("7", "p,q,r,s");
			keynumMap.put("8", "t,u,v");
			keynumMap.put("9", "w,x,y,z");
		}
		return keynumMap.get(keynum);
	}
	
	/**
	 * 校验字符串是否为null
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		return str == _NULL;
	}
	
	/**
	 * 校验字符串是否为空
	 * @param str null or 空字符串都归类为空
	 * @return true:为空，false：不为空
	 */
	public static boolean isEmpty(String str){
		if (str == null) {
			return true;
		}
		boolean flag = false;
		if (str.length() == 0 || str.trim().equals("")
				|| str.trim().equals("null")) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 判断该str对象是否为空,并且返回空字符串或者不为空的结果
	 * @param str
	 * @return 返回字符串
	 */
	public static String checkEmpty(String str) {
		String result = "";
		if (str != null && str.length() != 0 && !str.trim().equals("")
				&& !str.trim().equals("null")) {
			result = str;
		}
		return result;
	}

	/**
	 * 判断该str对象是否为空,并且返回空字符串或者不为空的结果
	 * @param str
	 * @return 返回字符串
	 */
	public static String checkEmpty(Object obj) {
		return checkEmpty(String.valueOf(obj));
	}
	
	/**
	 * 正则匹配
	 * @param str
	 * @param regx
	 * @return
	 */
	public static String matcher(String str, String regx){
		if(isEmpty(str) || isEmpty(regx)){
			return "";
		}
		
		Matcher m = Pattern.compile(regx).matcher(str);
		if(m.find()){
			return m.group(1);
		}
		return "";
	}
	
	/**
	 * 正则匹配
	 * @param str
	 * @param regx
	 * @return
	 */
	public static String matcher(String str, String regx, int i){
		if(isEmpty(str) || isEmpty(regx)){
			return "";
		}
		
		Matcher m = Pattern.compile(regx).matcher(str);
		while(m.find()){
			return m.group(i);
		}
		return "";
	}
	
	/**
	 * 将带有中括号的字符串类似   [《爱情转移》][《十年》][《浮夸》][《K歌之王》][《好久不见》]   替换成按照replacement分割的字符串
	 * <br>如果字符串不符合这种规格，或者替换的过程中出错，将返回源字符串
	 * @param str 源字符串
	 * @param replacement 分隔符
	 * */
	public static String replaceStr(String str,String replacement){
		String temp = "";
		String result = "";
		try {
			temp = checkEmpty(str);
			if(temp.indexOf("[") != -1 && temp.indexOf("]") != -1){
				String string = temp.replaceAll("\\]\\[", replacement);
				result  = string.substring(str.indexOf("[")+1, string.lastIndexOf("]"));
			}
		} catch (Exception e) {
			result = str;
		}
		return result;
	}
	
	/**
	 * 根据清晰度值来获取清晰度名称
	 * @param value
	 * @return
	 */
	public static String qxd(int value){
		String result = "";
		switch (value) {
		case 1:
			result = "标清";
			break;
		case 2:
			result = "高清";
			break;
		case 3:
			result = "超清";
			break;
		case 4:
			result = "蓝光";
			break;
		case 5:
			result = "3D";
			break;
		case 6:
			result = "原画";
			break;
		default:
			break;
		}
		return result;
	}
	
	/**
	 * 解析整数成位值数组
	 * @param src
	 * @return
	 */
	public static List<Long> parseToBitList(Long src){
		if(src == null || src.longValue() <= 0L){
			return Collections.EMPTY_LIST;
		}
		List<Long> list = new ArrayList<Long>();
		long root = 1L;
		for(int i = 0; i < 64; i++){
			if((src.longValue() & root) == root){
				list.add(root);
			}
			root = root << 1;
		}
		return list;
	}
	
	/**
	 * 解析整数属性值
	 * @param src
	 * @param propMap
	 * @return
	 */
	public static String parsePropValToString(Long src, Map<Long, String> propMap){
		if(src == null || src.longValue() <= 0L || propMap == null || propMap.isEmpty()){
			return "";
		}
		String result = "";
		long root = 1L;
		for(int i = 0; i < 64; i++){
			if((src.longValue() & root) == root){
				String value = propMap.get(root);
				if(!isEmpty(value)){
					result += value + ",";
				}
			}
			root = root << 1;
		}
		if(!isEmpty(result)){
			if(result.lastIndexOf(",") == result.length() - 1){
				result = result.substring(0, result.lastIndexOf(","));
			}
		}
		return result;
	}

	/**
	 * 判断一个字符是否为中文
	 * @param c
	 * @return
	 */
	public static final boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
            return true;  
        }  
        return false;  
    }
	
	/**
	 * 判断一个整个字符串是否为中文
	 * @param strName
	 * @return
	 */
	public static final boolean isChinese(String strName) {  
        char[] ch = strName.toCharArray();  
        for (int i = 0; i < ch.length; i++) {  
            char c = ch[i];  
            if (isChinese(c)) {
                return true;  
            }  
        }  
        return false;  
    }
}
