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
        expense.setSpending(rs.getInt("spending"));
        expense.setSpendingCategory(rs.getString("spending_category"));
        expense.setSpendingDescription(rs.getString("spending_description"));

        return expense;
    }
}
