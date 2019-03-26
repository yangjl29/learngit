package cn.tedu.qaa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.qaa.bean.Reply;
import cn.tedu.qaa.bean.ResponseResult;
import cn.tedu.qaa.service.IReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController extends BaseController {

	@Resource
	private IReplyService replyService;
	
	
	@RequestMapping("/storeReply.do")
	@ResponseBody
	public ResponseResult<Void> storeReply(HttpSession session, Integer qid, String content){
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"回答保存成功");
		Reply reply = new Reply();
		reply.setUid(this.getId(session));
		reply.setQid(qid);
		reply.setContent(content);
		
		replyService.addReply(reply);
		return rr;
	}
	
}
