package com.vst.common.pojo;

/**
 * 操作日志
 * @author lhp
 * @date 2018-4-26 下午12:13:47
 * @version
 */
public class VstSysOperateLog {
	/**
	 * 日志id, 唯一,12位随机数
	 */
	private String vst_sol_id;
	
	/**
	 * 登陆名称
	 */
	private String vst_su_username;
	
	/**
	 * 操作模块id
	 */
	private String vst_sm_id;
	
	/**
	 * 操作模块名称
	 */
	private String vst_sm_name;
	
	/**
	 * 日志类型，1：新增，2：修改，3：删除
	 */
	private Integer vst_sol_type;
	
	/**
	 * 操作ip
	 */
	private String vst_sol_ip;
	
	/**
	 * 日志时间
	 */
	private Long vst_sol_addtime;
	
	/**
	 * 操作内容
	 */
	private String vst_sol_content;
	
	/**
	 * 默认构造器
	 */
	public VstSysOperateLog() {
		super();
	}

	/**
	 * 带参构造器
	 * 
	 * @param moduleName
	 * @param type
	 * @param content
	 */
	public VstSysOperateLog(String moduleId, Integer type, String content) {
		super();
		this.vst_sm_id = moduleId;
		this.vst_sol_type = type;
		this.vst_sol_content = content;
	}
	
	public String getVst_sol_id() {
		return vst_sol_id;
	}

	public void setVst_sol_id(String vstSolId) {
		vst_sol_id = vstSolId;
	}

	public String getVst_su_username() {
		return vst_su_username;
	}

	public void setVst_su_username(String vstSuUsername) {
		vst_su_username = vstSuUsername;
	}

	public String getVst_sm_id() {
		return vst_sm_id;
	}

	public void setVst_sm_id(String vstSmId) {
		vst_sm_id = vstSmId;
	}

	public String getVst_sm_name() {
		return vst_sm_name;
	}

	public void setVst_sm_name(String vstSmName) {
		vst_sm_name = vstSmName;
	}

	public Integer getVst_sol_type() {
		return vst_sol_type;
	}

	public void setVst_sol_type(Integer vstSolType) {
		vst_sol_type = vstSolType;
	}

	public String getVst_sol_ip() {
		return vst_sol_ip;
	}

	public void setVst_sol_ip(String vstSolIp) {
		vst_sol_ip = vstSolIp;
	}

	public Long getVst_sol_addtime() {
		return vst_sol_addtime;
	}

	public void setVst_sol_addtime(Long vstSolAddtime) {
		vst_sol_addtime = vstSolAddtime;
	}

	public String getVst_sol_content() {
		return vst_sol_content;
	}

	public void setVst_sol_content(String vstSolContent) {
		vst_sol_content = vstSolContent;
	}

	@Override
	public String toString() {
		return "VstSysOperateLog [vst_sm_id=" + vst_sm_id + ", vst_sm_name="
				+ vst_sm_name + ", vst_sol_addtime=" + vst_sol_addtime
				+ ", vst_sol_content=" + vst_sol_content + ", vst_sol_id="
				+ vst_sol_id + ", vst_sol_ip=" + vst_sol_ip + ", vst_sol_type="
				+ vst_sol_type + ", vst_su_username=" + vst_su_username + "]";
	}
}
