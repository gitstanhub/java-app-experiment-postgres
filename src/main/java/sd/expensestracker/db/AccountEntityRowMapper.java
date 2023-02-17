package sd.expensestracker.db;

import org.springframework.jdbc.core.RowMapper;
import sd.expensestracker.entities.AccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountEntityRowMapper implements RowMapper<AccountEntity> {

    @Override
    public AccountEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AccountEntity()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setBalance(rs.getInt("balance"));
    }
}
