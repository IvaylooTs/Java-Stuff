package com.example.wallet_api;

import org.springframework.web.bind.annotation.*;

@RestController
//This annotation is used to define a RESTful controller in Spring.
// It is a specialized version of the @Controller annotation with an
// additional feature: It automatically applies @ResponseBody to all
// the methods in the class. This means that the return values of
// these methods will be written directly to the HTTP response body
// (usually as JSON or XML),
// rather than being resolved as view templates.
@RequestMapping("/api/wallets")
//This annotation is used to define the base path for all routes in
// this controller. It specifies that
// all endpoints in this class will be prefixed with /api/wallets
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }
    //HTTP requests - POST, GET, PUT, DELETE
    // Create a new wallet
    @PostMapping
    public Wallet createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }
    // REQUESTBODY - This annotation is used to indicate that the body of the
    // HTTP request should be mapped
    //to the method parameter (Wallet wallet in this case).

    @DeleteMapping("/{id}")
    public Wallet deleteWallet(@PathVariable Long id) {
        return walletService.deleteWallet(id);
    }

    // View wallet balance
    @GetMapping("/{id}/balance")
    public Double viewBalance(@PathVariable Long id) {
        return walletService.getBalance(id);
    }
    //The @PathVariable annotation is used to tell Spring that the
    // id in the URL (e.g., /api/wallets/1/balance) should be passed
    // to the viewBalance method. This allows us to get the specific wallet
    // ID from the URL and pass it to the method for processing.
    // ----------- It's like inside information to be taken out? --------

    // Deposit money into a wallet
    @PutMapping("/{id}/deposit")
    public Wallet depositMoney(@PathVariable Long id, @RequestParam Double amount) {
        return walletService.deposit(id, amount);
    }
    //The @RequestParam annotation is used to extract the amount parameter
    // from the query string (e.g., /api/wallets/1/deposit?amount=100).
    // This allows us to use
    // the amount value in the method to perform the deposit operation.

    // Withdraw money from a wallet
    @PutMapping("/{id}/withdraw")
    public Wallet withdrawMoney(@PathVariable Long id, @RequestParam Double amount) {
        return walletService.withdraw(id, amount);
    }

    //@PathVariable is used to extract values from parts of the URL path.
    //@RequestParam is used to extract values from query parameters in the URL
    // (after the ?).
}
