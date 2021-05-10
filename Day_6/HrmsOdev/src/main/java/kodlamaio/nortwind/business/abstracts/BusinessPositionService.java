package kodlamaio.nortwind.business.abstracts;

import kodlamaio.nortwind.entities.concretes.BusinessPosition;

import java.util.List;

public interface BusinessPositionService {
    List<BusinessPosition> getAll();
}
