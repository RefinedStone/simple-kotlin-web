package com.refined.stone.account;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    boolean existsByEmail(String email);

    Account findByUuId(@NotNull String accountUUID);
}
