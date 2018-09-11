package com.intraway.fizzbuzz.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intraway.fizzbuzz.api.dto.ResponseType;
import com.intraway.fizzbuzz.api.entities.EntityRequest;
import com.intraway.fizzbuzz.api.entities.EntityResponse;
import com.intraway.fizzbuzz.api.exceptions.BadRequestException;
import com.intraway.fizzbuzz.api.model.FizzBuzz;
import com.intraway.fizzbuzz.api.repository.RequestRepository;
import com.intraway.fizzbuzz.api.repository.ResponseRepository;
import com.intraway.fizzbuzz.api.service.responses.BadResponse;
import com.intraway.fizzbuzz.api.service.responses.Response;
import com.intraway.fizzbuzz.api.service.responses.ResponseOk;
import com.intraway.fizzbuzz.api.utils.FizzBuzzUtils;

@RestController
public class RestService {

	@Autowired
	private FizzBuzz fizzbuzz;

	@Autowired
	private RequestRepository requestRepository;

	@Autowired
	private ResponseRepository responseRepository;

	@GetMapping("/intraway/api/fizzbuzz/{min}/{max}")
	public Response fizzbuzz(@PathVariable(name = "min", required = true) String min,
			@PathVariable(name = "max", required = true) String max) {

		EntityRequest entityRequest = new EntityRequest();
		entityRequest.setMethod("/intraway/api/fizzbuzz/");
		entityRequest.setParametes("min=" + min + ", max=" + max);
		entityRequest.setRequestDate(new Date());
		requestRepository.save(entityRequest);

		try {

			if (min == null || min.isEmpty() || max == null || max.isEmpty()) {

				BadResponse badResponse = (BadResponse) FizzBuzzUtils.getBadResponse(min, max);
				saveBadResponse(entityRequest, badResponse);
				return badResponse;

			} else {
				ResponseOk responseOk = (ResponseOk) fizzbuzz.rangeList(min, max);

				saveResponseOk(entityRequest, responseOk);
				return responseOk;
			}

		} catch (RuntimeException e) {
			 BadResponse badResponse = (BadResponse) FizzBuzzUtils.getBadResponse(min,
			 max);
			 saveBadResponse(entityRequest, badResponse);
			throw new BadRequestException(badResponse.getStatus(),badResponse.getError(), badResponse.getException(), badResponse.getMessage(), badResponse.getPath());


		}
	}

	private void saveBadResponse(EntityRequest entityRequest, BadResponse badResponse) {
		EntityResponse entityResponse = new EntityResponse();
		entityResponse.setTimestamp(badResponse.getTimestamp());
		entityResponse.setMessage(badResponse.getMessage());
		entityResponse.setType(ResponseType.BAD_REQUEST);
		entityResponse.setAdditionalData("Exception=" + badResponse.getException() + "&path=" + badResponse.getPath());
		entityResponse.setRequest(entityRequest);
		entityRequest.setResponse(entityResponse);
		entityResponse.setCode("404");

		responseRepository.save(entityResponse);
	}

	private void saveResponseOk(EntityRequest entityRequest, ResponseOk responseOk) {
		EntityResponse entityResponse = new EntityResponse();

		entityResponse.setTimestamp(responseOk.getTimestamp());
		entityResponse.setMessage(responseOk.getDescription());
		entityResponse.setType(ResponseType.RESPONSE_OK);
		entityResponse.setAdditionalData(responseOk.getList());
		entityResponse.setRequest(entityRequest);
		entityResponse.setCode(responseOk.getCode());
		entityRequest.setResponse(entityResponse);

		responseRepository.save(entityResponse);
	}

}
