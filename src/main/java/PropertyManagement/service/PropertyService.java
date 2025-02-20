package PropertyManagement.service;

import java.util.List;

import PropertyManagement.model.PropertyDTO;
import PropertyManagement.repository.entity.PropertyEntity;

public interface PropertyService {
	List<PropertyDTO> getAllProperties();
}
