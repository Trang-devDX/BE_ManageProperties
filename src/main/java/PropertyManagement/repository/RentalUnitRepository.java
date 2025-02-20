package PropertyManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import PropertyManagement.repository.entity.RentalUnitEntity;

public interface RentalUnitRepository extends JpaRepository<RentalUnitEntity, Long>{
	List<RentalUnitEntity> findAll();
	@Query("SELECT r FROM RentalUnitEntity r WHERE " +
            "(:rentPriceFrom IS NULL OR r.rentPrice >= :rentPriceFrom) AND " +
            "(:rentPriceTo IS NULL OR r.rentPrice <= :rentPriceTo)")
    List<RentalUnitEntity> searchRentalUnit(
            @Param("rentPriceFrom") Double rentPriceFrom,
            @Param("rentPriceTo") Double rentPriceTo
    );
}
