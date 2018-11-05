package com.vst.common.tools.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import com.vst.common.tools.io.ToolsIO;
import com.vst.common.tools.string.ToolsString;

/**
 * @author weiwei
 * @date 2015-6-1 下午05:05:00
 * @description 
 * @version	
 */
public class ToolsFile {

	/**
	 * 默认编码格式
	 */
	private static final String _defaultCharset = "UTF-8";
	
	/**
	 * 校验文件是否合法
	 * @param file
	 */
	private static void checkFileBeforeRead(File file){
		if(file == null || !file.exists()){
			throw new UnsupportedOperationException("file not exist!");
		}
	}
	
	/**
	 * 校验文件是否合法
	 * @param file
	 */
	private static void checkFileBeforeWrite(File file){
		if(file == null || ToolsString.isEmpty(file.getPath())){
			throw new UnsupportedOperationException("file not exist!");
		}
		
		if(!file.exists()){
			file.getParentFile().mkdirs();
		}
	}
	
	/**
	 * 读取文件
	 * @param file
	 * @param charset
	 * @return
	 */
	public static String readFileToString(String file, String charset){
		// 如果文件路径为空
		if(ToolsString.isEmpty(file)){
			return null;
		}
		return readFileToString(new File(file), charset);
	}
	
	/**
	 * 从文件里面读取内容
	 * @param file
	 * @param charset
	 * @return
	 */
	public static String readFileToString(File file, String charset){
		checkFileBeforeRead(file);
		
		FileInputStream fis = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fis, ToolsString.isEmpty(charset) ? _defaultCharset : charset));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null){
				sb.append(line).append("\r\n");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		} finally {
			// 关流
			ToolsIO.closeStream(br, fis);
		}
		return null;
	}
	
	/**
	 * 从文件里面读取内容
	 * @param file
	 * @param charset
	 * @return
	 */
	public static byte[] readFileToByteArray(File file, String charset){
		checkFileBeforeRead(file);
		
		FileInputStream fis = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			return ToolsIO.toArray(fis);
		} catch (FileNotFoundException e) {
		} finally {
			// 关流
			ToolsIO.closeStream(br, fis);
		}
		return null;
	}
	
	/**
	 * 从文件里面读取内容
	 * @param file
	 * @return
	 */
	public static byte[] readFileToByteArray(File file){
		return readFileToByteArray(file, "utf-8");
	}
	
	/**
	 * 从文件里面读取内容
	 * @param filePath
	 * @return
	 */
	public static byte[] readFileToByteArray(String filePath){
		return readFileToByteArray(new File(filePath), "utf-8");
	}
	
	/**
	 * 写数据到文件
	 * @param file
	 * @param data
	 * @param charset
	 * @return
	 */
	public static boolean writeStringToFile(File file, String data, String charset){
		checkFileBeforeWrite(file);
		
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fos, ToolsString.isEmpty(charset) ? _defaultCharset : charset));
			bw.write(data);
			bw.flush();
			return true;
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		} finally {
			// 关流
			ToolsIO.closeStream(bw, fos);
		}
		return false;
	}
	
	/**
	 * 写字节数据到文件
	 * @param file
	 * @param bytes
	 * @param append
	 * @return
	 */
	public static boolean writeBytesToFile(File file, byte[] bytes, boolean append){
		checkFileBeforeWrite(file);
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file, append);
			fos.write(bytes);
			fos.flush();
			return true;
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		} finally {
			// 关流
			ToolsIO.closeStream(fos);
		}
		return false;
	}
	
	/**
	 * 写字节数据到文件
	 * @param file
	 * @param bytes
	 * @return
	 */
	public static boolean writeBytesToFile(File file, byte[] bytes){
		return writeBytesToFile(file, bytes, false);
	}
	
	/**
	 * gzip压缩写文件
	 * @param filePath
	 * @param data
	 * @param charset
	 * @return
	 */
	public static boolean gzipWriteFile(String filePath, String data, String charset){
		ByteArrayInputStream bis = null;
		FileOutputStream fos = null;
		GZIPOutputStream gos = null;
		try {
			bis = new ByteArrayInputStream(charset == null ? data.getBytes() : data.getBytes(charset));
			
			File file = new File(filePath);
			if(!file.exists()){
				file.getParentFile().mkdirs();
			}
			fos = new FileOutputStream(file);
			gos = new GZIPOutputStream(fos);
			
			byte[] buf = new byte[1024];
			int index = -1;
			while((index = bis.read(buf)) != -1){
				gos.write(buf, 0, index);
				gos.flush();
			}
			return true;
		} catch (Exception e) {
		} finally {
			ToolsIO.closeStream(gos, fos, bis);
		}
		return false;
	}
	
	/**
	 * gzip压缩写文件
	 * @param filePath
	 * @param data
	 * @return
	 */
	public static boolean gzipWriteFile(String filePath, String data){
		return gzipWriteFile(filePath, data, null);
	}
	
	/**
	 * 压缩文件
	 * @param srcFile
	 * @param destFile
	 * @return
	 */
	public static boolean gzipWriteFile(File srcFile, File destFile){
		if(srcFile != null && destFile != null){
			FileInputStream fis = null;
			ByteArrayOutputStream bos = null;
			try {
				if(!srcFile.exists()){
					srcFile.getParentFile().mkdirs();
				}
				
				if(!destFile.exists()){
					destFile.getParentFile().mkdirs();
				}
				
				fis = new FileInputStream(srcFile);
				bos = new ByteArrayOutputStream();
				
				byte[] buf = new byte[1024];
				int index = -1;
				while((index = fis.read(buf)) != -1){
					bos.write(buf, 0, index);
					bos.flush();
				}
				return gzipWriteFile(destFile, bos.toByteArray());
			} catch (Exception e) {
			} finally {
				ToolsIO.closeStream(bos, fis);
			}
		}
		return false;
	}
	
	/**
	 * gzip压缩写文件
	 * @param file
	 * @param bytes
	 * @return
	 */
	public static boolean gzipWriteFile(File file, byte[] bytes){
		if(file == null) return false;
		
		ByteArrayInputStream bis = null;
		FileOutputStream fos = null;
		GZIPOutputStream gos = null;
		try {
			bis = new ByteArrayInputStream(bytes);
			if(!file.exists()){
				file.getParentFile().mkdirs();
			}
			fos = new FileOutputStream(file);
			gos = new GZIPOutputStream(fos);
			
			byte[] buf = new byte[1024];
			int index = -1;
			while((index = bis.read(buf)) != -1){
				gos.write(buf, 0, index);
				gos.flush();
			}
			return true;
		} catch (Exception e) {
		} finally {
			ToolsIO.closeStream(gos, fos, bis);
		}
		return false;
	}
	
	/**
	 * 删除该文件夹下所有的文件
	 * @param directory
	 */
	public static void delFiles(File dir) {
		if (dir != null && dir.exists() && dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.isDirectory()) {
					// 递归去删除
					delFiles(file);
				} else {
					file.delete();
				}
			}
			// 删除文件夹
			dir.delete();
		}
	}
	
	/**
	 * 强制删除文件
	 * @param file
	 */
	public static void forceDelFile(File file){
		if(file == null) return;
		if(file.exists() && file.isFile()){
			int tryCount = 0;
			try {
				// 最多尝试三次
				do {
					tryCount++;
					file.delete();
				} while (file.exists() && tryCount < 3);
			} catch (Exception e) {
			}
		}
	}
	
	/**
	 * 关流
	 * @param close
	 */
	public static void closeStream(Closeable... close){
		if(close != null){
			for(Closeable c : close){
				if(c != null){
					try {
						c.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}
}
