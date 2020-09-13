package guru.springframework.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Ingredient.
 *
 * @author andres
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
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
     * Instantiates a new Ingredient.
     */
    public Ingredient() {
    }

    /**
     * Instantiates a new Ingredient.
     *
     * @param description
     *         the description
     * @param amount
     *         the amount
     * @param unitOfMeasure
     *         the unit of measure
     */
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    /**
     * Instantiates a new Ingredient.
     *
     * @param description
     *         the description
     * @param amount
     *         the amount
     * @param unitOfMeasure
     *         the unit of measure
     * @param recipe
     *         the recipe
     */
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

}
