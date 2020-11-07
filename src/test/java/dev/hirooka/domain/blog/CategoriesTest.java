package dev.hirooka.domain.blog;

import dev.hirooka.domain.blog.statistic.CategoriesStatistics;
import dev.hirooka.domain.blog.statistic.CategoryStatistics;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CategoriesTest {


    @Test
    void createStatics() {
        Category java1 = new Category("Java");
        Category java2 = new Category("Java");
        Category spring = new Category("Spring");

        Categories categories = new Categories(List.of(java1, java2, spring));

        CategoriesStatistics expected = new CategoriesStatistics(
                List.of(
                        new CategoryStatistics(java1, 2),
                        new CategoryStatistics(spring, 1)));

        assertThat(categories.createStatistics()).isEqualToComparingFieldByField(expected);
    }
}