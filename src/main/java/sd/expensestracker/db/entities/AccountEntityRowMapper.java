package sd.expensestracker.db.entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountEntityRowMapper implements RowMapper<AccountEntity> {

    @Override
    public AccountEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        AccountEntity account = new AccountEntity();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setBalance(rs.getInt("balance"));
        return account;
    }
}
