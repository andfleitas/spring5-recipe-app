package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import lombok.Synchronized;

/**
 * Utility converter class for Recipe command to recipe.
 * @author andres
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    /**
     * Instantiates a new Recipe command to recipe.
     *
     * @param categoryConverter
     *         the category converter
     * @param ingredientConverter
     *         the ingredient converter
     * @param notesConverter
     *         the notes converter
     */
    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter,
                                 IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Nullable
    @Synchronized
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if (recipeCommand == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setSource(recipeCommand.getSource());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setServings(recipeCommand.getServings());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setNotes(notesConverter.convert(recipeCommand.getNotes()));

        if (recipeCommand.getCategories() != null
                && !recipeCommand.getCategories().isEmpty()) {
            recipeCommand.getCategories()
                    .forEach(command -> recipe
                            .getCategories()
                            .add(categoryConverter.convert(command))) ;
        }
        if (recipeCommand.getIngredients() != null
                && !recipeCommand.getIngredients().isEmpty()) {
            recipeCommand.getIngredients()
                    .forEach(command -> recipe.getIngredients().add(ingredientConverter.convert(command)));
        }

        return recipe;
    }
}
