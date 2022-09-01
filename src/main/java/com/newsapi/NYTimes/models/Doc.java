package com.newsapi.NYTimes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Doc {

    private List<Multimedia> multimedia;
    private Byline byline;
    private Headline headline;
    private String imageUrl;
}
