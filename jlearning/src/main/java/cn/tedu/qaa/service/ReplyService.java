package cn.tedu.qaa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.qaa.bean.Reply;
import cn.tedu.qaa.mapper.ReplyMapper;
import cn.tedu.qaa.vo.ReplyVo;

@Service
public class ReplyService implements IReplyService {

	@Resource
	private ReplyMapper replyMapper;

	@Override
	public void addReply(Reply reply) {
		replyMapper.insertReply(reply);
	}

	@Override
	public List<ReplyVo> getRepliesByQId(Integer qid) {
		return replyMapper.selectRepliesForQuestion(qid);
	}

	@Override
	public Integer getReplyCountByQid(Integer qid) {
		return replyMapper.selectReplyCountByQid(qid);
	}

	

	
	
	
}
