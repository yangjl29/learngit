package cn.tedu.qaa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.bean.ResponseResult;
import cn.tedu.qaa.service.IQuestionService;
import cn.tedu.qaa.service.IReplyService;
import cn.tedu.qaa.vo.QuestionVo;
import cn.tedu.qaa.vo.ReplyVo;

@Controller
@RequestMapping("/questions")
public class QuestionController extends BaseController {
	
	@Resource
	private IQuestionService questionService;
	
	@Resource
	private IReplyService replyService;
	
	@RequestMapping("/showSearch.do")
	public String showSearch(String q, Integer page, ModelMap map){
		if(page == null){
			page = 1;	
		}
		Integer offset = (page-1)*5;	//跳过的条数
		
		List<QuestionVo> qlist = questionService.getQuestionsByKeyword(q, offset, 5);
		
		Integer count = questionService.getQuestionCountByKeyword(q);	//总的查询到的条数
		
		int pageSize = count%5==0?count/5:count/5+1;	//总的页数
		
		map.addAttribute("qlist", qlist);
		map.addAttribute("qcount", count);
		map.addAttribute("q", q);
		map.addAttribute("curentPage", page);
		map.addAttribute("pageSize", pageSize);
		return "search";
	}
	
	@RequestMapping("/showAsk.do")
	public String showAsk(){
		return "ask";
	}
	
	@RequestMapping("/showQuestions.do")
	public String showQuestions(Integer page, ModelMap map){
		if(page == null){
			page = 1;	
		}
		Integer offset = (page-1)*5;	//跳过的条数
		
		List<QuestionVo> list = questionService.getNewestTags(offset, 5);
		
		Integer count = questionService.getAllQuestionsCount();
		
		int pageSize = count%5==0?count/5:count/5+1;	//总的页数
		
		map.addAttribute("newList", list);
		map.addAttribute("qcount", count);
		map.addAttribute("curentPage", page);
		map.addAttribute("pageSize", pageSize);
		
		return "questions";
	}
	
	@RequestMapping("/hottest.do")
	public String hottest(Integer page, ModelMap map){
		if(page == null){
			page = 1;	
		}
		Integer offset = (page-1)*5;	//跳过的条数
		
		List<QuestionVo> list = questionService.getHottestTags(offset, 5);
		
		Integer count = questionService.getAllQuestionsCount();
		
		int pageSize = count%5==0?count/5:count/5+1;	//总的页数
		
		map.addAttribute("hotList", list);
		map.addAttribute("qcount", count);
		map.addAttribute("curentPage", page);
		map.addAttribute("pageSize", pageSize);
		
		return "hottest";
	}
	
	@RequestMapping("/unanswered.do")
	public String unanswered(Integer page, ModelMap map){
		if(page == null){
			page = 1;	
		}
		Integer offset = (page-1)*5;	//跳过的条数
		
		List<QuestionVo> list = questionService.getUnAnsweredTags(offset, 5);

		Integer count = questionService.getAllQuestionsCount();
		
		int pageSize = count%5==0?count/5:count/5+1;	//总的页数
		
		map.addAttribute("unList", list);
		map.addAttribute("qcount", count);
		map.addAttribute("curentPage", page);
		map.addAttribute("pageSize", pageSize);
		
		return "unanswered";
	}
	
	@RequestMapping("/showQdetail.do")
	public String showQdetail(Integer qid,ModelMap map){
		Question q = questionService.getQuestionById(qid);
		List<ReplyVo> rlist = replyService.getRepliesByQId(qid);
		Integer replyCount = replyService.getReplyCountByQid(qid);
		if(qid == null){
			return null;
		}
		if(replyCount==null){
			replyCount=0;
		}
		map.addAttribute("qinfo", q);
		map.addAttribute("rlist", rlist);
		map.addAttribute("rCount", replyCount);
		
		return "qdetail";
	}
	
	
	
	@RequestMapping("/ask.do")
	@ResponseBody
	public ResponseResult<Void> ask(String title,HttpSession session,String content){
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"问题保存成功");
		Question question = new Question();
		question.setUid(this.getId(session));
		question.setTitle(title);
		question.setContent(content);
		
		questionService.addQuestion(question);
		
		return rr;
	}
	
	
}
