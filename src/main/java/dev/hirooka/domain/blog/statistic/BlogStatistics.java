package dev.hirooka.domain.blog.statistic;

import java.util.List;
import java.util.Objects;

public class BlogStatistics {

    public BlogStatistics() {
    }

    public BlogStatistics(CategoriesStatistics categoriesStatistics) {
        this.categoriesStatistics = categoriesStatistics;
    }

    private CategoriesStatistics categoriesStatistics;

    public CategoriesStatistics getCategoriesStatistics() {
        List<CategoryStatistics> categoryStatistics = List.copyOf(categoriesStatistics.getList());
        return new CategoriesStatistics(categoryStatistics);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogStatistics that = (BlogStatistics) o;
        return Objects.equals(categoriesStatistics, that.categoriesStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoriesStatistics);
    }
}
