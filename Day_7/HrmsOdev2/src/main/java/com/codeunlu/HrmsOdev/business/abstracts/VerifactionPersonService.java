package com.codeunlu.HrmsOdev.business.abstracts;

import com.codeunlu.HrmsOdev.core.utilities.results.Result;


public interface VerifactionPersonService {
    Result verifyPerson(int personId, int userId);
}
