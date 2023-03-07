package sd.expensestracker.db.entities;

import org.springframework.jdbc.core.RowMapper;
import sd.expensestracker.data.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseEntityRowMapper implements RowMapper<ExpenseEntity> {

    @Override
    public ExpenseEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        ExpenseEntity expense = new ExpenseEntity();
        expense.setId(rs.getInt("id"));
        expense.setAccountId((rs.getInt("account_id")));
        expense.setExpenseAmount(rs.getInt("expense_amount"));
        expense.setExpenseCategory(Category.valueOf(rs.getString("expense_category")));
        expense.setExpenseDescription(rs.getString("expense_description"));

        return expense;
    }
}
