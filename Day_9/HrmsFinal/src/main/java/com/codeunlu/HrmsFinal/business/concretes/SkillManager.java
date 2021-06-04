package com.codeunlu.HrmsFinal.business.concretes;

import com.codeunlu.HrmsFinal.business.abstracts.SkillService;
import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.core.utilies.results.SuccessResult;
import com.codeunlu.HrmsFinal.dataAccess.abstracts.SkillDao;
import com.codeunlu.HrmsFinal.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillManager implements SkillService {
    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao){
        this.skillDao = skillDao;
    }
    @Override
    public Result add(Skill skill) {
        skillDao.save(skill);
        return new SuccessResult("Registered is Skill");
    }
}
