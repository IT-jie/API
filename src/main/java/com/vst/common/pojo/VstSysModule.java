package com.vst.common.pojo;

/**
 * 系统模块
 * @author lhp
 * @date 2018-4-26 上午11:16:33
 * @version
 */
public class VstSysModule {
	/**
	 * 模块id, 唯一,6位随机数
	 */
	private String vst_sm_id;
	
	/**
	 * 模块名称
	 */
	private String vst_sm_name;
	
	/**
	 * 父模块id,默认0
	 */
	private String vst_sm_parent;
	
	/**
	 * 模块url
	 */
	private String vst_sm_url;
	
	/**
	 * 模块图标，用于左侧显示
	 */
	private String vst_sm_icon;
	
	/**
	 * 排序，越大越靠前，默认0
	 */
	private Integer vst_sm_index;
	
	/**
	 * 1：正常，2：禁用，默认1
	 */
	private Integer vst_sm_state;
	
	/**
	 * 新增时间
	 */
	private Long vst_sm_addtime;
	
	/**
	 * 新增人
	 */
	private String vst_sm_creator;
	
	/**
	 * 更新时间
	 */
	private Long vst_sm_uptime;
	
	/**
	 * 更新人
	 */
	private String vst_sm_updator;
	
	/**
	 * 备注
	 */
	private String vst_sm_summary;

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

	public String getVst_sm_parent() {
		return vst_sm_parent;
	}

	public void setVst_sm_parent(String vstSmParent) {
		vst_sm_parent = vstSmParent;
	}

	public String getVst_sm_url() {
		return vst_sm_url;
	}

	public void setVst_sm_url(String vstSmUrl) {
		vst_sm_url = vstSmUrl;
	}

	public String getVst_sm_icon() {
		return vst_sm_icon;
	}

	public void setVst_sm_icon(String vstSmIcon) {
		vst_sm_icon = vstSmIcon;
	}

	public Integer getVst_sm_index() {
		return vst_sm_index;
	}

	public void setVst_sm_index(Integer vstSmIndex) {
		vst_sm_index = vstSmIndex;
	}

	public Integer getVst_sm_state() {
		return vst_sm_state;
	}

	public void setVst_sm_state(Integer vstSmState) {
		vst_sm_state = vstSmState;
	}

	public Long getVst_sm_addtime() {
		return vst_sm_addtime;
	}

	public void setVst_sm_addtime(Long vstSmAddtime) {
		vst_sm_addtime = vstSmAddtime;
	}

	public String getVst_sm_creator() {
		return vst_sm_creator;
	}

	public void setVst_sm_creator(String vstSmCreator) {
		vst_sm_creator = vstSmCreator;
	}

	public Long getVst_sm_uptime() {
		return vst_sm_uptime;
	}

	public void setVst_sm_uptime(Long vstSmUptime) {
		vst_sm_uptime = vstSmUptime;
	}

	public String getVst_sm_updator() {
		return vst_sm_updator;
	}

	public void setVst_sm_updator(String vstSmUpdator) {
		vst_sm_updator = vstSmUpdator;
	}

	public String getVst_sm_summary() {
		return vst_sm_summary;
	}

	public void setVst_sm_summary(String vstSmSummary) {
		vst_sm_summary = vstSmSummary;
	}

	@Override
	public String toString() {
		return "VstSysModule [vst_sm_addtime=" + vst_sm_addtime
				+ ", vst_sm_creator=" + vst_sm_creator + ", vst_sm_icon="
				+ vst_sm_icon + ", vst_sm_id=" + vst_sm_id + ", vst_sm_index="
				+ vst_sm_index + ", vst_sm_name=" + vst_sm_name
				+ ", vst_sm_parent=" + vst_sm_parent + ", vst_sm_state="
				+ vst_sm_state + ", vst_sm_summary=" + vst_sm_summary
				+ ", vst_sm_updator=" + vst_sm_updator + ", vst_sm_uptime="
				+ vst_sm_uptime + ", vst_sm_url=" + vst_sm_url + "]";
	}
}
