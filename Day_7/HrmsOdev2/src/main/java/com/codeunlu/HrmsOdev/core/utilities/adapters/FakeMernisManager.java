package com.codeunlu.HrmsOdev.core.utilities.adapters;

import com.codeunlu.HrmsOdev.Mernis.MernisService;
import org.springframework.stereotype.Service;

@Service
public class FakeMernisManager implements FakeMernisService{

    public FakeMernisManager(){}

    @Override
    public boolean validateByMernis(String nationalId, String firstName, String lastName, String yearOfBirth){
        MernisService mernis = new MernisService();
        try {
            return mernis.ValidateByPersonalInfo(nationalId,firstName,lastName,yearOfBirth);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
