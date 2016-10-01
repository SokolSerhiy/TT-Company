package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.service.CompanyService;

public class CompanyEditor extends PropertyEditorSupport{

	private final CompanyService service;

	public CompanyEditor(CompanyService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(service.findOne(Integer.valueOf(text)));
	}
	
}
