package sd.expensestracker.db.repositories;

import sd.expensestracker.db.entities.AccountEntity;

import java.util.List;

public interface AccountRepository {

    List<AccountEntity> getAll();
    AccountEntity getByName(String accountName);
    void addAccount(AccountEntity account);

    void updateAccountBalance(AccountEntity account);
}
