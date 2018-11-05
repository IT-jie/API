package com.vst.common.pojo;

/**
 * 系统配置
 * @author lhp
 * @date 2018-8-29 下午05:05:47
 * @version
 */
public class VstSysOption {
	/**
	 * 配置KEY
	 */
	private String vst_option_key;
	
	/**
	 * 配置VALUE
	 */
	private String vst_option_value;
	
	/**
	 * 备注
	 */
	private String vst_option_desc;

	public String getVst_option_key() {
		return vst_option_key;
	}

	public void setVst_option_key(String vstOptionKey) {
		vst_option_key = vstOptionKey;
	}

	public String getVst_option_value() {
		return vst_option_value;
	}

	public void setVst_option_value(String vstOptionValue) {
		vst_option_value = vstOptionValue;
	}

	public String getVst_option_desc() {
		return vst_option_desc;
	}

	public void setVst_option_desc(String vstOptionDesc) {
		vst_option_desc = vstOptionDesc;
	}

	@Override
	public String toString() {
		return "VstSysOption [vst_option_desc=" + vst_option_desc
				+ ", vst_option_key=" + vst_option_key + ", vst_option_value="
				+ vst_option_value + "]";
	}
}
