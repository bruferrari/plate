package com.plate.dao.model;

import java.util.List;

import com.plate.model.Banks;

public interface BanksDAO {
			
	
	Banks findId(Long id);
	
	
	List<Banks> listAll();
}
