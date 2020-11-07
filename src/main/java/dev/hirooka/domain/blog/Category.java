package dev.hirooka.domain.blog;

import java.util.Objects;

public class Category {

    public Category(String value) {
        this.value = value;
    }


    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(value, category.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
