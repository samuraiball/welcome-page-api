package dev.hirooka.domain.blog;


import dev.hirooka.domain.blog.statistic.BlogStatistics;

import java.util.List;
import java.util.Objects;


public class Blogs {

    public Blogs(List<Blog> list) {
        this.list = list;
    }

    List<Blog> list;

    public BlogStatistics createStatistics() {
        Categories categories = list.stream().map(Blog::getCategories)
                .reduce(Categories.empty(), (a, n) -> n.addAll(a));
        return new BlogStatistics(categories.createStatistics());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blogs)) return false;
        Blogs blogs = (Blogs) o;
        return Objects.equals(list, blogs.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
