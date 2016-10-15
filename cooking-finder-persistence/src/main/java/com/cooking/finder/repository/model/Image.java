package com.cooking.finder.repository.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Igor on 15.10.2016.
 */
@Getter
@Setter
public class Image extends IdModel {

    private String name;
    private String description;
    private String fileName;
    private String filePath;
    private String imageType;
    private Integer width;
    private Integer height;

}
