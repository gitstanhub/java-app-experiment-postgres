package sd.expensestracker;

import org.springframework.jdbc.core.JdbcTemplate;
import sd.expensestracker.db.DataSourceProvider;
import sd.expensestracker.entities.AccountEntity;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
//        new Application().launch();
        JdbcTemplate template = new JdbcTemplate(DataSourceProvider.getDataSource());

        String accountName = JOptionPane.showInputDialog("Please enter your account name:");
        int balance = Integer.parseInt(JOptionPane.showInputDialog("Please enter your account balance:"));

        AccountEntity account = new AccountEntity()
                .setName(accountName)
                .setBalance(balance);

        template.update("INSERT INTO account (name, balance) values (?, ?)", account.getName(), account.getBalance());
    }
}