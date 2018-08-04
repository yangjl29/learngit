package cn.tedu.qaa.mapper;

import java.util.List;

import cn.tedu.qaa.bean.Question;

public interface QuestionMapper {

	/**
	 * 查询最新的问题
	 * @return
	 */
	List<Question> selectNewestQuestion();
	/**
	 * 查询最热门问题
	 * @return
	 */
	List<Question> selectHottestQuestion();
	/**
	 * 查询未回答问题
	 * @return
	 */
	List<Question> selectUnAnsweredQuestion();
}
