package com.intraway.fizzbuzz.api.utils;

import com.intraway.fizzbuzz.api.service.responses.BadResponse;
import com.intraway.fizzbuzz.api.service.responses.Response;

public class FizzBuzzUtils {
	

	public static Response getBadResponse(String min, String max) {
		BadResponse badResponse = new BadResponse();
		badResponse.setStatus("400");
		badResponse.setError("Bad Request");
		badResponse.setException("com.intraway.exception.badrequest");
		badResponse.setMessage("Los parametros enviados son incorrectos");
		badResponse.setPath("/intraway/api/fizzbuzz/" + min + "/" + max);
		return badResponse;
	}

}
