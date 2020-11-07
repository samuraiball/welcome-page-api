package dev.hirooka.domain.blog.statistic;


import dev.hirooka.domain.blog.Category;

import java.util.Objects;

public class CategoryStatistics {

    public CategoryStatistics(Category category) {
    }

    public CategoryStatistics(Category category, int number) {
        this.category = category;
        this.number = number;
    }

    private Category category;
    private int number;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryStatistics that = (CategoryStatistics) o;
        return number == that.number &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, number);
    }
}
