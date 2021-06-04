package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.WorkplaceService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.WorkplaceDao;
import com.codeunlu.HrmsFinal.entities.concretes.Workplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkplaceManager implements WorkplaceService {
    private WorkplaceDao workplaceDao;
    @Autowired
    public WorkplaceManager(WorkplaceDao workplaceDao){
        this.workplaceDao = workplaceDao;
    }

    @Override
    public Result add(Workplace workplace) {
        workplaceDao.save(workplace);
        return new SuccessResult("Registered is Workplaces");
    }
}
