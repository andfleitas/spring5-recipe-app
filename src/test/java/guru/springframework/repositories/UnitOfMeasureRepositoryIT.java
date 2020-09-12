package guru.springframework.repositories;

import static org.junit.Assert.*;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import guru.springframework.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    //@DirtiesContext just a reminder it exists
    public void findByDescription() {
        String description = "Teaspoon";
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription(description);
        assertEquals(description, teaspoon.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {
        String description = "Cup";
        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription(description);
        assertEquals(description, cup.get().getDescription());
    }
}