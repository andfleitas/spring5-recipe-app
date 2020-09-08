package guru.springframework.controllers;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

/**
 * @author andres
 */
@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage() {
        Optional<Category> categoryOpt = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uomOpt = unitOfMeasureRepository.findByDescription("Teaspoon");

        categoryOpt.ifPresent(category -> System.out.println("category: " + category.getId()));
        uomOpt.ifPresent(unitOfMeasure -> System.out.println("unit of measure: " + unitOfMeasure.getId()));
        return "index";
    }
}
