package com.cooking.finder.repository.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Igor on 16.10.2016.
 */
@Getter
@Setter
public class Feed extends IdModel {

    private String name;
    private String description;
    private Image mainImage;
    private User user;
    private List<Ingredients> ingredients;
    private List<Image> images;
    private List<FeedFeedback> feedbacks;


}
