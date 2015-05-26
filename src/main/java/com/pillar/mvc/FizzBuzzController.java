package com.pillar.mvc;

import com.pillar.fizzbuzz.FizzBuzz;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FizzBuzzController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "fizzbuzz";
	}

	@RequestMapping(value = "/Process", method = RequestMethod.POST)
	public ResponseEntity process(Integer input){
		FizzBuzz fizzBuzz = new FizzBuzz();

		try {
			return new ResponseEntity(fizzBuzz.process(input), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}