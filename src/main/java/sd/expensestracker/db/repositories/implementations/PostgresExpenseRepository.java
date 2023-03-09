package sd.expensestracker.db.repositories.implementations;

import org.springframework.jdbc.core.JdbcTemplate;
import sd.expensestracker.db.DataSourceProvider;
import sd.expensestracker.db.entities.ExpenseEntityRowMapper;
import sd.expensestracker.db.repositories.ExpenseRepository;
import sd.expensestracker.db.entities.AccountEntity;
import sd.expensestracker.db.entities.ExpenseEntity;

import java.util.List;

public class PostgresExpenseRepository implements ExpenseRepository {

    private final JdbcTemplate template = new JdbcTemplate(DataSourceProvider.getDataSource());

    ExpenseEntityRowMapper expenseEntityRowMapper = new ExpenseEntityRowMapper();

    @Override
    public List<ExpenseEntity> getAllByAccount(AccountEntity account) {
        return template.query("SELECT * FROM expense where account_id = ?", expenseEntityRowMapper, account.getId());
    }

    @Override
    public void addExpense(ExpenseEntity expense) {
        template.update("INSERT INTO expense (account_id, expense_category, expense_amount, expense_description) values (?, ?, ?, ?)",
                expense.getAccountId(),
                expense.getExpenseCategory().toString(),
                expense.getExpenseAmount(),
                expense.getExpenseDescription()
        );
    }
}
