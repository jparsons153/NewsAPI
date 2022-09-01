package com.newsapi.NYTimes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Response {

    private List<Doc> docs;
    private Meta meta;
}
