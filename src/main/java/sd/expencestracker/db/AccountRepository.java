package sd.expencestracker.db;

import sd.expencestracker.entities.AccountEntity;

import java.util.List;

public interface AccountRepository {

    List<AccountEntity> getAll();
    AccountEntity getByName();
}
