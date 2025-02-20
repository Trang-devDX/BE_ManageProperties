package PropertyManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PropertyManagement.model.PropertyDTO;
import PropertyManagement.repository.PropertyRepository;
import PropertyManagement.repository.entity.PropertyEntity;
import PropertyManagement.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	public List<PropertyDTO> getAllProperties() {
		List<PropertyDTO> propertyDTO = new ArrayList<PropertyDTO>();
		return propertyDTO;
	}
}
