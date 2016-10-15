package com.cooking.finder.repository.projection;

import com.cooking.finder.repository.model.Image;
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
        QTImage qtImage = QTImage.tImage;
        Image image = new Image();
        image.setId(tuple.get(qtImage.id));
        image.setName(tuple.get(qtImage.name));
        image.setDescription(tuple.get(qtImage.description));
        image.setFileName(tuple.get(qtImage.fileName));
        image.setFilePath(tuple.get(qtImage.filePath));
        image.setImageType(tuple.get(qtImage.imageType));
        image.setWidth(tuple.get(qtImage.width));
        image.setHeight(tuple.get(qtImage.height));
        return image;
    }
}
