package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.qaa.bean.Question;
import cn.tedu.qaa.mapper.QuestionMapper;
import cn.tedu.qaa.service.IQuestionService;

public class TestQuestion {

	
	@Test
	public void testInsertQ(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		QuestionMapper qm = ac.getBean("questionMapper",QuestionMapper.class);
//		Question q = new Question();
//		q.setUid(2);
//		q.setTitle("这是一个标题");
//		q.setContent("这里是内容");
//		qm.insertQuestion(q);
		System.out.println(qm.selectAllQuestionsCount());
		
		ac.close();
	}
	
	@Test
	public void testAddQ(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IQuestionService qs = ac.getBean("questionService",IQuestionService.class);
		/*Question q = new Question();
		q.setUid(2);
		q.setTitle("这是一个标题");
		q.setContent("这里是内容");
		qs.addQuestion(q);*/
		
		
		ac.close();
	}
	
	@Test
	public void testSelectById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		QuestionMapper qm = ac.getBean("questionMapper",QuestionMapper.class);
		System.out.println(qm.selectQuesitonById(2));
		ac.close();
	}
	
	@Test
	public void test(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IQuestionService qs = ac.getBean("questionService",IQuestionService.class);
		ac.close();
	}
	
}
