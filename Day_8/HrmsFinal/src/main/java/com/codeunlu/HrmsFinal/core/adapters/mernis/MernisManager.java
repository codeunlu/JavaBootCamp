package com.codeunlu.HrmsFinal.core.adapters.mernis;

import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService{
    @Override
    public boolean verifyUser(int year, String name, String surname) {
        if(name.isEmpty() || surname.isEmpty()){
            return false;
        }
        return true;
    }
}
