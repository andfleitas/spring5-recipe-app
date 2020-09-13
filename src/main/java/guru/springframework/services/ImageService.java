package guru.springframework.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * The interface Image service.
 * @author andres
 */
public interface ImageService {

    /**
     * Save image file.
     *
     * @param recipeId
     *         the recipe id
     * @param file
     *         the image file
     */
    void saveImageFile(Long recipeId, MultipartFile file);
}
