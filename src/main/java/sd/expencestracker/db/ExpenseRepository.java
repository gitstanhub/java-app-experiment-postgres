package sd.expencestracker.db;

import sd.expencestracker.entities.ExpenseEntity;

import java.util.List;

public interface ExpenseRepository {

    List<ExpenseEntity> getAll();
}
