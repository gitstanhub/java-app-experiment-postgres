package sd.expensestracker.db.repositories.implementations;

import org.springframework.jdbc.core.JdbcTemplate;
import sd.expensestracker.db.DataSourceProvider;
import sd.expensestracker.db.entities.ExpenseEntityRowMapper;
import sd.expensestracker.db.repositories.ExpenseRepository;
import sd.expensestracker.db.entities.AccountEntity;
import sd.expensestracker.db.entities.ExpenseEntity;

import java.util.List;

public class PostgresExpenseRepository implements ExpenseRepository {

    public JdbcTemplate template = new JdbcTemplate(DataSourceProvider.getDataSource());

    @Override
    public List<ExpenseEntity> getAllByAccount(AccountEntity account) {
        return template.query("SELECT * FROM expense where account_id = ?", new ExpenseEntityRowMapper(),
                account.getId());
    }

    @Override
    public void addExpense(AccountEntity account) {

    }
}
