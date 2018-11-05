package com.vst.defend.dao.sys;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.vst.common.pojo.VstSysOption;
import com.vst.defend.communal.dao.BaseDao;

/**
 * 
 * @author lhp
 * @date 2018-8-29 下午05:04:43
 * @version
 */
@Repository
@Transactional
public interface VstOptionDao extends BaseDao<VstSysOption> {

}
