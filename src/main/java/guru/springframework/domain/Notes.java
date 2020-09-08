package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * @author andres
 */
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

    /**
     * Getter of property 'id'.
     *
     * @return value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id
     *         value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter of property 'recipe'.
     *
     * @return value of recipe
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Setter for property 'recipe'.
     *
     * @param recipe
     *         value of recipe
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     * Getter of property 'recipeNotes'.
     *
     * @return value of recipeNotes
     */
    public String getRecipeNotes() {
        return recipeNotes;
    }

    /**
     * Setter for property 'recipeNotes'.
     *
     * @param recipeNotes
     *         value of recipeNotes
     */
    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
