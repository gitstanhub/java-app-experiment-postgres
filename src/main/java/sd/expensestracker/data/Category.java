package sd.expensestracker.data;

import java.util.Arrays;

public enum Category {
    GROCERIES("Groceries"), RESTAURANTS("Restaurants");

    private final String categoryDescription;

    Category(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public static Category findCategory(String categoryDescription) {
        return Arrays.stream(values())
                .filter(category -> category.getCategoryDescription().equals(categoryDescription))
                .findFirst()
                .orElseThrow();
    }
}
