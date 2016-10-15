package com.cooking.finder.repository.projection;

import com.cooking.finder.repository.model.Image;
import com.cooking.finder.repository.projection.common.ImageCommonProjection;
import com.cooking.finder.repository.querydsl.QTImage;
import com.mysema.query.Tuple;
import com.mysema.query.types.MappingProjection;


/**
 * Created by Igor on 15.10.2016.
 */
public class ImageMappingProjection extends MappingProjection<Image> {

    public ImageMappingProjection() {
        super(Image.class, QTImage.tImage.id, QTImage.tImage.name, QTImage.tImage.description,
                QTImage.tImage.fileName, QTImage.tImage.filePath, QTImage.tImage.imageType, QTImage.tImage.width,
                QTImage.tImage.height);
    }

    @Override
    protected Image map(Tuple tuple) {
        return ImageCommonProjection.map(tuple);
    }
}
