package com.vst.defend.service.sys;

import org.springframework.stereotype.Service;

import com.vst.defend.communal.exception.SystemException;

/**
 * 
 * @author lhp
 * @date 2018-8-29 下午05:12:17
 * @version
 */
@Service
public interface VstOptionService {
	/**
	 * 根据key获取value
	 * @param key
	 * @return
	 */
	String getOptionValue(String key) throws SystemException;
}
