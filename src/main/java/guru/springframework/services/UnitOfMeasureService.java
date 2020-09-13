package guru.springframework.services;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;

import java.util.Set;

/**
 * Created by jt on 6/28/17.
 */
public interface UnitOfMeasureService {

    /**
     * Retrieves all {@link UnitOfMeasure}
     * @return Set of {@link UnitOfMeasure}
     */
    Set<UnitOfMeasureCommand> listAllUnitOfMeasures();
}
