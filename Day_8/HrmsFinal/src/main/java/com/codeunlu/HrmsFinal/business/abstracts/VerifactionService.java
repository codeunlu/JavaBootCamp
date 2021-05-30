package com.codeunlu.HrmsFinal.business.abstracts;

import com.codeunlu.HrmsFinal.core.utilies.results.Result;
import com.codeunlu.HrmsFinal.entities.concretes.Verifaction;

public interface VerifactionService {
    Result add(int userId,String email,Verifaction verifaction);
    Result active(String code);
    Result activeEmployee(int userId, int employeeId);
}
