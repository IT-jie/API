package com.vst.common.pojo;

/**
 * 城市
 * @author lhp
 * @date 2017-11-2 上午09:57:47
 * @version
 */
public class VstSysCity {
	/**
	 * 主键，自增长
	 */
	private Long vst_pk_id;
	
	/**
	 * 城市id，13位随机数，唯一
	 */
	private String vst_city_id;
	
	/**
	 * 城市名称
	 */
	private String vst_city_name;
	
	/**
	 * 编号
	 */
	private String vst_city_number;
	
	/**
	 * 国家代码
	 */
	private String vst_city_code;
	
	/**
	 * 状态：1正常，2禁用
	 */
	private Integer vst_city_status;
	
	/**
	 * 省份ID
	 */
	private String vst_province_id;
	
	/**
	 * 备注
	 */
	private String vst_city_desc;
	
	/**
	 * 创建时间
	 */
	private Long vst_city_addtime;
	
	/**
	 * 创建人（系统用户）
	 */
	private String vst_city_creator;
	
	/**
	 * 修改时间
	 */
	private Long vst_city_uptime;
	
	/**
	 * 修改人（系统用户）
	 */
	private String vst_city_updator;

	public Long getVst_pk_id() {
		return vst_pk_id;
	}

	public void setVst_pk_id(Long vstPkId) {
		vst_pk_id = vstPkId;
	}

	public String getVst_city_id() {
		return vst_city_id;
	}

	public void setVst_city_id(String vstCityId) {
		vst_city_id = vstCityId;
	}

	public String getVst_city_name() {
		return vst_city_name;
	}

	public void setVst_city_name(String vstCityName) {
		vst_city_name = vstCityName;
	}

	public String getVst_city_number() {
		return vst_city_number;
	}

	public void setVst_city_number(String vstCityNumber) {
		vst_city_number = vstCityNumber;
	}

	public String getVst_city_code() {
		return vst_city_code;
	}

	public void setVst_city_code(String vstCityCode) {
		vst_city_code = vstCityCode;
	}

	public Integer getVst_city_status() {
		return vst_city_status;
	}

	public void setVst_city_status(Integer vstCityStatus) {
		vst_city_status = vstCityStatus;
	}

	public String getVst_province_id() {
		return vst_province_id;
	}

	public void setVst_province_id(String vstProvinceId) {
		vst_province_id = vstProvinceId;
	}

	public String getVst_city_desc() {
		return vst_city_desc;
	}

	public void setVst_city_desc(String vstCityDesc) {
		vst_city_desc = vstCityDesc;
	}

	public Long getVst_city_addtime() {
		return vst_city_addtime;
	}

	public void setVst_city_addtime(Long vstCityAddtime) {
		vst_city_addtime = vstCityAddtime;
	}

	public String getVst_city_creator() {
		return vst_city_creator;
	}

	public void setVst_city_creator(String vstCityCreator) {
		vst_city_creator = vstCityCreator;
	}

	public Long getVst_city_uptime() {
		return vst_city_uptime;
	}

	public void setVst_city_uptime(Long vstCityUptime) {
		vst_city_uptime = vstCityUptime;
	}

	public String getVst_city_updator() {
		return vst_city_updator;
	}

	public void setVst_city_updator(String vstCityUpdator) {
		vst_city_updator = vstCityUpdator;
	}

	@Override
	public String toString() {
		return "VstSysCity [vst_city_addtime=" + vst_city_addtime
				+ ", vst_city_code=" + vst_city_code + ", vst_city_creator="
				+ vst_city_creator + ", vst_city_desc=" + vst_city_desc
				+ ", vst_city_id=" + vst_city_id + ", vst_city_name="
				+ vst_city_name + ", vst_city_number=" + vst_city_number
				+ ", vst_city_status=" + vst_city_status
				+ ", vst_city_updator=" + vst_city_updator
				+ ", vst_city_uptime=" + vst_city_uptime + ", vst_pk_id="
				+ vst_pk_id + ", vst_province_id=" + vst_province_id + "]";
	}
}
