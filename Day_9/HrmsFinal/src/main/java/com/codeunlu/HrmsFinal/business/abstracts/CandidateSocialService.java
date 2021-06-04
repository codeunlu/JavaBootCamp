package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.CandidateSocial;

public interface CandidateSocialService {
    Result add(CandidateSocial candidateSocial);
}
