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

    private boolean expenseIsValid(AccountEntity currentAccount, int expense) {
        if (expense <= 0) {
            return false;
        } else if (currentAccount.getBalance() < expense) {
            return false;
        } else {
            return true;
        }
    }

    public void submitExpense(AccountEntity account) {
        int indexOfCategory = JOptionPane.showOptionDialog(
                null, "Please choose category of the expense","Category", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Arrays.stream(Category.values()).map(Category::getCategoryDescription).toArray(String[]::new),
//                Category.findCategory("Groceries").toString()
                Category.GROCERIES
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
            account.setBalance(account.getBalance() - expenseAmount);
            accountRepository.updateAccountBalance(account);
        } else {
            JOptionPane.showMessageDialog(null, "Not enough funds on the balance or the expense value is invalid",
                    "Can't submit the expense", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showResultsTable(AccountEntity account) {
        Object[][] resultsTableRows = expenseRepository.getAllByAccount(account)
                .stream()
                .map(expense -> new Object[]{expense.getExpenseAmount(), Category.findCategory(expense.getExpenseDescription()), expense.getExpenseDescription()})
                .toArray(Object[][]::new);

        Object[] resultsTableColumns = {"Expense Amount", "Expense Category", "Expense Description"};

        JTable resultsTable = new JTable(resultsTableRows, resultsTableColumns);
        JOptionPane.showMessageDialog(null, new JScrollPane(resultsTable));
    }
}
