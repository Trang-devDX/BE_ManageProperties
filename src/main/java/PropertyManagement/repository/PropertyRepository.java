package PropertyManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import PropertyManagement.repository.entity.PropertyEntity;
import PropertyManagement.repository.entity.RentalUnitEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long>{
	List<PropertyEntity> findAll();
}
