package sd.expensestracker.services;

import sd.expensestracker.db.ExpenseRepository;
import sd.expensestracker.db.implementation.PostgresExpenseRepository;
import sd.expensestracker.entities.AccountEntity;
import sd.expensestracker.entities.ExpenseEntity;

public class ExpenseService {

    private ExpenseRepository expenseRepository = new PostgresExpenseRepository();

    public ExpenseEntity sendExpense(AccountEntity account) {
        return null;
    }

    public void showAllExpences(AccountEntity account) {

    }
}
