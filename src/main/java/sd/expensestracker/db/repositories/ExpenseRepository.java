package sd.expensestracker.db.repositories;

import sd.expensestracker.db.entities.AccountEntity;
import sd.expensestracker.db.entities.ExpenseEntity;

import java.util.List;

public interface ExpenseRepository {

    List<ExpenseEntity> getAllByAccount(AccountEntity account);

    void addExpense (AccountEntity account);
}
