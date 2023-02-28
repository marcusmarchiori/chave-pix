package com.desafio.chavepix.repository;

import com.desafio.chavepix.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
