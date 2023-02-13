package sd.expencestracker.entities;

public class ExpenseEntity {
    private int id;
    private int accountId;
    private int spending;
    private String spendingCategory;

    public ExpenseEntity(int id, int accountId, int spending, String spendingCategory) {
        this.id = id;
        this.accountId = accountId;
        this.spending = spending;
        this.spendingCategory = spendingCategory;
    }

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
}
