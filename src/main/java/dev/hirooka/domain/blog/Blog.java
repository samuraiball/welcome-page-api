package dev.hirooka.domain.blog;

import java.util.Objects;

public class Blog {

    public Blog(String title, String published, Categories cagegories) {
        this.title = title;
        this.published = published;
        this.categories = cagegories;
    }

    private String title;

    private String published;

    private Categories categories;

    public String getTitle() {
        return title;
    }

    public String getPublished() {
        return published;
    }

    public Categories getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(title, blog.title) &&
                Objects.equals(published, blog.published) &&
                Objects.equals(categories, blog.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, published, categories);
    }
}
