package cn.tedu.qaa.mapper;

import java.util.List;

import cn.tedu.qaa.bean.Reply;
import cn.tedu.qaa.vo.ReplyVo;

public interface ReplyMapper {

	/**
	 * 插入回答信息
	 * @param reply
	 */
	void insertReply(Reply reply);
	/**
	 * 查询问题与回答信息
	 * @param qid
	 * @return
	 */
	List<ReplyVo> selectRepliesForQuestion(Integer qid);
	
	Integer selectReplyCountByQid(Integer qid);
}
