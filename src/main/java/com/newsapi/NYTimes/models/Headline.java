package com.newsapi.NYTimes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Headline {
    private String main;
    private String kicker;
    private String content_kicker;
    private String print_headline;
    private String name;
    private String seo;
    private String sub;
}
