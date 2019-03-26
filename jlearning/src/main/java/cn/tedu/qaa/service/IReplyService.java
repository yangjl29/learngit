package cn.tedu.qaa.service;

import java.util.List;

import cn.tedu.qaa.bean.Reply;
import cn.tedu.qaa.vo.ReplyVo;

public interface IReplyService {

	void addReply(Reply reply);
	
	List<ReplyVo> getRepliesByQId(Integer qid);
	
	Integer getReplyCountByQid(Integer qid);
}
