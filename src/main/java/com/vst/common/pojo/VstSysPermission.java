package com.vst.common.pojo;

/**
 * 系统权限
 * @author lhp
 * @date 2018-4-26 上午11:33:07
 * @version
 */
public class VstSysPermission {
	/**
	 * 角色id
	 */
	private String vst_sr_id;
	
	/**
	 * 模块id
	 */
	private String vst_sm_id;
	
	/**
	 * 按钮id
	 */
	private String vst_sb_id;

	public String getVst_sr_id() {
		return vst_sr_id;
	}

	public void setVst_sr_id(String vstSrId) {
		vst_sr_id = vstSrId;
	}

	public String getVst_sm_id() {
		return vst_sm_id;
	}

	public void setVst_sm_id(String vstSmId) {
		vst_sm_id = vstSmId;
	}

	public String getVst_sb_id() {
		return vst_sb_id;
	}

	public void setVst_sb_id(String vstSbId) {
		vst_sb_id = vstSbId;
	}

	@Override
	public String toString() {
		return "VstSysPermission [vst_sb_id=" + vst_sb_id + ", vst_sm_id="
				+ vst_sm_id + ", vst_sr_id=" + vst_sr_id + "]";
	}
}
