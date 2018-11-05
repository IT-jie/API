package com.vst.defend.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * @author lhp
 * @date 2018-8-22 下午02:54:48
 * @version
 */
@Controller
public class PageSkip {

	/**
	 * API目录
	 * @return
	 */
	@RequestMapping("/api_list")
	public String toApiList(){
		return "page/api_list";
	}
	
	/**
	 * 游戏目录
	 * @return
	 */
	@RequestMapping("/game_list")
	public String toGameList(){
		return "page/game_list";
	}
	
	/**
	 * 娱乐目录
	 * @return
	 */
	@RequestMapping("/play_list")
	public String toPlayList(){
		return "page/play_list";
	}
	
	/**
	 * 个人笔记
	 * @return
	 */
	@RequestMapping("/note_list")
	public String toNoteList(){
		return "page/note_list";
	}
}
