package com.codeunlu.HrmsOdev.business.abstracts;

import com.codeunlu.HrmsOdev.entities.concretes.Employer;
import com.codeunlu.HrmsOdev.entities.concretes.Person;
import com.codeunlu.HrmsOdev.entities.concretes.User;

public interface FormCheckService {
    boolean isCheckInput(String input);
    boolean isCheckPassword(User user);
    boolean isCheckEmail(String  email);
    boolean isCheckEmployerEmail(String  email);
    boolean isCheckPersonEmail(String  email);
    boolean isCheckCompanyEmail(Employer employer);
    boolean isCheckNationalId(String  nationalId);
    boolean isCheckMernis(String year, String nationalId, String name, String surname);
    boolean isCheckTitle(String title);
}
