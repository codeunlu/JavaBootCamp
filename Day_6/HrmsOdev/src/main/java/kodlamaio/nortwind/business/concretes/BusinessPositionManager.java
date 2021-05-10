package kodlamaio.nortwind.business.concretes;

import kodlamaio.nortwind.business.abstracts.BusinessPositionService;
import kodlamaio.nortwind.dataAccess.abstracts.BusinessPositionDao;
import kodlamaio.nortwind.entities.concretes.BusinessPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessPositionManager implements BusinessPositionService {

    private BusinessPositionDao businessPositionDao;

    @Autowired
    public BusinessPositionManager(BusinessPositionDao businessPositionDao) {
        super();
        this.businessPositionDao = businessPositionDao;
    }

    @Override
    public List<BusinessPosition> getAll() {
        return businessPositionDao.findAll();
    }
}
