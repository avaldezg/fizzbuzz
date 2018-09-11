package com.intraway.fizzbuzz.api.model;

import com.intraway.fizzbuzz.api.service.responses.Response;

public interface FizzBuzz {
	
	Response rangeList(String min, String max);

}
