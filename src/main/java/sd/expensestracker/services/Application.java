package sd.expensestracker.services;

import sd.expensestracker.entities.AccountEntity;

public class Application {

    AccountService accountService = new AccountService();

    public void launch() {
        AccountEntity accountEntity = accountService.login();
        accountService.showCurrentBalance(accountEntity);
    }
}
