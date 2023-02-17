package sd.expensestracker.db;

import sd.expensestracker.entities.ExpenseEntity;

import java.util.List;

public interface ExpenseRepository {

    List<ExpenseEntity> getAll();
}
