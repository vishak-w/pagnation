package com.example.demo.entity;

import lombok.Data;

@Data
public class PagingRequest {
	
	private Integer pageNumber;
	private Integer pageSize;

}
