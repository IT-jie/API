package com.vst.defend.dao.province;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.vst.common.pojo.VstSysProvince;
import com.vst.defend.communal.dao.BaseDao;

/**
 * 
 * @author lhp
 * @date 2017-11-2 上午10:22:54
 * @version
 */
@Repository
@Transactional
public interface VstProvinceDao extends BaseDao<VstSysProvince>{

	/**
	 * 查询地区映射
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> queryAddressMap(Map<String,Object> params);
}
