package com.cooking.finder.repository;

import org.joda.time.DateTime;

import java.sql.Timestamp;

/**
 * Created by Igor on 15.10.2016.
 */
public final class DateUtils {

    public static Timestamp convertJodaDateToTimeStamp(DateTime dateTime) {
        return dateTime != null ?  new Timestamp(dateTime.getMillis()) : null;
    }

    public static DateTime convertTimeStampToDate(Timestamp time) {
        return time != null ? new DateTime(time.getTime()) : null;
    }
}
