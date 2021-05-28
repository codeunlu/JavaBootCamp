package com.codeunlu.HrmsOdev.business.abstracts;

import com.codeunlu.HrmsOdev.core.utilities.results.Result;
public interface VerifactionService {
    void hasCode(int id);
    Result sendMail(String email);
    Result findAllByCode(String code);
}
