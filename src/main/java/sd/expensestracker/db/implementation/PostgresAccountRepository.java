package sd.expensestracker.db.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import sd.expensestracker.db.AccountEntityRowMapper;
import sd.expensestracker.db.AccountRepository;
import sd.expensestracker.db.DataSourceProvider;
import sd.expensestracker.entities.AccountEntity;

import java.util.List;

public class PostgresAccountRepository implements AccountRepository {

    private static final JdbcTemplate template = new JdbcTemplate(DataSourceProvider.getDataSource());

    @Override
    public List<AccountEntity> getAll() {
        return template.query("SELECT * FROM account", new AccountEntityRowMapper());
    }

    @Override
    public @Nullable AccountEntity getByName(String accountName) {
        return template.queryForObject("SELECT * FROM account WHERE name = ?", new AccountEntityRowMapper(), accountName);
    }

    @Override
    public void addAccount(AccountEntity account) {
        template.update("INSERT INTO account (name, balance) values (?, ?)", account.getName(), account.getBalance());
    }
}
