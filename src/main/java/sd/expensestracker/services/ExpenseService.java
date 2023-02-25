package sd.expensestracker.services;

import sd.expensestracker.db.repositories.ExpenseRepository;
import sd.expensestracker.db.repositories.implementations.PostgresExpenseRepository;
import sd.expensestracker.db.entities.AccountEntity;
import sd.expensestracker.db.entities.ExpenseEntity;

public class ExpenseService {

    private ExpenseRepository expenseRepository = new PostgresExpenseRepository();

    public ExpenseEntity sendExpense(AccountEntity account) {
        return null;
    }

    public void showAllExpences(AccountEntity account) {

    }
}
