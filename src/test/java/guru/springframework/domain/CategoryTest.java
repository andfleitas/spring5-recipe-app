package guru.springframework.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getId() {
        Long id = 2L;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() {
        String desc = "description";
        category.setDescription(desc);
        assertEquals(desc, category.getDescription());
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        recipe.setId(4L);
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        category.setRecipes(recipesData);
        assertEquals(1, category.getRecipes().size());
        assertSame(recipesData, category.getRecipes());
    }
}