package com.cooking.finder.repository.projection;

import com.cooking.finder.repository.DateUtils;
import com.cooking.finder.repository.model.User;
import com.cooking.finder.repository.projection.common.UserCommonProjection;
import com.cooking.finder.repository.querydsl.QTUser;
import com.mysema.query.Tuple;
import com.mysema.query.types.MappingProjection;

/**
 * Created by Igor on 15.10.2016.
 */
public class UserMappingProjection extends MappingProjection<User> {

    public UserMappingProjection() {
        super(User.class, QTUser.tUser.id, QTUser.tUser.username, QTUser.tUser.password, QTUser.tUser.firstname,
                QTUser.tUser.lastname, QTUser.tUser.email, QTUser.tUser.accessToken, QTUser.tUser.accessTokenDatetime);
    }

    @Override
    protected User map(Tuple tuple) {
        return UserCommonProjection.map(tuple);
    }
}
