package com.vst.common.pojo;

/**
 * 系统字典
 * @author lhp
 * @date 2018-4-26 上午11:36:25
 * @version
 */
public class VstSysDictionary {
	/**
	 * 字典id, 唯一,6位随机数
	 */
	private String vst_sd_id;
	
	/**
	 * 表名
	 */
	private String vst_sd_table;
	
	/**
	 * 字段名
	 */
	private String vst_sd_column;
	
	/**
	 * 属性键
	 */
	private String vst_sd_key;
	
	/**
	 * 属性值
	 */
	private String vst_sd_value;
	
	/**
	 * 排序
	 */
	private Integer vst_sd_index;
	
	/**
	 * 状态，1：正常，2：禁用
	 */
	private Integer vst_sd_state;
	
	/**
	 * 新增时间
	 */
	private Long vst_sd_addtime;
	
	/**
	 * 新增人
	 */
	private String vst_sd_creator;
	
	/**
	 * 更新时间
	 */
	private Long vst_sd_uptime;
	
	/**
	 * 更新人
	 */
	private String vst_sd_updator;
	
	/**
	 * 备注
	 */
	private String vst_sd_summary;

	public String getVst_sd_id() {
		return vst_sd_id;
	}

	public void setVst_sd_id(String vstSdId) {
		vst_sd_id = vstSdId;
	}

	public String getVst_sd_table() {
		return vst_sd_table;
	}

	public void setVst_sd_table(String vstSdTable) {
		vst_sd_table = vstSdTable;
	}

	public String getVst_sd_column() {
		return vst_sd_column;
	}

	public void setVst_sd_column(String vstSdColumn) {
		vst_sd_column = vstSdColumn;
	}

	public String getVst_sd_key() {
		return vst_sd_key;
	}

	public void setVst_sd_key(String vstSdKey) {
		vst_sd_key = vstSdKey;
	}

	public String getVst_sd_value() {
		return vst_sd_value;
	}

	public void setVst_sd_value(String vstSdValue) {
		vst_sd_value = vstSdValue;
	}

	public Integer getVst_sd_index() {
		return vst_sd_index;
	}

	public void setVst_sd_index(Integer vstSdIndex) {
		vst_sd_index = vstSdIndex;
	}

	public Integer getVst_sd_state() {
		return vst_sd_state;
	}

	public void setVst_sd_state(Integer vstSdState) {
		vst_sd_state = vstSdState;
	}

	public Long getVst_sd_addtime() {
		return vst_sd_addtime;
	}

	public void setVst_sd_addtime(Long vstSdAddtime) {
		vst_sd_addtime = vstSdAddtime;
	}

	public String getVst_sd_creator() {
		return vst_sd_creator;
	}

	public void setVst_sd_creator(String vstSdCreator) {
		vst_sd_creator = vstSdCreator;
	}

	public Long getVst_sd_uptime() {
		return vst_sd_uptime;
	}

	public void setVst_sd_uptime(Long vstSdUptime) {
		vst_sd_uptime = vstSdUptime;
	}

	public String getVst_sd_updator() {
		return vst_sd_updator;
	}

	public void setVst_sd_updator(String vstSdUpdator) {
		vst_sd_updator = vstSdUpdator;
	}

	public String getVst_sd_summary() {
		return vst_sd_summary;
	}

	public void setVst_sd_summary(String vstSdSummary) {
		vst_sd_summary = vstSdSummary;
	}

	@Override
	public String toString() {
		return "VstSysDictionary [vst_sd_addtime=" + vst_sd_addtime
				+ ", vst_sd_column=" + vst_sd_column + ", vst_sd_creator="
				+ vst_sd_creator + ", vst_sd_id=" + vst_sd_id
				+ ", vst_sd_index=" + vst_sd_index + ", vst_sd_key="
				+ vst_sd_key + ", vst_sd_state=" + vst_sd_state
				+ ", vst_sd_table=" + vst_sd_table + ", vst_sd_updator="
				+ vst_sd_updator + ", vst_sd_uptime=" + vst_sd_uptime
				+ ", vst_sd_value=" + vst_sd_value + ", vst_sd_summary="
				+ vst_sd_summary + "]";
	}
}
