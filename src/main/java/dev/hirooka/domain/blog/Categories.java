package dev.hirooka.domain.blog;

import dev.hirooka.domain.blog.statistic.CategoriesStatistics;
import dev.hirooka.domain.blog.statistic.CategoryStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Categories {

    public Categories() {
    }

    public Categories(List<Category> list) {
        this.list = list;
    }

    private List<Category> list;


    public CategoriesStatistics createStatistics() {
        Map<String, List<Category>> collect = list.stream()
                .collect(Collectors.groupingBy(Category::getValue));
        List<CategoryStatistics> staticsList = collect.keySet().stream()
                .map(k -> new CategoryStatistics(new Category(k), collect.get(k).size()))
                .collect(Collectors.toList());
        return new CategoriesStatistics(staticsList);
    }

    public Categories addAll(Categories other) {
        List<Category> copy = new ArrayList<>(List.copyOf(list));
        copy.addAll(List.copyOf(other.list));
        return new Categories(copy);
    }


    public static Categories empty() {
        return new Categories(new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
