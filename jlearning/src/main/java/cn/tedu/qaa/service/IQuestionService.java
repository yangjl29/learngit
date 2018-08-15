package cn.tedu.qaa.service;

import java.util.List;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.vo.QuestionVo;

public interface IQuestionService {

	List<QuestionVo> getNewestTags();
	
	List<QuestionVo> getHottestTags();
	
	List<QuestionVo> getUnAnsweredTags();
	
	List<QuestionVo> getAll();
}
