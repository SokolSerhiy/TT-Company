package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

	List<Company> findByParentIsNull();
}
