package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.SocialService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.SocialDao;
import com.codeunlu.HrmsFinal.entities.concretes.Social;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialManager implements SocialService {
    private SocialDao socialDao;

    @Autowired
    public SocialManager(SocialDao socialDao){
        this.socialDao = socialDao;
    }
    @Override
    public Result add(Social social) {
        socialDao.save(social);
        return new SuccessResult("Registered is Social");
    }
}
