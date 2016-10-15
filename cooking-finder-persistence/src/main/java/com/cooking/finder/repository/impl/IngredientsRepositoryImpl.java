package com.cooking.finder.repository.impl;

import com.cooking.finder.repository.interfaces.ImageRepository;
import com.cooking.finder.repository.interfaces.IngredientsRepository;
import com.cooking.finder.repository.model.Ingredients;
import com.cooking.finder.repository.projection.IngredientsMappingProjection;
import com.cooking.finder.repository.querydsl.QTImage;
import com.cooking.finder.repository.querydsl.QTIngredients;
import com.mysema.query.sql.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Igor on 16.10.2016.
 */
@Repository
public class IngredientsRepositoryImpl implements IngredientsRepository {

    private QueryDslJdbcTemplate template;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    public IngredientsRepositoryImpl(DataSource dataSource) {
        template = new QueryDslJdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public Long insert(Ingredients model) {
        QTIngredients qtIngredients = QTIngredients.tIngredients;
        final Long finalImageId = getImageId(model);
        return template.insert(qtIngredients, insert ->
        insert.columns(qtIngredients.name, qtIngredients.description, qtIngredients.imageId)
        .values(model.getName(), model.getDescription(), finalImageId).executeWithKey(Long.class));
    }

    @Override
    public List<Ingredients> findAll() {
        QTImage qtImage = QTImage.tImage;
        QTIngredients qtIngredients = QTIngredients.tIngredients;

        SQLQuery query = template.newSqlQuery().from(qtIngredients)
                .leftJoin(qtImage).on(qtIngredients.imageId.eq(qtImage.id));
        return template.query(query, new IngredientsMappingProjection());

    }

    @Override
    public Ingredients findOne(Long id) {
        QTImage qtImage = QTImage.tImage;
        QTIngredients qtIngredients = QTIngredients.tIngredients;

        SQLQuery query = template.newSqlQuery().from(qtIngredients)
                .leftJoin(qtImage).on(qtIngredients.imageId.eq(qtImage.id))
                .where(qtIngredients.id.eq(id));
        return template.queryForObject(query, new IngredientsMappingProjection());
    }

    @Override
    public boolean update(Ingredients model) {
        QTIngredients qtIngredients = QTIngredients.tIngredients;
        Long imageId = getImageId(model);
        long updated = template.update(qtIngredients, u ->
        u.where(qtIngredients.id.eq(model.getId()))
        .set(qtIngredients.description, model.getDescription())
        .set(qtIngredients.imageId, imageId).execute());

        return updated > 0;
    }

    private Long getImageId(Ingredients model) {
        boolean imageExists = model.getImage() != null && model.getImage().getId() != null
                && imageRepository.exists(model.getImage().getId());
        Long imageId = null;
        if (imageExists) {
            imageId = model.getImage().getId();
        }
        if (!imageExists && model.getImage() != null) {
            imageId = imageRepository.insert(model.getImage());
        }
        return imageId;

    }
}
