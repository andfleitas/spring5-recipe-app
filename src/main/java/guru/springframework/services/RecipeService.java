package guru.springframework.services;

import java.util.Set;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;

/**
 * @author andres
 */
public interface RecipeService {

    /**
     * Returns all the recipes in the system
     * @return  Set of {@link Recipe}
     */
    Set<Recipe> getRecipes();

    /**
     * Retrieves a {@link Recipe} by a given id value
     * @param id {@link Long} value of the id of the {@link Recipe}
     * @return  the {@link Recipe}
     */
    Recipe findById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
