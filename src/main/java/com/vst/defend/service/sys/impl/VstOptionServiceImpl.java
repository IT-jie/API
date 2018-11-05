package com.vst.defend.service.sys.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.vst.common.tools.string.ToolsString;
import com.vst.defend.communal.exception.ErrorCode;
import com.vst.defend.communal.exception.SystemException;
import com.vst.defend.dao.sys.VstOptionDao;
import com.vst.defend.service.sys.VstOptionService;

/**
 * 
 * @author lhp
 * @date 2018-8-29 下午05:12:45
 * @version
 */
@Service
public class VstOptionServiceImpl implements VstOptionService {
	/**
	 * 写日志
	 */
	private static final Log logger = LogFactory.getLog(VstOptionServiceImpl.class);
	
	/**
	 * 系统配置Dao接口
	 */
	@Resource
	private VstOptionDao _vstOptionDao;
	
	/**
	 * 根据key获取value
	 */
	@Override
	public String getOptionValue(String key) throws SystemException {
		try {
			Map<String, Object> bean = _vstOptionDao.queryById(key);
			if(bean != null){
				return ToolsString.checkEmpty(bean.get("vst_option_value"));
			}
		} catch (Exception e) {
			logger.error("根据key获取value失败: " + SystemException.getExceptionInfo(e));
			throw new SystemException(ErrorCode.SERVICE_OPERATOR_FAILURE, e);
		}
		return null;
	}

}
