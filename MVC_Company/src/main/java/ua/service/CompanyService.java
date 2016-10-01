package ua.service;

import java.util.List;

import ua.entity.Company;

public interface CompanyService {

	void save(Company company);
	
	Company findOne(int id);
	
	List<Company> findAll();
}
