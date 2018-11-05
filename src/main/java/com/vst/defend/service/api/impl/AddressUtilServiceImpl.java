package com.vst.defend.service.api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.vst.defend.communal.exception.ErrorCode;
import com.vst.defend.communal.exception.SystemException;
import com.vst.defend.dao.province.VstCityDao;
import com.vst.defend.dao.province.VstProvinceDao;
import com.vst.defend.service.api.AddressUtilService;

/**
 * 
 * @author lhp
 * @date 2018-8-22 上午10:18:37
 * @version
 */
@Service
public class AddressUtilServiceImpl implements AddressUtilService {
	/**
	 * 写日志
	 */
	private static final Log logger = LogFactory.getLog(AddressUtilServiceImpl.class);
	
	/**
	 * 省份Dao接口
	 */
	@Resource
	private VstProvinceDao _vstProvinceDao;
	
	/**
	 * 城市Dao接口
	 */
	@Resource
	private VstCityDao _vstCityDao;
	
	/**
	 * 获取省份列表
	 */
	@Override
	public List<String> getProvinceList(Map<String, Object> params) throws SystemException {
		try {
			List<Map<String, Object>> list = _vstProvinceDao.queryForList(params);
			if(list != null && list.size() > 0){
				List<String> result = new ArrayList<String>(list.size());
				for(Map<String, Object> map : list){
					result.add(map.get("vst_province_name")+"");
				}
				return result;
			}
		} catch (Exception e) {
			logger.error("获取省份列表失败: " + SystemException.getExceptionInfo(e));
			throw new SystemException(ErrorCode.SERVICE_OPERATOR_FAILURE, e);
		}
		return null;
	}

	/**
	 * 获取城市列表
	 */
	@Override
	public List<String> getCityList(Map<String, Object> params) throws SystemException {
		try {
			List<Map<String, Object>> list = _vstCityDao.queryForList(params);
			if(list != null && list.size() > 0){
				List<String> result = new ArrayList<String>(list.size());
				for(Map<String, Object> map : list){
					result.add(map.get("vst_city_name")+"");
				}
				return result;
			}
		} catch (Exception e) {
			logger.error("获取城市列表失败: " + SystemException.getExceptionInfo(e));
			throw new SystemException(ErrorCode.SERVICE_OPERATOR_FAILURE, e);
		}
		return null;
	}
}
