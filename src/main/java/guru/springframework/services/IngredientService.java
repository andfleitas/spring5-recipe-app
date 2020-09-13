package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;

/**
 * The interface Ingredient service.
 * @author andres
 */
public interface IngredientService {

    /**
     * Find by recipe id and ingredient id ingredient command.
     *
     * @param recipeId
     *         the recipe id
     * @param ingredientId
     *         the ingredient id
     * @return the ingredient command
     */
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(Long recipeId, Long idToDelete);
}
