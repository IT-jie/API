package com.vst.common.pojo;

/**
 * 省份
 * @author LCL
 * @date 2017-10-09 下午18:30:20
 * @description
 * @version
 */
public class VstSysProvince {
	/**
	 * 主键，自增长
	 */
	private Long vst_pk_id;

	/**
	 * 省份id，13位随机数，唯一
	 */
	private String vst_province_id;

	/**
	 * 省份名称
	 */
	private String vst_province_name;
	
	/**
	 * 编号
	 */
	private String vst_province_number;
	
	/**
	 * 国家代码
	 */
	private String vst_province_code;

	/**
	 * 状态：1正常，2禁用，默认1
	 */
	private Integer vst_province_status;

	/**
	 * 备注
	 */
	private String vst_province_desc;

	/**
	 * 创建时间
	 */
	private Long vst_province_addtime;

	/**
	 * 创建人（系统用户）
	 */
	private String vst_province_creator;

	/**
	 * 修改时间
	 */
	private Long vst_province_uptime;

	/**
	 * 修改人（系统用户）
	 */
	private String vst_province_updator;

	public Long getVst_pk_id() {
		return vst_pk_id;
	}

	public void setVst_pk_id(Long vstPkId) {
		vst_pk_id = vstPkId;
	}

	public String getVst_province_id() {
		return vst_province_id;
	}

	public void setVst_province_id(String vstProvinceId) {
		vst_province_id = vstProvinceId;
	}

	public String getVst_province_name() {
		return vst_province_name;
	}

	public void setVst_province_name(String vstProvinceName) {
		vst_province_name = vstProvinceName;
	}

	public String getVst_province_number() {
		return vst_province_number;
	}

	public void setVst_province_number(String vstProvinceNumber) {
		vst_province_number = vstProvinceNumber;
	}

	public String getVst_province_code() {
		return vst_province_code;
	}

	public void setVst_province_code(String vstProvinceCode) {
		vst_province_code = vstProvinceCode;
	}

	public Integer getVst_province_status() {
		return vst_province_status;
	}

	public void setVst_province_status(Integer vstProvinceStatus) {
		vst_province_status = vstProvinceStatus;
	}

	public String getVst_province_desc() {
		return vst_province_desc;
	}

	public void setVst_province_desc(String vstProvinceDesc) {
		vst_province_desc = vstProvinceDesc;
	}

	public Long getVst_province_addtime() {
		return vst_province_addtime;
	}

	public void setVst_province_addtime(Long vstProvinceAddtime) {
		vst_province_addtime = vstProvinceAddtime;
	}

	public String getVst_province_creator() {
		return vst_province_creator;
	}

	public void setVst_province_creator(String vstProvinceCreator) {
		vst_province_creator = vstProvinceCreator;
	}

	public Long getVst_province_uptime() {
		return vst_province_uptime;
	}

	public void setVst_province_uptime(Long vstProvinceUptime) {
		vst_province_uptime = vstProvinceUptime;
	}

	public String getVst_province_updator() {
		return vst_province_updator;
	}

	public void setVst_province_updator(String vstProvinceUpdator) {
		vst_province_updator = vstProvinceUpdator;
	}

	@Override
	public String toString() {
		return "VstSysProvince [vst_pk_id=" + vst_pk_id
				+ ", vst_province_addtime=" + vst_province_addtime
				+ ", vst_province_code=" + vst_province_code
				+ ", vst_province_creator=" + vst_province_creator
				+ ", vst_province_desc=" + vst_province_desc
				+ ", vst_province_id=" + vst_province_id
				+ ", vst_province_name=" + vst_province_name
				+ ", vst_province_number=" + vst_province_number
				+ ", vst_province_status=" + vst_province_status
				+ ", vst_province_updator=" + vst_province_updator
				+ ", vst_province_uptime=" + vst_province_uptime + "]";
	}
}
