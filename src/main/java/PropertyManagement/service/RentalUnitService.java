package PropertyManagement.service;

import java.util.List;

import PropertyManagement.model.RentalUnitDTO;

public interface RentalUnitService {
	List<RentalUnitDTO> getAllRentalUnits();
	RentalUnitDTO getRentalUnit(Long id);
	RentalUnitDTO updateRentalUnit(RentalUnitDTO rentalUnitDTO);
	List<RentalUnitDTO> searchRentalUnit(Double rentPriceFrom, Double rentPriceTo);
}
