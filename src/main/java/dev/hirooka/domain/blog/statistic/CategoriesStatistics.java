package dev.hirooka.domain.blog.statistic;

import java.util.List;
import java.util.Objects;

public class CategoriesStatistics {

    List<CategoryStatistics> list;

    public CategoriesStatistics(List<CategoryStatistics> list) {
        this.list = list;
    }

    public List<CategoryStatistics> getList() {
        return list;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesStatistics that = (CategoriesStatistics) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
