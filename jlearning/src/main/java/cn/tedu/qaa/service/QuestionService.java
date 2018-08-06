package cn.tedu.qaa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.mapper.QuestionMapper;
@Service
public class QuestionService implements IQuestionService {
	
	@Resource
	private QuestionMapper questionMapper;

	@Override
	public List<Question> getNewestQuestions() {
		return questionMapper.selectNewestQuestions();
	}

	@Override
	public List<Question> getHottestQuestions() {
		return questionMapper.selectHottestQuestions();
	}

	@Override
	public List<Question> getUnAnsweredQuestions() {
		return questionMapper.selectUnAnsweredQuestions();
	}

	@Override
	public void addQuestion(Question question) {
		questionMapper.insertQuestion(question);
	}

}
