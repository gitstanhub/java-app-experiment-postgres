package sd.expensestracker.db.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import sd.expensestracker.db.DataSourceProvider;
import sd.expensestracker.db.ExpenseEntityRowMapper;
import sd.expensestracker.db.ExpenseRepository;
import sd.expensestracker.entities.AccountEntity;
import sd.expensestracker.entities.ExpenseEntity;

import java.util.List;

public class PostgresExpenseRepository implements ExpenseRepository {

    public JdbcTemplate template = new JdbcTemplate(DataSourceProvider.getDataSource());

    @Override
    public List<ExpenseEntity> getAllByAccount(AccountEntity account) {
        return template.query("SELECT * FROM expense", new ExpenseEntityRowMapper());
    }

    @Override
    public void addExpense(AccountEntity account) {

    }
}
