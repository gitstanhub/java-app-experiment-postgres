package sd.expensestracker.services;

import sd.expensestracker.db.AccountRepository;
import sd.expensestracker.db.implementation.PostgresAccountRepository;
import sd.expensestracker.entities.AccountEntity;

import javax.swing.*;

public class AccountService {

    private AccountRepository accountRepository = new PostgresAccountRepository();

    public AccountEntity login() {
        String accountName = JOptionPane.showInputDialog("Please enter your account name:");
        AccountEntity currentAccount = accountRepository.getByName(accountName);

        if (currentAccount == null) {
            int balance = Integer.parseInt(JOptionPane.showInputDialog("Please enter your account balance:"));

            AccountEntity account = new AccountEntity().setName(accountName).setBalance(balance);
            accountRepository.addAccount(account);
            return accountRepository.getByName(accountName);
        } else {
            return currentAccount;
        }
    }

    public void showCurrentBalance(AccountEntity entity) {
        JOptionPane.showMessageDialog(null, "Your balance is:" + entity.getBalance(),
                "Balance", JOptionPane.INFORMATION_MESSAGE);
    }

}
