package com.vst.defend.dao.province;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.vst.common.pojo.VstSysCity;
import com.vst.defend.communal.dao.BaseDao;

/**
 * 
 * @author lhp
 * @date 2017-11-2 上午10:23:22
 * @version
 */
@Repository
@Transactional
public interface VstCityDao extends BaseDao<VstSysCity> {

}
