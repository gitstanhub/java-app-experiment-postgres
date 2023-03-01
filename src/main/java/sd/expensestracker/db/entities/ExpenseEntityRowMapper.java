package sd.expensestracker.db.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseEntityRowMapper implements RowMapper<ExpenseEntity> {

    @Override
    public ExpenseEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        ExpenseEntity expense = new ExpenseEntity();
        expense.setId(rs.getInt("id"));
        expense.setAccountId((rs.getInt("account_id")));
        expense.setSpending(rs.getInt("expense_amount"));
        expense.setSpendingCategory(rs.getString("expense_category"));
        expense.setSpendingDescription(rs.getString("expense_description"));

        return expense;
    }
}
