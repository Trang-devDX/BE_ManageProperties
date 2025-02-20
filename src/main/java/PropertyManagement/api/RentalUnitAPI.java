package PropertyManagement.api;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PropertyManagement.model.RentalUnitDTO;
import PropertyManagement.repository.RentalUnitRepository;
import PropertyManagement.service.RentalUnitService;

@CrossOrigin(origins = "http://127.0.0.1:5500") // Cho phép frontend truy cập
@RestController
@RequestMapping("/api/rental-units")
public class RentalUnitAPI {
	@Autowired
	private RentalUnitService rentalUnitService;
	
	@Autowired
	private RentalUnitRepository rentalUnitRepository;
	
	@GetMapping
	public List<RentalUnitDTO> getAllRentalUnits(){
		List<RentalUnitDTO> result = rentalUnitService.getAllRentalUnits();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public RentalUnitDTO getRentalUnit(@PathVariable Long id) {
		return rentalUnitService.getRentalUnit(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteRentalUnit(@PathVariable Long id) {
		rentalUnitRepository.deleteById(id);
	}
	
	@PutMapping()
	public ResponseEntity<RentalUnitDTO> updateRentalUnit(@RequestBody RentalUnitDTO rentalUnitDTO){
		try {
            RentalUnitDTO updatedUnit = rentalUnitService.updateRentalUnit(rentalUnitDTO);
            return ResponseEntity.ok(updatedUnit);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }		
	}
	
	@GetMapping(value = "/search")
	public List<RentalUnitDTO> searchRentalUnit(@RequestParam(name = "rentPriceFrom", required = false) Double rentPriceFrom,
												@RequestParam(name = "rentPriceTo", required = false) Double rentPriceTo){
		return rentalUnitService.searchRentalUnit(rentPriceFrom, rentPriceTo);
	}
	
	

}
