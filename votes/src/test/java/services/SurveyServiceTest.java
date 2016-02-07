package services;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import domain.Census;
import domain.Question;
import domain.Survey;
import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=false)
public class SurveyServiceTest extends AbstractTest{

	@Autowired
	private SurveyService surveyService;
	

	@Test
	public void saveCreateSurveyTest(){
		
		Survey s = new Survey();
		
		//Census c = new Census();
		Collection<Question> questions = new LinkedList<>();
		Question q = new Question("Pregunta cualquiera");
		questions.add(q);
		
			
		s.setCensus(2);
		s.setDescription("Prueba");
		s.setTitle("Titulo prueba");
		s.setStartDate(LocalDate.now());
		s.setEndDate(LocalDate.now());
		s.setQuestions(questions);
		
		
		surveyService.save(s);
		
		System.out.println("====== Mostrando los surveys despues de guardar ======");
		for(Survey e : surveyService.findAll()){
			System.out.println(e);
		}
			
	}

	
	@Test
	public void getAllFinishedSurveysTest(){
		
		Survey s = new Survey();
		Collection<Question> questions = new LinkedList<>();
		Question q = new Question("Pregunta cualquiera");
		questions.add(q);
		
		s.setCensus(2);
		s.setDescription("Prueba");
		s.setTitle("Titulo prueba");
		s.setStartDate(LocalDate.now());
		s.setEndDate(LocalDate.now());
		s.setQuestions(questions);
		
		Survey s2 = new Survey();
		Collection<Question> questions2 = new LinkedList<>();
		Question q2 = new Question("Pregunta cualquiera2");
		questions2.add(q2);
		
		s2.setCensus(5);
		s2.setDescription("Prueba2");
		s2.setTitle("Titulo prueba2");
		s2.setStartDate(LocalDate.now());
		s2.setEndDate(LocalDate.of(2020, 10, 15));
		s2.setQuestions(questions2);
		
		surveyService.save(s);
		surveyService.save(s2);
		
		System.out.println("====== Mostrando los surveys despues de guardar ======");
		for(Survey a : surveyService.findAll()){
			System.out.println(a);
		}
		
		List<Survey> res = surveyService.getAllFinishedSurveys();
		System.out.println("====== Mostrando solo la prueba terminada ======");
		System.out.println(res);
		
	}
	
	@Test
	public void getAllCreatedSurveysTest(){
		
		Survey s = new Survey();
		Collection<Question> questions = new LinkedList<>();
		Question q = new Question("Pregunta cualquiera");
		questions.add(q);
		String usuario1 = "Usuario1";
		
		s.setCensus(2);
		s.setDescription("Prueba");
		s.setTitle("Titulo prueba");
		s.setStartDate(LocalDate.now());
		s.setEndDate(LocalDate.now());
		s.setQuestions(questions);
		s.setUsernameCreator(usuario1);
		
		Survey s2 = new Survey();
		Collection<Question> questions2 = new LinkedList<>();
		Question q2 = new Question("Pregunta cualquiera2");
		questions2.add(q2);
		String usuario2 = "Usuario2";
		
		s2.setCensus(5);
		s2.setDescription("Prueba2");
		s2.setTitle("Titulo prueba2");
		s2.setStartDate(LocalDate.now());
		s2.setEndDate(LocalDate.of(2020, 10, 15));
		s2.setQuestions(questions2);
		s.setUsernameCreator(usuario2);
		
		surveyService.save(s);
		surveyService.save(s2);
		
		System.out.println("====== Mostrando los surveys despues de guardar ======");
		for(Survey a : surveyService.findAll()){
			System.out.println(a);
		}
		
		List<Survey> res = surveyService.getAllCreatedSurveys(usuario2);
		System.out.println("====== Mostrando Surveys filtradas por usernameCreator ======");
		System.out.println(res);
		
	}
	
	@Test
	public void deleteTest(){
	
		Survey s = new Survey();
		Collection<Question> questions = new LinkedList<>();
		Question q = new Question("Pregunta cualquiera");
		questions.add(q);
		String usuario1 = "Usuario1";
		
		s.setCensus(2);
		s.setDescription("Prueba");
		s.setTitle("Titulo prueba");
		s.setStartDate(LocalDate.now());
		s.setEndDate(LocalDate.now());
		s.setQuestions(questions);
		s.setUsernameCreator(usuario1);
		
		Survey s2 = new Survey();
		Collection<Question> questions2 = new LinkedList<>();
		Question q2 = new Question("Pregunta cualquiera2");
		questions2.add(q2);
		String usuario2 = "Usuario2";
		
		s2.setCensus(5);
		s2.setDescription("Prueba2");
		s2.setTitle("Titulo prueba2");
		s2.setStartDate(LocalDate.now());
		s2.setEndDate(LocalDate.of(2020, 10, 15));
		s2.setQuestions(questions2);
		s.setUsernameCreator(usuario2);
		
		surveyService.save(s);
		surveyService.save(s2);
		
		System.out.println("====== Mostrando los surveysIDs despues de guardar ======");
		for(Survey a : surveyService.findAll()){
			System.out.println(a.getId());
		}
		
		surveyService.delete(17);
		
		System.out.println("====== Mostrando los surveysIDs despues de borrar ======");
		for(Survey a : surveyService.findAll()){
			System.out.println(a.getId());
		}
		
	}
	
	@Test
	public void posibleTest(){
		
		Survey s = new Survey();
		Collection<Question> questions = new LinkedList<>();
		Question q = new Question("Pregunta cualquiera");
		questions.add(q);
		String usuario1 = "Usuario1";
		
		s.setCensus(2);
		s.setDescription("Prueba");
		s.setTitle("Titulo prueba");
		s.setStartDate(LocalDate.now());
		s.setEndDate(LocalDate.now());
		s.setQuestions(questions);
		s.setUsernameCreator(usuario1);
		
		Survey s2 = new Survey();
		Collection<Question> questions2 = new LinkedList<>();
		Question q2 = new Question("Pregunta cualquiera2");
		questions2.add(q2);
		String usuario2 = "Usuario2";
		
		s2.setCensus(null);
		s2.setDescription("Prueba2");
		s2.setTitle("Titulo prueba2");
		s2.setStartDate(LocalDate.now());
		s2.setEndDate(LocalDate.of(2020, 10, 15));
		s2.setQuestions(questions2);
		s.setUsernameCreator(usuario2);
		
		surveyService.save(s);
		surveyService.save(s2);
		
		System.out.println("====== Mostrando los surveys despues de guardar ======");
		for(Survey a : surveyService.findAll()){
			System.out.println(a.getId());
		}
		System.out.println("====== Mostrando si es posible añadir censo ======");
		System.out.println(surveyService.posible(9));
		System.out.println(surveyService.posible(11));
	}
	
}
