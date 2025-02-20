package PropertyManagement.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import PropertyManagement.model.RentalUnitDTO;
import PropertyManagement.repository.entity.RentalUnitEntity;

@Component
public class RentalUnitDTOConverter {
	@Autowired ModelMapper modelMapper;
	
	public RentalUnitDTO toRentalUnitDTO(RentalUnitEntity item) {
		RentalUnitDTO rentalUnitDTO = modelMapper.map(item, RentalUnitDTO.class);
		rentalUnitDTO.setAddress(item.getProperty().getStreet() + ", Phường " + item.getProperty().getWard() +", Quận " + item.getProperty().getDistrict());
		rentalUnitDTO.setName(item.getProperty().getName());
		rentalUnitDTO.setManagerName(item.getProperty().getManagerName());
		rentalUnitDTO.setManagerPhone(item.getProperty().getManagerPhone());
		return rentalUnitDTO;
	}
}
