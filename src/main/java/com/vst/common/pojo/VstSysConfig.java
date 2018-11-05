package com.vst.common.pojo;

/**
 * 系统配置
 * @author lhp
 * @date 2018-4-26 上午11:40:15
 * @version
 */
public class VstSysConfig {
	/**
	 * 配置key
	 */
	private String vst_sc_key;
	
	/**
	 * 配置类型：1-字符串 2-图片 3-文件
	 */
	private Integer vst_sc_type;
	
	/**
	 * 配置value
	 */
	private String vst_sc_value;
	
	/**
	 * 1：正常，2：禁用，默认1
	 */
	private Integer vst_sc_state;
	
	/**
	 * 新增时间
	 */
	private Long vst_sc_addtime;
	
	/**
	 * 新增人
	 */
	private String vst_sc_creator;
	
	/**
	 * 更新时间
	 */
	private Long vst_sc_uptime;
	
	/**
	 * 更新人
	 */
	private String vst_sc_updator;
	
	/**
	 * 备注
	 */
	private String vst_sc_summary;

	public String getVst_sc_key() {
		return vst_sc_key;
	}

	public void setVst_sc_key(String vstScKey) {
		vst_sc_key = vstScKey;
	}

	public Integer getVst_sc_type() {
		return vst_sc_type;
	}

	public void setVst_sc_type(Integer vstScType) {
		vst_sc_type = vstScType;
	}

	public String getVst_sc_value() {
		return vst_sc_value;
	}

	public void setVst_sc_value(String vstScValue) {
		vst_sc_value = vstScValue;
	}

	public Integer getVst_sc_state() {
		return vst_sc_state;
	}

	public void setVst_sc_state(Integer vstScState) {
		vst_sc_state = vstScState;
	}

	public Long getVst_sc_addtime() {
		return vst_sc_addtime;
	}

	public void setVst_sc_addtime(Long vstScAddtime) {
		vst_sc_addtime = vstScAddtime;
	}

	public String getVst_sc_creator() {
		return vst_sc_creator;
	}

	public void setVst_sc_creator(String vstScCreator) {
		vst_sc_creator = vstScCreator;
	}

	public Long getVst_sc_uptime() {
		return vst_sc_uptime;
	}

	public void setVst_sc_uptime(Long vstScUptime) {
		vst_sc_uptime = vstScUptime;
	}

	public String getVst_sc_updator() {
		return vst_sc_updator;
	}

	public void setVst_sc_updator(String vstScUpdator) {
		vst_sc_updator = vstScUpdator;
	}

	public String getVst_sc_summary() {
		return vst_sc_summary;
	}

	public void setVst_sc_summary(String vstScSummary) {
		vst_sc_summary = vstScSummary;
	}

	@Override
	public String toString() {
		return "VstSysConfig [vst_sc_addtime=" + vst_sc_addtime
				+ ", vst_sc_creator=" + vst_sc_creator + ", vst_sc_key="
				+ vst_sc_key + ", vst_sc_state=" + vst_sc_state
				+ ", vst_sc_summary=" + vst_sc_summary + ", vst_sc_type="
				+ vst_sc_type + ", vst_sc_updator=" + vst_sc_updator
				+ ", vst_sc_uptime=" + vst_sc_uptime + ", vst_sc_value="
				+ vst_sc_value + "]";
	}
}
