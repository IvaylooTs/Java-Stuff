package com.example.wallet_api.repository;

import com.example.wallet_api.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    // if needed - add custom queries
}
