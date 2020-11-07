package dev.hirooka.resource.dto;

import java.util.List;

public class BlogsStatistics {

    public BlogsStatistics(List<CategoryStatistics> categoryStatistics) {
        this.categoryStatistics = categoryStatistics;
    }

    public BlogsStatistics() {
    }

    List<CategoryStatistics> categoryStatistics;

    public List<CategoryStatistics> getCategoryStatistics() {
        return categoryStatistics;
    }

    public void setCategoryStatistics(List<CategoryStatistics> categoryStatistics) {
        this.categoryStatistics = categoryStatistics;
    }
}
