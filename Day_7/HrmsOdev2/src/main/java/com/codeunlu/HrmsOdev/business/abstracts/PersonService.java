package com.codeunlu.HrmsOdev.business.abstracts;

import com.codeunlu.HrmsOdev.core.utilities.results.DataResult;
import com.codeunlu.HrmsOdev.core.utilities.results.Result;
import com.codeunlu.HrmsOdev.entities.concretes.Person;

import java.util.List;

public interface PersonService {
    DataResult<List<Person>> get();
    Result add(Person person);
}
