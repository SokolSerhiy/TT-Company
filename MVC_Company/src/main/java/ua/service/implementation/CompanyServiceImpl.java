package ua.service.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Company;
import ua.repository.CompanyRepository;
import ua.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public void save(Company company) {
		companyRepository.save(company);
	}

	@Override
	public Company findOne(int id) {
		return companyRepository.findOne(id);
	}

	@Override
	@Transactional
	public List<Company> findAll() {
		List<Company> parents = companyRepository.findByParentIsNull();
		initChild(parents);
		getMoney(parents);
		return parents;
	}
	
	private void initChild(List<Company> parents){
		for (Company company : parents) {
			Hibernate.initialize(company.getChilds());
			initChild(company.getChilds());
		}
	}
	
	private void getMoney(List<Company> parents){
		for (Company company : parents) {
			company.setAllmoney(company.getMoney()+countMoney(company.getChilds()));
			getMoney(company.getChilds());
		}
	}
	
	private int countMoney(List<Company> parents){
		int allMoney = 0;
		for (Company company : parents) {
			allMoney+=company.getMoney();
			allMoney+=countMoney(company.getChilds());
		}
		return allMoney;
	}
}
