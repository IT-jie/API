package com.vst.defend.controller.game;

import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vst.common.tools.number.ToolsNumber;
import com.vst.defend.communal.controller.BaseController;
import com.vst.defend.communal.exception.SystemException;

/**
 * 狼人杀游戏
 * @author lhp
 * @date 2018-9-19 下午03:46:06
 * @version
 */
@Controller
@RequestMapping("/werewolf")
public class WerewolfController extends BaseController {
	/**
	 * 类名
	 */
	private static final String _className = WerewolfController.class.getName();
	
	/**
	 * 日志
	 */
	private static final Log logger = LogFactory.getLog(_className);
	
	/**
	 * 启动页面
	 * @return
	 */
	@RequestMapping("/start")
	public String start(){
		try {
			this.initializeAction(_className);
			
		} catch(Exception e){
			logger.error("werewolf start error." + SystemException.getExceptionInfo(e));
		}
		return "werewolf/1_start";
	}
	
	/**
	 * 开始游戏
	 * @return
	 */
	@RequestMapping("/play")
	public String play(){
		try {
			this.initializeAction(_className);
			
			// 总人数
			int num_total = ToolsNumber.parseInt(request.getParameter("num_total"));
			// 狼人数
			int num_wolf = ToolsNumber.parseInt(request.getParameter("num_wolf"));
			// 村民数
			int num_villager = ToolsNumber.parseInt(request.getParameter("num_villager"));
			// 神职
			String[] skill_role = request.getParameterValues("skill_role");
			// 特殊狼
			String[] skill_wolf = request.getParameterValues("skill_wolf");
			// 游戏类型：屠边、屠城
			String game_type = request.getParameter("game_type");
			
			session.setAttribute("num_total", num_total);
			session.setAttribute("num_wolf", num_wolf);
			session.setAttribute("num_villager", num_villager);
			if(skill_role != null){
				session.setAttribute("skill_role", Arrays.asList(skill_role));
			}else{
				session.setAttribute("skill_role", Collections.EMPTY_LIST);
			}
			if(skill_wolf != null){
				session.setAttribute("skill_wolf", Arrays.asList(skill_wolf));
			}else{
				session.setAttribute("skill_wolf", Collections.EMPTY_LIST);
			}
			session.setAttribute("game_type", game_type);
			
		} catch(Exception e){
			logger.error("werewolf play error." + SystemException.getExceptionInfo(e));
		}
		return "werewolf/2_play";
	}
}
