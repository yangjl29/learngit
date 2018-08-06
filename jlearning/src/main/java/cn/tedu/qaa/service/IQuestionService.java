package cn.tedu.qaa.service;

import java.util.List;

import cn.tedu.qaa.bean.Question;

public interface IQuestionService {

	List<Question> getNewestQuestions();
	
	List<Question> getHottestQuestions();
	
	List<Question> getUnAnsweredQuestions();
	
	void addQuestion(Question question);
}
