package ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Company;
import ua.service.CompanyService;
import ua.service.implementation.editor.CompanyEditor;

@Controller
public class IndexController {

	@Autowired
	private CompanyService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Company.class, new CompanyEditor(service));
	}
	
	@ModelAttribute("company")
	public Company getCompany(){
		return new Company();
	}
	
	@RequestMapping("/")
	public String index(Model model){
		List<Company> companies = service.findAll();
		model.addAttribute("companies", companies);
		model.addAttribute("parents", companies);
		return "index";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.POST)
	public String save(@ModelAttribute("company") Company company){
		service.save(company);
		return "redirect:/";
	}
}
