package cn.tedu.qaa.service;

import java.util.List;

import cn.tedu.qaa.bean.Question;

public interface IQuestionService {

	List<Question> getNewestQuestion();
}
