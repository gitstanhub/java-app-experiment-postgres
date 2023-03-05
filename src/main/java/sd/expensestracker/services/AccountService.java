package sd.expensestracker.services;

import sd.expensestracker.db.repositories.AccountRepository;
import sd.expensestracker.db.repositories.implementations.PostgresAccountRepository;
import sd.expensestracker.db.entities.AccountEntity;

import javax.swing.*;

public class AccountService {

    private final AccountRepository accountRepository = new PostgresAccountRepository();

    public AccountEntity login() {
        String accountName = JOptionPane.showInputDialog("Please enter your account name:");
        AccountEntity currentAccount = accountRepository.getByName(accountName);

        if (currentAccount == null) {
            int balance = Integer.parseInt(JOptionPane.showInputDialog("It looks like you don't have an account yet." + '\n' +
                    "Please enter the balance of your new account:"));

            AccountEntity account = new AccountEntity().setName(accountName).setBalance(balance);
            accountRepository.addAccount(account);
            return accountRepository.getByName(accountName);
        } else {
            return currentAccount;
        }
    }

    public void showCurrentBalance(AccountEntity account) {
        JOptionPane.showMessageDialog(null, "Your balance is: " + account.getBalance(),
                "Balance", JOptionPane.INFORMATION_MESSAGE);
    }

}
