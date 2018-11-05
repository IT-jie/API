package com.vst.common.pojo;

/**
 * 系统角色
 * @author lhp
 * @date 2018-4-26 上午11:20:43
 * @version
 */
public class VstSysRole {
	/**
	 * 角色id, 唯一,6位随机数
	 */
	private String vst_sr_id;
	
	/**
	 * 角色名称
	 */
	private String vst_sr_name;
	
	/**
	 * 角色类型，0：系统默认角色，不能删除，1：用户自定义角色
	 */
	private Integer vst_sr_type;
	
	/**
	 * 1：正常，2：禁用，默认1
	 */
	private Integer vst_sr_state;
	
	/**
	 * 新增时间
	 */
	private Long vst_sr_addtime;
	
	/**
	 * 新增人
	 */
	private String vst_sr_creator;
	
	/**
	 * 更新时间
	 */
	private Long vst_sr_uptime;
	
	/**
	 * 更新人
	 */
	private String vst_sr_updator;
	
	/**
	 * 备注
	 */
	private String vst_sr_summary;

	public String getVst_sr_id() {
		return vst_sr_id;
	}

	public void setVst_sr_id(String vstSrId) {
		vst_sr_id = vstSrId;
	}

	public String getVst_sr_name() {
		return vst_sr_name;
	}

	public void setVst_sr_name(String vstSrName) {
		vst_sr_name = vstSrName;
	}

	public Integer getVst_sr_type() {
		return vst_sr_type;
	}

	public void setVst_sr_type(Integer vstSrType) {
		vst_sr_type = vstSrType;
	}

	public Integer getVst_sr_state() {
		return vst_sr_state;
	}

	public void setVst_sr_state(Integer vstSrState) {
		vst_sr_state = vstSrState;
	}

	public Long getVst_sr_addtime() {
		return vst_sr_addtime;
	}

	public void setVst_sr_addtime(Long vstSrAddtime) {
		vst_sr_addtime = vstSrAddtime;
	}

	public String getVst_sr_creator() {
		return vst_sr_creator;
	}

	public void setVst_sr_creator(String vstSrCreator) {
		vst_sr_creator = vstSrCreator;
	}

	public Long getVst_sr_uptime() {
		return vst_sr_uptime;
	}

	public void setVst_sr_uptime(Long vstSrUptime) {
		vst_sr_uptime = vstSrUptime;
	}

	public String getVst_sr_updator() {
		return vst_sr_updator;
	}

	public void setVst_sr_updator(String vstSrUpdator) {
		vst_sr_updator = vstSrUpdator;
	}

	public String getVst_sr_summary() {
		return vst_sr_summary;
	}

	public void setVst_sr_summary(String vstSrSummary) {
		vst_sr_summary = vstSrSummary;
	}

	@Override
	public String toString() {
		return "VstSysRole [vst_sr_addtime=" + vst_sr_addtime
				+ ", vst_sr_creator=" + vst_sr_creator + ", vst_sr_id="
				+ vst_sr_id + ", vst_sr_name=" + vst_sr_name
				+ ", vst_sr_state=" + vst_sr_state + ", vst_sr_summary="
				+ vst_sr_summary + ", vst_sr_type=" + vst_sr_type
				+ ", vst_sr_updator=" + vst_sr_updator + ", vst_sr_uptime="
				+ vst_sr_uptime + "]";
	}
}
