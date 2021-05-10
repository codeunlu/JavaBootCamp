package kodlamaio.nortwind.dataAccess.abstracts;

import kodlamaio.nortwind.entities.concretes.BusinessPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessPositionDao extends JpaRepository<BusinessPosition, Integer> {

}
