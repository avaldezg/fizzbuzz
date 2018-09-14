package com.intraway.fizzbuzz.junit;

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
import com.intraway.fizzbuzz.api.service.responses.BadResponse;
import com.intraway.fizzbuzz.api.service.responses.Response;
import com.intraway.fizzbuzz.api.service.responses.ResponseOk;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FizzBuzzApplication.class)
public class FizzBuzzApplicationJUnitTests {
	private static Logger logger = LoggerFactory.getLogger(FizzBuzzApplicationJUnitTests.class);

	@Autowired
	private FizzBuzz fizzbull;

	@Test
	public void fizzbuzz_test_range_one_three() {
		logger.info("FIRST TEST--- range (1,3)") ;
		ResponseOk response = (ResponseOk)fizzbull.rangeList("1", "3");
		logger.info(response.toString());
		String message="se encontraron multiplos de 3";
		Assert.assertTrue(message, response.getDescription().equalsIgnoreCase(message));

	}

	@Test
	public void fizzbuzz_test_range_one_fifteen() {
		logger.info("SECOND TEST--- range (1,15)");
		ResponseOk response = (ResponseOk)fizzbull.rangeList("1", "15");
		String message ="se encontraron multiplos de 3 y de 5";
		logger.info(response.toString());
		Assert.assertTrue(message, response.getDescription().equalsIgnoreCase(message));

	}
	
	@Test
	public void fizzbuzz_test_range_four_five(){
		logger.info("THREE TEST--- range (4,5)");
		ResponseOk response = (ResponseOk)fizzbull.rangeList("4", "5");
		logger.info(response.toString());
		String message = "se encontraron multiplos de 5";
		Assert.assertTrue(message, response.getDescription().equalsIgnoreCase(message));

	}

	@Test
	public void fizzbuzz_test_bad_range() {
		logger.info("BAD RANGE");
		BadResponse response = (BadResponse)fizzbull.rangeList("5", "-2");
		logger.info(response.toString());
		Assert.assertFalse("parametros enviados son incorrectos", false);

	}
	
	@Test
	public void fizzbuzz_test_bad_request_null_null(){
		logger.info("BAD REQUEST");
		Response response = fizzbull.rangeList(null,null);
		logger.info(response.toString());
		Assert.assertFalse("parametros enviados son incorrectos", false);

	}
	
	@Test
	public void fizzbuzz_test_bad_request_null_four() {
		logger.info("BAD REQUEST TWO");
		Response response = fizzbull.rangeList(null,"4");
		logger.info(response.toString());
		Assert.assertFalse("parametros enviados son incorrectos", false);

	}
	
	@Test
	public void fizzbuzz_test_bad_request_zero_null(){
		logger.info("BAD REQUEST THREE");
		Response response = fizzbull.rangeList("0",null);
		logger.info(response.toString());
		Assert.assertFalse("parametros enviados son incorrectos", false);

	}
}
