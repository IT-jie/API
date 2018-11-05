package com.vst.common.tools.io;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author weiwei
 * @date 2015-9-30 下午05:51:05
 * @description 
 * @version	
 */
public class ToolsIO {

	/**
	 * 把输入流转换成字符串
	 * @param is
	 * @return
	 */
	public static String toString(InputStream is, String encoding){
		byte[] array = toArray(is);
		if(array != null){
			try {
				return new String(array, encoding);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}
	
	/**
	 * 把输入流转换成字符串
	 * @param is
	 * @return
	 */
	public static String toString(InputStream is){
		return toString(is, "utf-8");
	}
	
	/**
	 * 转换成字节数组
	 * @param is
	 * @return
	 */
	public static byte[] toArray(InputStream is){
		if(is != null){
			ByteArrayOutputStream baos = null;
			try {
				baos = new ByteArrayOutputStream();
				byte[] buf = new byte[2 << 8];
				int len = -1;
				
				while((len = is.read(buf)) != -1){
					baos.write(buf, 0, len);
					baos.flush();
				}
				return baos.toByteArray();
			} catch (UnsupportedEncodingException e) {
			} catch (IOException e) {
			} finally {
				closeStream(baos, is);
			}
		}
		return null;
	}
	
	/**
	 * 关流
	 * @param close
	 */
	public static void closeStream(Closeable... close){
		if(close != null){
			try {
				for(Closeable c : close){
					if(c != null){
						c.close();
					}
				}
			} catch (IOException e) {
			}
		}
	}
}
