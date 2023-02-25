package sd.expensestracker;

import sd.expensestracker.db.entities.AccountEntity;
import sd.expensestracker.services.AccountService;

public class Application {

    AccountService accountService = new AccountService();

    public void launch() {
        AccountEntity accountEntity = accountService.login();
        accountService.showCurrentBalance(accountEntity);
    }
}
