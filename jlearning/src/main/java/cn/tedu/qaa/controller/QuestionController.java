package cn.tedu.qaa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.qaa.bean.Reply;
import cn.tedu.qaa.bean.ResponseResult;
import cn.tedu.qaa.service.IQuestionService;
import cn.tedu.qaa.vo.QuestionVo;

@Controller
@RequestMapping("/questions")
public class QuestionController extends BaseController {
	
	@Resource
	private IQuestionService questionService;
	
	@RequestMapping("/showQuestions.do")
	public String showQuestions(ModelMap map){
		List<QuestionVo> list = questionService.getNewestTags();
		map.addAttribute("newList", list);
		return "questions";
	}
	
	@RequestMapping("/hottest.do")
	public String hottest(ModelMap map){
		List<QuestionVo> list = questionService.getHottestTags();
		map.addAttribute("hotList", list);
		return "hottest";
	}
	
	@RequestMapping("/unanswered.do")
	public String unanswered(ModelMap map){
		List<QuestionVo> list = questionService.getUnAnsweredTags();
		map.addAttribute("unList", list);
		return "unanswered";
	}
	
	@RequestMapping("/showQdetail.do")
	public String showQdetail(){
		return "qdetail";
	}
	
	
}
