package lgs.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lgs.entity.City;
import lgs.service.CityService;

@Component
public class CityEditor extends PropertyEditorSupport{

	@Autowired
	CityService CityService;
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		City city = CityService.getCityById(Integer.valueOf(text));
		setValue(city);
		}
	
	
}
