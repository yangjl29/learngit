package cn.tedu.qaa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.bean.ResponseResult;
import cn.tedu.qaa.service.IQuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Resource
	private IQuestionService questionService;
	
	@RequestMapping("/showQuestions.do")
	public String showQuestions(){
		return "questions";
	}
	
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
		List<Question> list = questionService.getNewestQuestions();
		rr.setData(list);
		return rr;
	}
	
	@RequestMapping("/unanswered.do")
	@ResponseBody
	public ResponseResult<List<Question>> getUnAnsweredQuestions(){
		ResponseResult<List<Question>> rr = new ResponseResult<>(1,"查询成功");
		List<Question> list = questionService.getNewestQuestions();
		rr.setData(list);
		return rr;
	}
}
