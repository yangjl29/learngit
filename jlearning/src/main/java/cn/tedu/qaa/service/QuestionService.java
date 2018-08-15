package cn.tedu.qaa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.mapper.QuestionMapper;
import cn.tedu.qaa.vo.QuestionVo;
@Service
public class QuestionService implements IQuestionService {
	
	@Resource
	private QuestionMapper questionMapper;
	
	@Override
	public List<QuestionVo> getNewestTags() {
		return questionMapper.selectNewestTags();
	}

	@Override
	public List<QuestionVo> getHottestTags() {
		return questionMapper.selectHottestTags();
	}
	
	@Override
	public List<QuestionVo> getUnAnsweredTags() {
		return questionMapper.selectUnAnsweredTags();
	}

	@Override
	public List<QuestionVo> getAll() {
		return questionMapper.selectAll();
	}

}
