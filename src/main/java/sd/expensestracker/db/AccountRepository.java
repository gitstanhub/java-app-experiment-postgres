package sd.expensestracker.db;

import sd.expensestracker.entities.AccountEntity;

import java.util.List;

public interface AccountRepository {

    List<AccountEntity> getAll();
    AccountEntity getByName();
}
