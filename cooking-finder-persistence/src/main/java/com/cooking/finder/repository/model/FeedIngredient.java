package com.cooking.finder.repository.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Igor on 16.10.2016.
 */
@Getter
@Setter
public class FeedIngredient extends IdModel {

    private Ingredients ingredients;
    private String measurement;

}
