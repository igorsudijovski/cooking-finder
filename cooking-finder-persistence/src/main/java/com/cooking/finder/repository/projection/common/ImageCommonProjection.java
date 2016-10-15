package com.cooking.finder.repository.projection.common;

import com.cooking.finder.repository.model.Image;
import com.cooking.finder.repository.querydsl.QTImage;
import com.mysema.query.Tuple;
import org.springframework.stereotype.Component;

/**
 * Created by Igor on 16.10.2016.
 */
public final class ImageCommonProjection {

    public static Image map(Tuple tuple) {
        QTImage qtImage = QTImage.tImage;
        Image image = new com.cooking.finder.repository.model.Image();
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
