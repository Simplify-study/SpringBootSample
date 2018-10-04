package com.simplify.sample.db.mapper;

import java.util.List;

import com.simplify.sample.db.dto.Test;

public interface TestMapper {

	public List<Test> getAll() throws Exception;
	
}
