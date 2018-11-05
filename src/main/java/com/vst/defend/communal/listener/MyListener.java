package com.vst.defend.communal.listener;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author weiwei
 * @date 2014-7-8 下午05:41:04
 * @description
 * @version
 */
public class MyListener extends HttpServlet {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1485476537907917273L;
	
	/**
	 * 写日志
	 */
	private static final Log logger = LogFactory.getLog(MyListener.class);
	
	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		try {
		} catch (Exception e) {
			logger.error("init cache property error. ERROR:", e);
		} 
	}
}
