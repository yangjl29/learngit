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
	public List<Question> getNewestQuestion() {
		return questionMapper.selectNewestQuestion();
	}

}
