package com.vst.common.pojo;

/**
 * 系统用户
 * @author lhp
 * @date 2018-4-26 上午11:24:01
 * @version
 */
public class VstSysUser {
	/**
	 * 管理员id，6位随机数，唯一
	 */
	private String vst_su_id;
	
	/**
	 * 管理员名称
	 */
	private String vst_su_name;
	
	/**
	 * 管理员登陆帐号
	 */
	private String vst_su_username;
	
	/**
	 * 管理员登陆密码
	 */
	private String vst_su_password;
	
	/**
	 * 管理员类型，0：超级管理员，1：用户维护账户
	 */
	private Integer vst_su_type;
	
	/**
	 * 角色id
	 */
	private String vst_sr_id;
	
	/**
	 * 所属部门（1、总经办  2、行政部  3、财务部  4、后台  5、安卓  6、编辑部  7、产品部  8、推广部  9、测试部  10、商务拓展部  11、品牌战略部  12、北京），默认0，代表未知
	 */
	private Integer vst_su_department;
	
	/**
	 * 职位(1老总、2主管、3经理、4组长、5员工、0其他)
	 */
	private Integer vst_su_job;
	
	/**
	 * 用户头像
	 */
	private String vst_su_photo;
	
	/**
	 * 1：正常，2：禁用，默认1
	 */
	private Integer vst_su_state;
	
	/**
	 * 新增时间
	 */
	private Long vst_su_addtime;
	
	/**
	 * 新增人
	 */
	private String vst_su_creator;
	
	/**
	 * 更新时间
	 */
	private Long vst_su_uptime;
	
	/**
	 * 更新人
	 */
	private String vst_su_updator;
	
	/**
	 * 备注
	 */
	private String vst_su_summary;

	public String getVst_su_id() {
		return vst_su_id;
	}

	public void setVst_su_id(String vstSuId) {
		vst_su_id = vstSuId;
	}

	public String getVst_su_name() {
		return vst_su_name;
	}

	public void setVst_su_name(String vstSuName) {
		vst_su_name = vstSuName;
	}

	public String getVst_su_username() {
		return vst_su_username;
	}

	public void setVst_su_username(String vstSuUsername) {
		vst_su_username = vstSuUsername;
	}

	public String getVst_su_password() {
		return vst_su_password;
	}

	public void setVst_su_password(String vstSuPassword) {
		vst_su_password = vstSuPassword;
	}

	public Integer getVst_su_type() {
		return vst_su_type;
	}

	public void setVst_su_type(Integer vstSuType) {
		vst_su_type = vstSuType;
	}

	public String getVst_sr_id() {
		return vst_sr_id;
	}

	public void setVst_sr_id(String vstSrId) {
		vst_sr_id = vstSrId;
	}

	public Integer getVst_su_department() {
		return vst_su_department;
	}

	public void setVst_su_department(Integer vstSuDepartment) {
		vst_su_department = vstSuDepartment;
	}

	public Integer getVst_su_job() {
		return vst_su_job;
	}

	public void setVst_su_job(Integer vstSuJob) {
		vst_su_job = vstSuJob;
	}

	public String getVst_su_photo() {
		return vst_su_photo;
	}

	public void setVst_su_photo(String vstSuPhoto) {
		vst_su_photo = vstSuPhoto;
	}

	public Integer getVst_su_state() {
		return vst_su_state;
	}

	public void setVst_su_state(Integer vstSuState) {
		vst_su_state = vstSuState;
	}

	public Long getVst_su_addtime() {
		return vst_su_addtime;
	}

	public void setVst_su_addtime(Long vstSuAddtime) {
		vst_su_addtime = vstSuAddtime;
	}

	public String getVst_su_creator() {
		return vst_su_creator;
	}

	public void setVst_su_creator(String vstSuCreator) {
		vst_su_creator = vstSuCreator;
	}

	public Long getVst_su_uptime() {
		return vst_su_uptime;
	}

	public void setVst_su_uptime(Long vstSuUptime) {
		vst_su_uptime = vstSuUptime;
	}

	public String getVst_su_updator() {
		return vst_su_updator;
	}

	public void setVst_su_updator(String vstSuUpdator) {
		vst_su_updator = vstSuUpdator;
	}

	public String getVst_su_summary() {
		return vst_su_summary;
	}

	public void setVst_su_summary(String vstSuSummary) {
		vst_su_summary = vstSuSummary;
	}

	@Override
	public String toString() {
		return "VstSysUser [vst_sr_id=" + vst_sr_id + ", vst_su_addtime="
				+ vst_su_addtime + ", vst_su_creator=" + vst_su_creator
				+ ", vst_su_department=" + vst_su_department + ", vst_su_id="
				+ vst_su_id + ", vst_su_job=" + vst_su_job + ", vst_su_name="
				+ vst_su_name + ", vst_su_password=" + vst_su_password
				+ ", vst_su_photo=" + vst_su_photo + ", vst_su_state="
				+ vst_su_state + ", vst_su_summary=" + vst_su_summary
				+ ", vst_su_type=" + vst_su_type + ", vst_su_updator="
				+ vst_su_updator + ", vst_su_uptime=" + vst_su_uptime
				+ ", vst_su_username=" + vst_su_username + "]";
	}
}
