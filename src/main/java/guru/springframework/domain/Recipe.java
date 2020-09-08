package guru.springframework.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author andres
 */
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

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
     * Getter of property 'prepTime'.
     *
     * @return value of prepTime
     */
    public Integer getPrepTime() {
        return prepTime;
    }

    /**
     * Setter for property 'prepTime'.
     *
     * @param prepTime
     *         value of prepTime
     */
    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    /**
     * Getter of property 'cookTime'.
     *
     * @return value of cookTime
     */
    public Integer getCookTime() {
        return cookTime;
    }

    /**
     * Setter for property 'cookTime'.
     *
     * @param cookTime
     *         value of cookTime
     */
    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    /**
     * Getter of property 'servings'.
     *
     * @return value of servings
     */
    public Integer getServings() {
        return servings;
    }

    /**
     * Setter for property 'servings'.
     *
     * @param servings
     *         value of servings
     */
    public void setServings(Integer servings) {
        this.servings = servings;
    }

    /**
     * Getter of property 'source'.
     *
     * @return value of source
     */
    public String getSource() {
        return source;
    }

    /**
     * Setter for property 'source'.
     *
     * @param source
     *         value of source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Getter of property 'url'.
     *
     * @return value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter for property 'url'.
     *
     * @param url
     *         value of url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter of property 'image'.
     *
     * @return value of image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Setter for property 'image'.
     *
     * @param image
     *         value of image
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * Getter of property 'notes'.
     *
     * @return value of notes
     */
    public Notes getNotes() {
        return notes;
    }

    /**
     * Setter for property 'notes'.
     *
     * @param notes
     *         value of notes
     */
    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    /**
     * Getter of property 'ingredients'.
     *
     * @return value of ingredients
     */
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Setter for property 'ingredients'.
     *
     * @param ingredients
     *         value of ingredients
     */
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
