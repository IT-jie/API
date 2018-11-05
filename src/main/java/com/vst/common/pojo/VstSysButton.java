package com.vst.common.pojo;

/**
 * 系统按钮
 * @author lhp
 * @date 2018-4-26 上午11:07:27
 * @version
 */
public class VstSysButton {
	/**
	 * 按钮id, 唯一,6位随机数
	 */
	private String vst_sb_id;
	
	/**
	 * 按钮名称
	 */
	private String vst_sb_name;
	
	/**
	 * 按钮图片
	 */
	private String vst_sb_img;
	
	/**
	 * 按钮事件
	 */
	private String vst_sb_onclick;
	
	/**
	 * 排序
	 */
	private Integer vst_sb_index;
	
	/**
	 * 状态，1：正常，2：禁用
	 */
	private Integer vst_sb_state;
	
	/**
	 * 新增时间
	 */
	private Long vst_sb_addtime;
	
	/**
	 * 新增人
	 */
	private String vst_sb_creator;
	
	/**
	 * 更新时间
	 */
	private Long vst_sb_uptime;
	
	/**
	 * 更新人
	 */
	private String vst_sb_updator;
	
	/**
	 * 备注
	 */
	private String vst_sb_summary;

	public String getVst_sb_id() {
		return vst_sb_id;
	}

	public void setVst_sb_id(String vstSbId) {
		vst_sb_id = vstSbId;
	}

	public String getVst_sb_name() {
		return vst_sb_name;
	}

	public void setVst_sb_name(String vstSbName) {
		vst_sb_name = vstSbName;
	}

	public String getVst_sb_img() {
		return vst_sb_img;
	}

	public void setVst_sb_img(String vstSbImg) {
		vst_sb_img = vstSbImg;
	}

	public String getVst_sb_onclick() {
		return vst_sb_onclick;
	}

	public void setVst_sb_onclick(String vstSbOnclick) {
		vst_sb_onclick = vstSbOnclick;
	}

	public Integer getVst_sb_index() {
		return vst_sb_index;
	}

	public void setVst_sb_index(Integer vstSbIndex) {
		vst_sb_index = vstSbIndex;
	}

	public Integer getVst_sb_state() {
		return vst_sb_state;
	}

	public void setVst_sb_state(Integer vstSbState) {
		vst_sb_state = vstSbState;
	}

	public Long getVst_sb_addtime() {
		return vst_sb_addtime;
	}

	public void setVst_sb_addtime(Long vstSbAddtime) {
		vst_sb_addtime = vstSbAddtime;
	}

	public String getVst_sb_creator() {
		return vst_sb_creator;
	}

	public void setVst_sb_creator(String vstSbCreator) {
		vst_sb_creator = vstSbCreator;
	}

	public Long getVst_sb_uptime() {
		return vst_sb_uptime;
	}

	public void setVst_sb_uptime(Long vstSbUptime) {
		vst_sb_uptime = vstSbUptime;
	}

	public String getVst_sb_updator() {
		return vst_sb_updator;
	}

	public void setVst_sb_updator(String vstSbUpdator) {
		vst_sb_updator = vstSbUpdator;
	}

	public String getVst_sb_summary() {
		return vst_sb_summary;
	}

	public void setVst_sb_summary(String vstSbSummary) {
		vst_sb_summary = vstSbSummary;
	}

	@Override
	public String toString() {
		return "VstSysButton [vst_sb_addtime=" + vst_sb_addtime
				+ ", vst_sb_creator=" + vst_sb_creator + ", vst_sb_id="
				+ vst_sb_id + ", vst_sb_img=" + vst_sb_img + ", vst_sb_index="
				+ vst_sb_index + ", vst_sb_name=" + vst_sb_name
				+ ", vst_sb_onclick=" + vst_sb_onclick + ", vst_sb_state="
				+ vst_sb_state + ", vst_sb_summary=" + vst_sb_summary
				+ ", vst_sb_updator=" + vst_sb_updator + ", vst_sb_uptime="
				+ vst_sb_uptime + "]";
	}
}
