package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository repo;

	public List<Country> getAllDetails(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);

		Page<Country> result = repo.findAll(page);
		return result.toList();
	}

	public Country addData(Country country) {
		return repo.save(country);
	}

}
