package com.example.wallet_api;

import com.example.wallet_api.repository.WalletRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }
    public Wallet createWallet(Wallet wallet) {
        // Here you could add validation logic if needed
        wallet.setBalance(0.0);
        return walletRepository.save(wallet);
    }
    public Wallet deleteWallet(Long walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        // isPresent(): A method of the Optional class.
        if (wallet.isPresent()) {
            walletRepository.delete(wallet.get());
            return wallet.get();
        } else {
            throw new IllegalArgumentException("Wallet with ID " + walletId + " not found.");
        }
    }
    public Double getBalance(Long walletId) {
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.map(Wallet::getBalance)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }

    public Wallet deposit(Long walletId, Double amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        wallet.setBalance(wallet.getBalance() + amount);
        return walletRepository.save(wallet);
    }

    public Wallet withdraw(Long walletId, Double amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        if (wallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        wallet.setBalance(wallet.getBalance() - amount);
        return walletRepository.save(wallet);
    }

}
