package com.newsapi.NYTimes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Multimedia {
    private int rank;
    private String subtype;
    private String caption;
    private String credit;
    private String type;
    private String url;
    private int height;
    private int width;
    private String crop_name;
}
