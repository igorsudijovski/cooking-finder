package com.cooking.finder.repository.impl;

import com.cooking.finder.repository.DateUtils;
import com.cooking.finder.repository.exception.IdentifierNotFound;
import com.cooking.finder.repository.interfaces.UserRepository;
import com.cooking.finder.repository.model.User;
import com.cooking.finder.repository.projection.UserMappingProjection;
import com.cooking.finder.repository.querydsl.QTUser;
import com.mysema.query.sql.SQLQuery;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Igor on 15.10.2016.
 */
@Repository
@NoArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private QueryDslJdbcTemplate template;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        template = new QueryDslJdbcTemplate(dataSource);
    }

    @Override
    public Long insert(User model) {
        QTUser qtUser = QTUser.tUser;
        return template.insert(qtUser, insert ->
            insert.columns(qtUser.username, qtUser.password, qtUser.firstname,
                    qtUser.lastname, qtUser.email, qtUser.accessToken, qtUser.accessTokenDatetime)
                    .values(model.getUsername(), model.getPassword(), model.getFirstName(),
                            model.getLastName(), model.getEmail(), model.getAccessToken(),
                            DateUtils.convertJodaDateToTimeStamp(model.getAccessTokenCreation()))
                    .executeWithKey(Long.class)
        );
    }

    @Override
    public List<User> findAll() {
        QTUser qtUser = QTUser.tUser;
        SQLQuery query = template.newSqlQuery().from(qtUser);
        return template.query(query, new UserMappingProjection());
    }

    @Override
    public User findOne(Long id) {
        QTUser qtUser = QTUser.tUser;
        SQLQuery query = template.newSqlQuery().from(qtUser);
        query = query.where(qtUser.id.eq(id));
        return template.queryForObject(query, new UserMappingProjection());
    }



    @Override
    public boolean update(User model) {
        QTUser qtUser = QTUser.tUser;
        Long updated = template.update(qtUser, update ->
        update.where(qtUser.id.eq(model.getId()))
        .set(qtUser.password, model.getPassword())
        .set(qtUser.firstname, model.getFirstName())
        .set(qtUser.lastname, model.getLastName()).execute());
        return updated > 0;
    }

    @Override
    public User findByIdentifier(User user) {
        QTUser qtUser = QTUser.tUser;
        SQLQuery query = template.newSqlQuery().from(qtUser);
        if (user.getId() != null) {
            query = query.where(qtUser.id.eq(user.getId()));
            return template.queryForObject(query, new UserMappingProjection());
        }
        if (StringUtils.isNotBlank(user.getUsername())) {
            query = query.where(qtUser.username.eq(user.getUsername()));
            return template.queryForObject(query, new UserMappingProjection());
        }
        if (StringUtils.isNotBlank(user.getEmail())) {
            query = query.where(qtUser.email.eq(user.getEmail()));
            return template.queryForObject(query, new UserMappingProjection());
        }
        if (StringUtils.isNotBlank(user.getAccessToken())) {
            query = query.where(qtUser.accessToken.eq(user.getAccessToken()));
            return template.queryForObject(query, new UserMappingProjection());
        }
        throw new IdentifierNotFound("Not provided identifier for user");

    }
}
