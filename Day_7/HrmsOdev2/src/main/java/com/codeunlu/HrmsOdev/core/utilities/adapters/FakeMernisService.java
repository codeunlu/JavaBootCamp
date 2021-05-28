package com.codeunlu.HrmsOdev.core.utilities.adapters;

public interface FakeMernisService {
    boolean validateByMernis(String nationalId, String firstName, String lastName, String yearOfBirth);
}
