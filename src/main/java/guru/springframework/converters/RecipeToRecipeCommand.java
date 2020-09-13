package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import lombok.Synchronized;

/**
 * Utility converter class for Recipe to recipe command.
 *
 * @author andres
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    /**
     * The Ingredient converter.
     */
    final IngredientToIngredientCommand ingredientConverter;

    /**
     * The Category converter.
     */
    final CategoryToCategoryCommand categoryConverter;

    /**
     * The Notes converter.
     */
    final NotesToNotesCommand notesConverter;

    /**
     * Instantiates a new Recipe to recipe command.
     *
     * @param ingredientConverter
     *         the ingredient converter
     * @param categoryConverter
     *         the category converter
     * @param notesConverter
     *         the notes converter
     */
    public RecipeToRecipeCommand(IngredientToIngredientCommand ingredientConverter,
                                 CategoryToCategoryCommand categoryConverter, NotesToNotesCommand notesConverter) {
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
        this.notesConverter = notesConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setNotes(notesConverter.convert(recipe.getNotes()));
        recipeCommand.setImage(recipe.getImage());

        if (recipe.getCategories() != null
                && !recipe.getCategories().isEmpty()) {
            recipe.getCategories()
                    .forEach(category -> recipeCommand
                            .getCategories()
                            .add(categoryConverter.convert(category))) ;
        }
        if (recipe.getIngredients() != null
                && !recipe.getIngredients().isEmpty()) {
            recipe.getIngredients()
                    .forEach(ingredient -> recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient)));
        }
        return recipeCommand;
    }
}
