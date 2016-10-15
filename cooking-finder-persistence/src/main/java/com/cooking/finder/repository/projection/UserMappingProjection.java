package com.cooking.finder.repository.projection;

import com.cooking.finder.repository.model.User;
import com.cooking.finder.repository.querydsl.QTUser;
import com.mysema.query.Tuple;
import com.mysema.query.types.MappingProjection;

/**
 * Created by Igor on 15.10.2016.
 */
public class UserMappingProjection extends MappingProjection<User> {

    public UserMappingProjection() {
        super(User.class, QTUser.tUser.username, QTUser.tUser.password, QTUser.tUser.firstname,
                QTUser.tUser.lastname, QTUser.tUser.email, QTUser.tUser.accessToken, QTUser.tUser.accessTokenDatetime);
    }

    @Override
    protected User map(Tuple tuple) {
        QTUser qtUser = QTUser.tUser;
        User user = new User();
        user.setId(tuple.get(qtUser.id));
        user.setUsername(tuple.get(qtUser.username));
        return user;
    }
}
