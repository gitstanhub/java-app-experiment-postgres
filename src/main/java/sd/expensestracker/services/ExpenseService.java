package sd.expensestracker.services;

import sd.expensestracker.db.repositories.AccountRepository;
import sd.expensestracker.db.repositories.ExpenseRepository;
import sd.expensestracker.db.repositories.implementations.PostgresAccountRepository;
import sd.expensestracker.db.repositories.implementations.PostgresExpenseRepository;
import sd.expensestracker.db.entities.AccountEntity;
import sd.expensestracker.db.entities.ExpenseEntity;

public class ExpenseService {

    private AccountRepository accountRepository = new PostgresAccountRepository();
    private ExpenseRepository expenseRepository = new PostgresExpenseRepository();

    public void sendExpense(AccountEntity account) {

    }

    public void showAllExpences(AccountEntity account) {

    }
}
