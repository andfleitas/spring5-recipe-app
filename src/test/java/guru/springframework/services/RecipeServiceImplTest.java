package guru.springframework.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.converters.RecipeToRecipeCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository,
                recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipesEmpty() {
        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(0, recipes.size());
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void findRecipeByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        Recipe byId = recipeService.findById(1L);
        assertNotNull(byId);
        verify(recipeRepository, times(1)).findById(anyLong());

    }
    @Test
    public void findRecipeByIdTestNotFound() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        Recipe byId = recipeService.findById(2L);
        assertNull(byId);
        verify(recipeRepository, times(1)).findById(anyLong());

    }

    @Test
    public void testDeleteById() throws Exception {

        //given
        Long idToDelete = 2L;

        //when
        recipeService.deleteById(idToDelete);

        //then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}