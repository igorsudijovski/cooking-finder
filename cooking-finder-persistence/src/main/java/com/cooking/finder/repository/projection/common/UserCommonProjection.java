package com.cooking.finder.repository.projection.common;

import com.cooking.finder.repository.DateUtils;
import com.cooking.finder.repository.model.Image;
import com.cooking.finder.repository.model.User;
import com.cooking.finder.repository.querydsl.QTUser;
import com.mysema.query.Tuple;

/**
 * Created by Igor on 16.10.2016.
 */
public final class UserCommonProjection {

    public static User map(Tuple tuple) {
        QTUser qtUser = QTUser.tUser;
        User user = new User();
        user.setId(tuple.get(qtUser.id));
        user.setUsername(tuple.get(qtUser.username));
        user.setEmail(tuple.get(qtUser.email));
        user.setFirstName(tuple.get(qtUser.firstname));
        user.setLastName(tuple.get(qtUser.lastname));
        user.setAccessToken(tuple.get(qtUser.accessToken));
        user.setAccessTokenCreation(DateUtils.convertTimeStampToDate(tuple.get(qtUser.accessTokenDatetime)));
        return user;
    }
}
