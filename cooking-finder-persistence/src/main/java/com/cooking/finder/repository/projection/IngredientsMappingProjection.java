package com.cooking.finder.repository.projection;

import com.cooking.finder.repository.model.Ingredients;
import com.cooking.finder.repository.projection.common.ImageCommonProjection;
import com.cooking.finder.repository.querydsl.QTImage;
import com.cooking.finder.repository.querydsl.QTIngredients;
import com.mysema.query.Tuple;
import com.mysema.query.types.MappingProjection;

/**
 * Created by Igor on 16.10.2016.
 */
public class IngredientsMappingProjection extends MappingProjection<Ingredients> {

    public IngredientsMappingProjection() {
        super(Ingredients.class, QTIngredients.tIngredients.id,
                QTIngredients.tIngredients.name, QTIngredients.tIngredients.description,
                QTIngredients.tIngredients.imageId,
                QTImage.tImage.id,
                QTImage.tImage.name, QTImage.tImage.description,
                QTImage.tImage.fileName, QTImage.tImage.filePath, QTImage.tImage.imageType, QTImage.tImage.width,
                QTImage.tImage.height);
    }

    @Override
    protected Ingredients map(Tuple tuple) {
        QTIngredients qtIngredients = QTIngredients.tIngredients;
        Ingredients ingredients = new Ingredients();
        ingredients.setId(tuple.get(qtIngredients.id));
        ingredients.setName(tuple.get(qtIngredients.name));
        ingredients.setDescription(tuple.get(qtIngredients.description));
        Long imageId = tuple.get(qtIngredients.imageId);
        if (imageId != null) {
            ingredients.setImage(ImageCommonProjection.map(tuple));
        }
        return ingredients;
    }
}
