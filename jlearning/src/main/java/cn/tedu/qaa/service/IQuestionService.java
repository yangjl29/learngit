package cn.tedu.qaa.service;

import java.util.List;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.vo.QuestionVo;

public interface IQuestionService {
	
	List<QuestionVo> getNewestTags(Integer offset, Integer count);
	
	List<QuestionVo> getHottestTags(Integer offset, Integer count);
	
	List<QuestionVo> getUnAnsweredTags(Integer offset, Integer count);
	
	Question getQuestionById(Integer qid);
	
	void addQuestion(Question question);
	
	List<QuestionVo> getQuestionsByKeyword(String keyword, Integer offset, Integer count);
	
	Integer getQuestionCountByKeyword(String keyword);
	
	Integer getAllQuestionsCount();
}
