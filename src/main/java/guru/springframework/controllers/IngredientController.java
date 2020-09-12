package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.domain.Ingredient;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

/**
 * Spring Controller that handles the {@link Ingredient} object information
 *
 * @author andres
 */
@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;

    /**
     * Instantiates a new Ingredient controller.
     *
     * @param recipeService
     *         the recipe service
     */
    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * List ingredients.
     *
     * @param recipeId
     *         the recipe id
     * @param model
     *         the model
     * @return the string
     */
    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model){
        log.debug("Getting ingredient list for recipe id: " + recipeId);

        // use command object to avoid lazy load errors in Thymeleaf.
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }
}
