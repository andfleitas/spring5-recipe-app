package guru.springframework.services;

import java.util.Set;
import guru.springframework.domain.Recipe;

/**
 * @author andres
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
