package com.cooking.finder.repository.impl;

import com.cooking.finder.configuration.SpringRepositoryTestConfiguration;
import com.cooking.finder.repository.interfaces.ImageRepository;
import com.cooking.finder.repository.interfaces.IngredientsRepository;
import com.cooking.finder.repository.model.Image;
import com.cooking.finder.repository.model.Ingredients;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Igor on 16.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRepositoryTestConfiguration.class)
public class IngredientsRepositoryTest {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Test
    @DirtiesContext
    public void shouldNotAddImage() {
        Image image = getImage();
        Long imageId = imageRepository.insert(image);
        image.setId(imageId);
        Ingredients ingredients = new Ingredients();
        ingredients.setImage(image);
        ingredients.setName("name");
        Long ingredientsId = ingredientsRepository.insert(ingredients);

        Assert.assertTrue(ingredientsId > 0);
    }

    @Test
    @DirtiesContext
    public void shouldAddImageWithIngredients() {
        Image image = getImage();
        Ingredients ingredients = new Ingredients();
        ingredients.setImage(image);
        ingredients.setName("name");

        Long ingredientsId = ingredientsRepository.insert(ingredients);

        Assert.assertTrue(ingredientsId > 0);

    }

    public Image getImage() {
        Image image = new Image();
        image.setHeight(200);
        image.setWidth(200);
        image.setFileName("filename");
        image.setFilePath("filepath");
        image.setImageType("imageType");
        image.setName("name");
        return image;
    }

}
