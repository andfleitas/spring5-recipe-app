package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.domain.Recipe;

/**
 * @author andres
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
