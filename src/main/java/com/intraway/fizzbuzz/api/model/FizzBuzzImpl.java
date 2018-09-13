package com.intraway.fizzbuzz.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.intraway.fizzbuzz.api.service.responses.Response;
import com.intraway.fizzbuzz.api.service.responses.ResponseOk;
import com.intraway.fizzbuzz.api.utils.FizzBuzzUtils;

@Service("fizzbuzzImpl")
public class FizzBuzzImpl implements FizzBuzz, Serializable {
	private static final long serialVersionUID = -144003562365881387L;

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(FizzBuzzImpl.class);

	@Override
	public Response rangeList(String minStr, String maxStr){

		List<String> rangeList = new ArrayList<String>();
		// Defensive programing (only used by the tests)
		if (minStr == null || minStr.isEmpty() || maxStr == null || maxStr.isEmpty()) {
			
			return FizzBuzzUtils.getBadResponse(minStr, maxStr);			
		}
		Integer min = Integer.parseInt(minStr);
		Integer max = Integer.parseInt(maxStr);
		if (min <= max) {

			boolean existsMultiplesOfThree = false;
			boolean existsMultiplesOfFive = false;

			ResponseOk responseOk = new ResponseOk();

			for (int i = min; i <= max; i++) {

				if (isMultipleOfThree(i) && isMultipleOfFive(i)) {
					rangeList.add("FizzBuzz");
					existsMultiplesOfThree = true;
					existsMultiplesOfFive = true;

				} else if (isMultipleOfThree(i)) {
					rangeList.add("Fizz");
					existsMultiplesOfThree = true;

				} else if (isMultipleOfFive(i)) {
					rangeList.add("Buzz");
					existsMultiplesOfFive = true;
				} else {
					logger.debug("agrego numero a la lista >>> " + i);
					rangeList.add(String.valueOf(i));
				}
				if (i == max) {
					if (existsMultiplesOfThree && existsMultiplesOfFive) {
						responseOk.setDescription("se encontraron multiplos de 3 y de 5");
						responseOk.setCode("001");
					}

					if (existsMultiplesOfThree
							&& (responseOk.getDescription() == null || responseOk.getDescription().isEmpty())) {
						responseOk.setDescription("se encontraron multiplos de 3");
						responseOk.setCode("002");

					} else if (existsMultiplesOfFive
							&& (responseOk.getDescription() == null || responseOk.getDescription().isEmpty())) {
						responseOk.setDescription("se encontraron multiplos de 5");
						responseOk.setCode("003");
					}
				}

			}
			responseOk.setList(getList(rangeList));
			return responseOk;
		} else {
			logger.error(
					">>>>>>>Los parametros enviados son incorrectos. [minValue=" + min + ", maxValue=" + max + "]");
			return FizzBuzzUtils.getBadResponse(String.valueOf(min),String.valueOf(max));
			
		}
	}

	private String getList(List<String> rangeList) {
		int i = 1;
		String response = "";
		for (String item : rangeList) {
			response = response + item;
			if (i < rangeList.size()) {
				response = response + ", ";
			}
			i++;

		}
		return response;
	}

	private Boolean isMultipleOfThree(Integer number) {

		if ((number % 3) == 0) {
			logger.info(">>>>>>>se encontro multiplo de 3 >>> " + number);
			return true;

		} else {
			return false;
		}

	}

	private Boolean isMultipleOfFive(Integer number) {
		if ((number % 5) == 0) {
			logger.info(">>>>>>>se encontro multiplo de 5 >>> " + number);
			return true;

		} else {
			return false;
		}

	}

}
