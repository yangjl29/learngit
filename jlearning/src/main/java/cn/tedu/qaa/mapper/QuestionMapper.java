package cn.tedu.qaa.mapper;

import java.util.List;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.vo.QuestionVo;

public interface QuestionMapper {

	/**
	 * 查询时间降序的所有问题
	 * @return
	 */
	List<QuestionVo> selectNewestTags();
	/**
	 * 查询回复数降序的所有问题
	 * @return
	 */
	List<QuestionVo> selectHottestTags();
	/**
	 * 查询时间降序的所有未回答问题
	 * @return
	 */
	List<QuestionVo> selectUnAnsweredTags();
	
	List<QuestionVo> selectAll();
}
