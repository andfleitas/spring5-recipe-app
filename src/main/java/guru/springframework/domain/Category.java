package guru.springframework.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author andres
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();

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
     * Getter of property 'description'.
     *
     * @return value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for property 'description'.
     *
     * @param description
     *         value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter of property 'recipes'.
     *
     * @return value of recipes
     */
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Setter for property 'recipes'.
     *
     * @param recipes
     *         value of recipes
     */
    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
