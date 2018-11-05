package com.vst.defend.service.api;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vst.defend.communal.exception.SystemException;

/**
 * 
 * @author lhp
 * @date 2018-8-22 上午10:18:26
 * @version
 */
@Service
public interface AddressUtilService {
	/**
	 * 获取省份列表
	 * @param params
	 * @return
	 */
	List<String> getProvinceList(Map<String, Object> params) throws SystemException;
	
	/**
	 * 获取城市列表
	 * @param params
	 * @return
	 */
	List<String> getCityList(Map<String, Object> params) throws SystemException;
}
