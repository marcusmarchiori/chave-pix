package com.desafio.chavepix.repositories;

import com.desafio.chavepix.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
