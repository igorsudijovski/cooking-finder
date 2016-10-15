package com.cooking.finder.repository.impl;

import com.cooking.finder.repository.interfaces.ImageRepository;
import com.cooking.finder.repository.model.Image;
import com.cooking.finder.repository.projection.ImageMappingProjection;
import com.cooking.finder.repository.querydsl.QTImage;
import com.mysema.query.sql.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Igor on 15.10.2016.
 */
@Repository
public class ImageRepositoryImpl implements ImageRepository {

    private QueryDslJdbcTemplate template;

    @Autowired
    public ImageRepositoryImpl(DataSource dataSource) {
        template = new QueryDslJdbcTemplate(dataSource);
    }

    @Override
    public Long insert(Image model) {
        QTImage qtImage = QTImage.tImage;
        return template.insert(qtImage, insert ->
        insert.columns(qtImage.name, qtImage.description,
                qtImage.fileName, qtImage.filePath, qtImage.imageType,
                qtImage.width, qtImage.height)
        .values(model.getName(), model.getDescription(),
                model.getFileName(), model.getFilePath(), model.getImageType(),
                model.getWidth(), model.getHeight()).executeWithKey(Long.class));
    }

    @Override
    public List<Image> findAll() {
        QTImage qtImage = QTImage.tImage;
        SQLQuery query  = template.newSqlQuery().from(qtImage);
        return template.query(query, new ImageMappingProjection());
    }

    @Override
    public Image findOne(Long id) {
        QTImage qtImage = QTImage.tImage;
        SQLQuery query = template.newSqlQuery().from(qtImage);
        return template.queryForObject(query, new ImageMappingProjection());
    }

    @Override
    public boolean update(Image model) {
        QTImage qtImage = QTImage.tImage;
        Long updated = template.update(qtImage, update ->
        update.where(qtImage.id.eq(model.getId()))
        .set(qtImage.description, model.getDescription()).execute());

        return updated > 0;
    }

    @Override
    public boolean exists(Long id) {
        QTImage qtImage = QTImage.tImage;
        SQLQuery query = template.newSqlQuery().from(qtImage)
                .where(qtImage.id.eq(id));
        return template.exists(query);
    }
}
