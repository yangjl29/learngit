package cn.tedu.qaa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.bean.User;
import cn.tedu.qaa.service.IQuestionService;
import cn.tedu.qaa.service.IUserService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Resource
	private IQuestionService questionService;
	
	@Resource
	private IUserService userService;
	
	@RequestMapping("/showQuestions.do")
	public String showQuestions(ModelMap map){
		List<Question> list = questionService.getNewestQuestions();
		List<User> userList = null;
		User user = null;
		for (Question q : list) {
			Integer id = q.getId();
			user = userService.selectById(id);
			userList.add(user);
		}
		map.addAttribute("newList", list);
		map.addAttribute("userList", userList);
		return "questions";
	}
	
	@RequestMapping("/showHottest.do")
	public String showHottest(ModelMap map){
		List<Question> list = questionService.getHottestQuestions();
		map.addAttribute("hotList", list);
		return "hottest";
	}
	
	@RequestMapping("/showUnAnswered.do")
	public String showUnAnswered(ModelMap map){
		List<Question> list = questionService.getUnAnsweredQuestions();
		map.addAttribute("unList", list);
		return "unanswered";
	}
	
	/*
	@RequestMapping("/newest.do")
	@ResponseBody
	public ResponseResult<List<Question>> getNewestQuestions(){
		ResponseResult<List<Question>> rr = new ResponseResult<>(1,"查询成功");
		List<Question> list = questionService.getNewestQuestions();
		rr.setData(list);
		return rr;
	}
	
	@RequestMapping("/hottest.do")
	@ResponseBody
	public ResponseResult<List<Question>> getHottestQuestions(){
		ResponseResult<List<Question>> rr = new ResponseResult<>(1,"查询成功");
		List<Question> list = questionService.getHottestQuestions();
		rr.setData(list);
		System.out.println(list);
		return rr;
	}
	
	@RequestMapping("/unanswered.do")
	@ResponseBody
	public ResponseResult<List<Question>> getUnAnsweredQuestions(){
		ResponseResult<List<Question>> rr = new ResponseResult<>(1,"查询成功");
		List<Question> list = questionService.getUnAnsweredQuestions();
		rr.setData(list);
		return rr;
	}*/
}
