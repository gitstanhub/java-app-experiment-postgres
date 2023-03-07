package sd.expensestracker.services;

import sd.expensestracker.data.Category;
import sd.expensestracker.db.repositories.AccountRepository;
import sd.expensestracker.db.repositories.ExpenseRepository;
import sd.expensestracker.db.repositories.implementations.PostgresAccountRepository;
import sd.expensestracker.db.repositories.implementations.PostgresExpenseRepository;
import sd.expensestracker.db.entities.AccountEntity;
import sd.expensestracker.db.entities.ExpenseEntity;

import javax.swing.*;
import java.util.Arrays;

public class ExpenseService {

    private AccountRepository accountRepository = new PostgresAccountRepository();
    private ExpenseRepository expenseRepository = new PostgresExpenseRepository();

    public void submitExpense(AccountEntity account) {
        int indexOfCategory = JOptionPane.showOptionDialog(
                null, "Category", "Please choose category of the expense", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Arrays.stream(Category.values()).map(Category::getCategoryDescription).toArray(String[]::new),
                Category.findCategory("Groceries").toString()
        );

        Category selectedCategory = Category.values()[indexOfCategory];
        int expenseAmount = Integer.parseInt(JOptionPane.showInputDialog("Please enter the expense amount"));
        String expenseDescription = JOptionPane.showInputDialog("Please enter the expense description");

        if (expenseIsValid(account, expenseAmount)) {
            ExpenseEntity expense = new ExpenseEntity()
                    .setExpenseAmount(expenseAmount)
                    .setExpenseCategory(selectedCategory)
                    .setExpenseDescription(expenseDescription)
                    .setAccountId(account.getId());

            expenseRepository.addExpense(expense);
        }
        }

    private boolean expenseIsValid(AccountEntity currentAccount, int spend) {
        if (spend <= 0) {
            return false;
        }
        else if (currentAccount.getBalance() < spend) {
            return false;
        }
        else return true;

    }

    public void showAllExpences(AccountEntity account) {

    }
}
