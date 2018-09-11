package com.intraway.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intraway.fizzbuzz.api.FizzBuzzApplication;
import com.intraway.fizzbuzz.api.model.FizzBuzz;
import com.intraway.fizzbuzz.api.service.responses.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {FizzBuzzApplication.class})
public class FizzBuzzApplicationTests {
	private static Logger logger = LoggerFactory.getLogger(FizzBuzzApplicationTests.class);

	@Autowired
	private FizzBuzz fizzbull;

	@Test
	public void testOne() {
		logger.info("FIRST TEST--- range (1,3)") ;
		Response response = fizzbull.rangeList("1", "3");
		logger.info(response.toString());
		Assert.assertTrue("se encontraron multiplos de 3", true);

	}

	@Test
	public void testTwo() {
		logger.info("SECOND TEST--- range (1,15)");
		Response response = fizzbull.rangeList("1", "15");
		logger.info(response.toString());
		Assert.assertTrue("se encontraron multiplos de 3 y de 5", true);

	}
	
	@Test
	public void testThree(){
		logger.info("THREE TEST--- range (4,5)");
		Response response = fizzbull.rangeList("4", "5");
		logger.info(response.toString());
		Assert.assertTrue("se encontraron multiplos de 5", true);

	}

	@Test
	public void badRange() {
		logger.info("BAD RANGE");
		Response response = fizzbull.rangeList("5", "-2");
		logger.info(response.toString());
		Assert.assertFalse("parametros enviados son incorrectos", false);

	}
	
	@Test
	public void badRequest(){
		logger.info("BAD REQUEST");
		Response response = fizzbull.rangeList(null,null);
		logger.info(response.toString());
		Assert.assertFalse("parametros enviados son incorrectos", false);

	}
	
	@Test
	public void badRequestTwo() {
		logger.info("BAD REQUEST TWO");
		Response response = fizzbull.rangeList(null,"4");
		logger.info(response.toString());
		Assert.assertFalse("parametros enviados son incorrectos", false);

	}
	
	@Test
	public void badRequestThree(){
		logger.info("BAD REQUEST THREE");
		Response response = fizzbull.rangeList("0",null);
		logger.info(response.toString());
		Assert.assertFalse("parametros enviados son incorrectos", false);

	}
}
