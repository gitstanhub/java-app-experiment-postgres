package sd.expensestracker.db.implementation;

import sd.expensestracker.db.ExpenseRepository;
import sd.expensestracker.entities.AccountEntity;
import sd.expensestracker.entities.ExpenseEntity;

import java.util.List;

public class PostgresExpenseRepository implements ExpenseRepository {

    public List<ExpenseEntity> getAllByAccount(AccountEntity entity) {
        return null;
    }
}
