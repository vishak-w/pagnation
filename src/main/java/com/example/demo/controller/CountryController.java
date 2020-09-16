package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Country;
import com.example.demo.entity.PagingRequest;
import com.example.demo.service.CountryService;

@RestController
@RequestMapping(value = "v1/api")
public class CountryController {

	@Autowired
	CountryService service;

	@GetMapping(value = "getAll",consumes= {"application/json"},produces= {"application/json"})
	public ResponseEntity<List<Country>> getAllDetails(@RequestBody PagingRequest pagingRequest) {
		Integer pageNumber = pagingRequest.getPageNumber();
		Integer pageSize = pagingRequest.getPageSize();
		List<Country> list = service.getAllDetails(pageNumber, pageSize);
		return new ResponseEntity<List<Country>>(list, HttpStatus.FOUND);
	}
	
	@PostMapping(value="save")
	public ResponseEntity<Country> addData(@RequestBody Country country)
	{
		Country saved=service.addData(country);
		return new ResponseEntity<Country>(saved,HttpStatus.CREATED);
	}

}
