package PropertyManagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PropertyManagement.converter.RentalUnitDTOConverter;
import PropertyManagement.model.RentalUnitDTO;
import PropertyManagement.repository.RentalUnitRepository;
import PropertyManagement.repository.entity.RentalUnitEntity;
import PropertyManagement.service.RentalUnitService;

@Service
public class RentalUnitServiceImpl implements RentalUnitService {
	@Autowired
	private RentalUnitRepository rentalUnitRepository;
	
	@Autowired
	private RentalUnitDTOConverter rentalUnitDTOConverter;
	
	@Override
	public List<RentalUnitDTO> getAllRentalUnits(){
		List<RentalUnitEntity> rentalUnitEntities = rentalUnitRepository.findAll();
		List<RentalUnitDTO> result = new ArrayList<RentalUnitDTO>();
		for(RentalUnitEntity item : rentalUnitEntities) {
			RentalUnitDTO rentalUnit = rentalUnitDTOConverter.toRentalUnitDTO(item);
			result.add(rentalUnit);
		}
		return result;
	}
	
	@Override
	public RentalUnitDTO getRentalUnit(Long id) {
		Optional<RentalUnitEntity> rentalUnitOptional  = rentalUnitRepository.findById(id);
		if(rentalUnitOptional .isPresent()) {
			RentalUnitEntity rentalUnitEntity = rentalUnitOptional.get();
			RentalUnitDTO result = rentalUnitDTOConverter.toRentalUnitDTO(rentalUnitEntity);
			return result;
		}else {
			throw new EntityNotFoundException("Không tìm thấy rental unit với ID " + id);
		}
	}
	
	@Override
	public RentalUnitDTO updateRentalUnit(RentalUnitDTO rentalUnitDTO) {
		if (rentalUnitDTO.getId() == null) {
            throw new IllegalArgumentException("ID is required for updating a rental unit.");
        }
		
		Optional<RentalUnitEntity> optionalUnit = rentalUnitRepository.findById(rentalUnitDTO.getId());
		
		if (optionalUnit.isPresent()) {		
			RentalUnitEntity rentalUnit = optionalUnit.get();
			if (rentalUnitDTO.getRentPrice() != null) {
				rentalUnit.setRentPrice(rentalUnitDTO.getRentPrice());
			}
			if (rentalUnitDTO.getUnitNumber() != null) {
				rentalUnit.setUnitNumber(rentalUnitDTO.getUnitNumber());
			}
			rentalUnitRepository.save(rentalUnit);
			return rentalUnitDTOConverter.toRentalUnitDTO(rentalUnit);
		} else {
			throw new EntityNotFoundException("Rental unit not found with ID: " + rentalUnitDTO.getId());
		}
	}
	
	@Override
	public List<RentalUnitDTO> searchRentalUnit(Double rentPriceFrom, Double rentPriceTo) {
        List<RentalUnitEntity> rentalUnits = rentalUnitRepository.searchRentalUnit(rentPriceFrom, rentPriceTo);
        List<RentalUnitDTO> result = new ArrayList<RentalUnitDTO>();
        for(RentalUnitEntity item : rentalUnits) {
        	RentalUnitDTO rentalUnit = rentalUnitDTOConverter.toRentalUnitDTO(item);
			result.add(rentalUnit);
        }
        return result;
	}
}
