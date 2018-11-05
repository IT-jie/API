package com.vst.defend.controller.note;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vst.common.tools.file.ToolsFile;
import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;

/**
 * 个人笔记
 * @author lhp
 * @date 2018-9-28 下午04:54:10
 * @version
 */
@Controller
public class NoteController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = NoteController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * Linux
	 * @return
	 */
	@RequestMapping("/note_linux")
	public String linuxNote(){
		try {
			this.initializeAction(_className);
			
			// 是否显示行号
			String nu = ToolsString.checkEmpty(request.getParameter("nu"));
			
			File file = new File("/home/help/linux.help");
			if(file.exists()){
				String content = ToolsFile.readFileToString(file, "utf-8");
				String[] arr = content.split("\n");
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<arr.length; i++){
					String str = arr[i];
					if("true".equals(nu)){
						sb.append("<div style='color:blue; width:50px; float:left;'>").append(i+1).append("</div> ").append(str).append("<br/>");
					}else{
						sb.append(str).append("<br/>");
					}
				}
				request.setAttribute("content", sb.toString());
			}else{
				request.setAttribute("content", "文件不存在");
			}
			request.setAttribute("title", "Linux");
		} catch(Exception e){
			logger.error("linuxNote error." + SystemException.getExceptionInfo(e));
		}
		return "note/myNote";
	}
	
	/**
	 * MySQL
	 * @return
	 */
	@RequestMapping("/note_mysql")
	public String mysqlNote(){
		try {
			this.initializeAction(_className);
			
			// 是否显示行号
			String nu = ToolsString.checkEmpty(request.getParameter("nu"));
			
			File file = new File("/home/help/mysql.help");
			if(file.exists()){
				String content = ToolsFile.readFileToString(file, "utf-8");
				String[] arr = content.split("\n");
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<arr.length; i++){
					String str = arr[i];
					if("true".equals(nu)){
						sb.append("<div style='color:blue; width:50px; float:left;'>").append(i+1).append("</div> ").append(str).append("<br/>");
					}else{
						sb.append(str).append("<br/>");
					}
				}
				request.setAttribute("content", sb.toString());
			}else{
				request.setAttribute("content", "文件不存在");
			}
			request.setAttribute("title", "MySQL");
		} catch(Exception e){
			logger.error("mysqlNote error." + SystemException.getExceptionInfo(e));
		}
		return "note/myNote";
	}
	
	/**
	 * Redis
	 * @return
	 */
	@RequestMapping("/note_redis")
	public String redisNote(){
		try {
			this.initializeAction(_className);
			
			// 是否显示行号
			String nu = ToolsString.checkEmpty(request.getParameter("nu"));
			
			File file = new File("/home/help/redis.help");
			if(file.exists()){
				String content = ToolsFile.readFileToString(file, "utf-8");
				String[] arr = content.split("\n");
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<arr.length; i++){
					String str = arr[i];
					if("true".equals(nu)){
						sb.append("<div style='color:blue; width:50px; float:left;'>").append(i+1).append("</div> ").append(str).append("<br/>");
					}else{
						sb.append(str).append("<br/>");
					}
				}
				request.setAttribute("content", sb.toString());
			}else{
				request.setAttribute("content", "文件不存在");
			}
			request.setAttribute("title", "Redis");
		} catch(Exception e){
			logger.error("redisNote error." + SystemException.getExceptionInfo(e));
		}
		return "note/myNote";
	}
	
	/**
	 * MongoDB
	 * @return
	 */
	@RequestMapping("/note_mongodb")
	public String mongodbNote(){
		try {
			this.initializeAction(_className);
			
			// 是否显示行号
			String nu = ToolsString.checkEmpty(request.getParameter("nu"));
			
			File file = new File("/home/help/mongodb.help");
			if(file.exists()){
				String content = ToolsFile.readFileToString(file, "utf-8");
				String[] arr = content.split("\n");
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<arr.length; i++){
					String str = arr[i];
					if("true".equals(nu)){
						sb.append("<div style='color:blue; width:50px; float:left;'>").append(i+1).append("</div> ").append(str).append("<br/>");
					}else{
						sb.append(str).append("<br/>");
					}
				}
				request.setAttribute("content", sb.toString());
			}else{
				request.setAttribute("content", "文件不存在");
			}
			request.setAttribute("title", "MongoDB");
		} catch(Exception e){
			logger.error("mongodbNote error." + SystemException.getExceptionInfo(e));
		}
		return "note/myNote";
	}
	
	/**
	 * SQLite
	 * @return
	 */
	@RequestMapping("/note_sqlite")
	public String sqliteNote(){
		try {
			this.initializeAction(_className);
			
			// 是否显示行号
			String nu = ToolsString.checkEmpty(request.getParameter("nu"));
			
			File file = new File("/home/help/sqlite.help");
			if(file.exists()){
				String content = ToolsFile.readFileToString(file, "utf-8");
				String[] arr = content.split("\n");
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<arr.length; i++){
					String str = arr[i];
					if("true".equals(nu)){
						sb.append("<div style='color:blue; width:50px; float:left;'>").append(i+1).append("</div> ").append(str).append("<br/>");
					}else{
						sb.append(str).append("<br/>");
					}
				}
				request.setAttribute("content", sb.toString());
			}else{
				request.setAttribute("content", "文件不存在");
			}
			request.setAttribute("title", "SQLite");
		} catch(Exception e){
			logger.error("sqliteNote error." + SystemException.getExceptionInfo(e));
		}
		return "note/myNote";
	}
	
	/**
	 * KDE
	 * @return
	 */
	@RequestMapping("/note_kde")
	public String kedNote(){
		try {
			this.initializeAction(_className);
			
			// 是否显示行号
			String nu = ToolsString.checkEmpty(request.getParameter("nu"));
			
			File file = new File("/home/help/kde.help");
			if(file.exists()){
				String content = ToolsFile.readFileToString(file, "utf-8");
				String[] arr = content.split("\n");
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<arr.length; i++){
					String str = arr[i];
					if("true".equals(nu)){
						sb.append("<div style='color:blue; width:50px; float:left;'>").append(i+1).append("</div> ").append(str).append("<br/>");
					}else{
						sb.append(str).append("<br/>");
					}
				}
				request.setAttribute("content", sb.toString());
			}else{
				request.setAttribute("content", "文件不存在");
			}
			request.setAttribute("title", "KDE");
		} catch(Exception e){
			logger.error("kedNote error." + SystemException.getExceptionInfo(e));
		}
		return "note/myNote";
	}
	
	/**
	 * Zookeeper
	 * @return
	 */
	@RequestMapping("/note_zookeeper")
	public String zookeeperNote(){
		try {
			this.initializeAction(_className);
			
			// 是否显示行号
			String nu = ToolsString.checkEmpty(request.getParameter("nu"));
			
			File file = new File("/home/help/zookeeper.help");
			if(file.exists()){
				String content = ToolsFile.readFileToString(file, "utf-8");
				String[] arr = content.split("\n");
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<arr.length; i++){
					String str = arr[i];
					if("true".equals(nu)){
						sb.append("<div style='color:blue; width:50px; float:left;'>").append(i+1).append("</div> ").append(str).append("<br/>");
					}else{
						sb.append(str).append("<br/>");
					}
				}
				request.setAttribute("content", sb.toString());
			}else{
				request.setAttribute("content", "文件不存在");
			}
			request.setAttribute("title", "Zookeeper");
		} catch(Exception e){
			logger.error("zookeeperNote error." + SystemException.getExceptionInfo(e));
		}
		return "note/myNote";
	}
	
	/**
	 * GitHub
	 * @return
	 */
	@RequestMapping("/note_github")
	public String githubNote(){
		try {
			this.initializeAction(_className);
			
			// 是否显示行号
			String nu = ToolsString.checkEmpty(request.getParameter("nu"));
			
			File file = new File("/home/help/GitHub.help");
			if(file.exists()){
				String content = ToolsFile.readFileToString(file, "utf-8");
				String[] arr = content.split("\n");
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<arr.length; i++){
					String str = arr[i];
					if("true".equals(nu)){
						sb.append("<div style='color:blue; width:50px; float:left;'>").append(i+1).append("</div> ").append(str).append("<br/>");
					}else{
						sb.append(str).append("<br/>");
					}
				}
				request.setAttribute("content", sb.toString());
			}else{
				request.setAttribute("content", "文件不存在");
			}
			request.setAttribute("title", "GitHub");
		} catch(Exception e){
			logger.error("githubNote error." + SystemException.getExceptionInfo(e));
		}
		return "note/myNote";
	}
	
}
