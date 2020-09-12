package guru.springframework.services;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * The Recipe service implementation class.
 * @author andres
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    /**
     * Instance of a {@link RecipeRepository}
     */
    private final RecipeRepository recipeRepository;

    /**
     * Instance of a {@link RecipeCommandToRecipe}
     */
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    /**
     * Instance of a {@link RecipeToRecipeCommand}
     */
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    /**
     * Instantiates a new Recipe service.
     *
     * @param recipeRepository
     *         the recipe repository
     * @param recipeCommandToRecipe
     *         the recipe command to recipe
     * @param recipeToRecipeCommand
     *         the recipe to recipe command
     */
    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.info("retrieving the recipes");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        log.info("searching for recipe by id: " + id);
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.info("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
