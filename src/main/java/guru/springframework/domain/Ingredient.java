package guru.springframework.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author andres
 */
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

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
     * Getter of property 'amount'.
     *
     * @return value of amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter for property 'amount'.
     *
     * @param amount
     *         value of amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * Getter of property 'unitOfMeasure'.
     *
     * @return value of unitOfMeasure
     */
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Setter for property 'unitOfMeasure'.
     *
     * @param unitOfMeasure
     *         value of unitOfMeasure
     */
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
