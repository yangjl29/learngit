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
	public List<QuestionVo> getNewestTags(Integer offset, Integer count) {
		return questionMapper.selectNewestTags(offset,count);
	}

	@Override
	public List<QuestionVo> getHottestTags(Integer offset, Integer count) {
		return questionMapper.selectHottestTags(offset,count);
	}
	
	@Override
	public List<QuestionVo> getUnAnsweredTags(Integer offset, Integer count) {
		return questionMapper.selectUnAnsweredTags(offset,count);
	}


	@Override
	public Question getQuestionById(Integer qid) {
		return questionMapper.selectQuesitonById(qid);
	}

	@Override
	public void addQuestion(Question question) {
		questionMapper.insertQuestion(question);
	}

	@Override
	public List<QuestionVo> getQuestionsByKeyword(String keyword, Integer offset, Integer count) {
		String key = "%"+keyword+"%";
		return questionMapper.selectQuestionsByKeyword(key, offset, count);
	}


	@Override
	public Integer getQuestionCountByKeyword(String keyword) {
		String key = "%"+keyword+"%";
		return questionMapper.selectQuestionCountByKeyword(key);
	}

	@Override
	public Integer getAllQuestionsCount() {
		return questionMapper.selectAllQuestionsCount();
	}


}
