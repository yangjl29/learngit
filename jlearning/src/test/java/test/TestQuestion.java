package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.qaa.mapper.QuestionMapper;
import cn.tedu.qaa.service.IQuestionService;

public class TestQuestion {

	@Test
	public void testSelectNewestQ(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		QuestionMapper qm = ac.getBean("questionMapper",QuestionMapper.class);
		System.out.println(qm.selectNewestQuestion());
		ac.close();
	}
	
	@Test
	public void testGetNewestQ(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IQuestionService qs = ac.getBean("questionService",IQuestionService.class);
		System.out.println(qs.getNewestQuestion());
		ac.close();
	}
}
