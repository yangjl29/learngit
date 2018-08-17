package cn.tedu.qaa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.vo.QuestionVo;

public interface QuestionMapper {

	/**
	 * 查询时间降序的所有问题
	 * @return
	 */
	List<QuestionVo> selectNewestTags(@Param("offset") Integer offset,@Param("count") Integer count);
	/**
	 * 查询回复数降序的所有问题
	 * @return
	 */
	List<QuestionVo> selectHottestTags(@Param("offset") Integer offset,@Param("count") Integer count);
	/**
	 * 查询时间降序的所有未回答问题
	 * @return
	 */
	List<QuestionVo> selectUnAnsweredTags(@Param("offset") Integer offset,@Param("count") Integer count);
	
	Question selectQuesitonById(Integer qid);
	/**
	 * 插入问题信息
	 * @param question
	 */
	void insertQuestion(Question question);
	/**
	 * 查询含有指定关键字的指定页数的问题
	 * @param content
	 * @return
	 */
	List<QuestionVo> selectQuestionsByKeyword(
			@Param("key") String key, 
			@Param("offset") Integer offset, 
			@Param("count") Integer count);
	/**
	 * 查询含有指定关键字的动态标题条数
	 * @param key
	 * @return
	 */
	Integer selectQuestionCountByKeyword(String key);
	
	Integer selectAllQuestionsCount();
}
