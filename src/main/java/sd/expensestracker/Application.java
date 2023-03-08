package sd.expensestracker;

import sd.expensestracker.db.entities.AccountEntity;
import sd.expensestracker.services.AccountService;
import sd.expensestracker.services.ExpenseService;

public class Application {

    AccountService accountService = new AccountService();
    ExpenseService expenseService = new ExpenseService();
    public void launch() {
        AccountEntity accountEntity = accountService.login();
        accountService.showCurrentBalance(accountEntity);

        expenseService.submitExpense(accountEntity);
        accountService.showCurrentBalance(accountEntity);

        expenseService.showResultsTable(accountEntity);
    }
}
