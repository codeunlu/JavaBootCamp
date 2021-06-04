package com.codeunlu.HrmsFinal.dataAccess.abstracts;

import com.codeunlu.HrmsFinal.entities.concretes.Social;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialDao extends JpaRepository<Social,Integer> {
}
