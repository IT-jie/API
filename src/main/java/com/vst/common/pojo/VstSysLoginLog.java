package com.vst.common.pojo;

/**
 * 登录日志
 * @author lhp
 * @date 2018-4-26 下午12:11:55
 * @version
 */
public class VstSysLoginLog {
	/**
	 * 日志id, 唯一,12位随机数
	 */
	private String vst_sll_id;
	
	/**
	 * 登陆名称
	 */
	private String vst_su_username;
	
	/**
	 * 登陆ip
	 */
	private String vst_sll_ip;
	
	/**
	 * 登陆时间
	 */
	private Long vst_sll_login_time;

	public String getVst_sll_id() {
		return vst_sll_id;
	}

	public void setVst_sll_id(String vstSllId) {
		vst_sll_id = vstSllId;
	}

	public String getVst_su_username() {
		return vst_su_username;
	}

	public void setVst_su_username(String vstSuUsername) {
		vst_su_username = vstSuUsername;
	}

	public String getVst_sll_ip() {
		return vst_sll_ip;
	}

	public void setVst_sll_ip(String vstSllIp) {
		vst_sll_ip = vstSllIp;
	}

	public Long getVst_sll_login_time() {
		return vst_sll_login_time;
	}

	public void setVst_sll_login_time(Long vstSllLoginTime) {
		vst_sll_login_time = vstSllLoginTime;
	}

	@Override
	public String toString() {
		return "VstSysLoginLog [vst_sll_id=" + vst_sll_id + ", vst_sll_ip="
				+ vst_sll_ip + ", vst_sll_login_time=" + vst_sll_login_time
				+ ", vst_su_username=" + vst_su_username + "]";
	}
}
