package sd.expensestracker.db.entities;

import sd.expensestracker.data.Category;

public class ExpenseEntity {
    private int id;
    private int accountId;
    private int expenseAmount;
    private Category expenseCategory;
    private String expenseDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public ExpenseEntity setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public ExpenseEntity setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
        return this;
    }

    public Category getExpenseCategory() {
        return expenseCategory;
    }

    public ExpenseEntity setExpenseCategory(Category expenseCategory) {
        this.expenseCategory = expenseCategory;
        return this;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public ExpenseEntity setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
        return this;
    }
}
