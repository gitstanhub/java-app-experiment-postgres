package sd.expensestracker.db.entities;

public class ExpenseEntity {
    private int id;
    private int accountId;
    private int spending;
    private String spendingCategory;
    private String spendingDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
    }

    public String getSpendingCategory() {
        return spendingCategory;
    }

    public void setSpendingCategory(String spendingCategory) {
        this.spendingCategory = spendingCategory;
    }

    public String getSpendingDescription() {
        return spendingDescription;
    }

    public void setSpendingDescription(String spendingDescription) {
        this.spendingDescription = spendingDescription;
    }
}
