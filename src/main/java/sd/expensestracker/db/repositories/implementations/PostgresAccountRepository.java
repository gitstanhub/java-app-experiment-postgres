package sd.expensestracker.db.repositories.implementations;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import sd.expensestracker.db.entities.AccountEntityRowMapper;
import sd.expensestracker.db.repositories.AccountRepository;
import sd.expensestracker.db.DataSourceProvider;
import sd.expensestracker.db.entities.AccountEntity;

import java.util.List;

public class PostgresAccountRepository implements AccountRepository {

    private final JdbcTemplate template = new JdbcTemplate(DataSourceProvider.getDataSource());

    AccountEntityRowMapper accountEntityRowMapper = new AccountEntityRowMapper();

    @Override
    public List<AccountEntity> getAll() {
        return template.query("SELECT * FROM account", accountEntityRowMapper);
    }

    @Nullable
    @Override
    public AccountEntity getByName(String accountName) {
        try {
            return template.queryForObject("SELECT * FROM account WHERE name = ?", accountEntityRowMapper, accountName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addAccount(AccountEntity account) {
        template.update("INSERT INTO account (name, balance) values (?, ?)", account.getName(), account.getBalance());
    }

    @Override
    public void updateAccountBalance(AccountEntity account) {
        template.update("UPDATE account SET balance = ? WHERE id = ?", account.getBalance(), account.getId());
    }
}
