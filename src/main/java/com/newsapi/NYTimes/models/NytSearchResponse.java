package com.newsapi.NYTimes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NytSearchResponse {

    private String status;
    private String copyright;
    @JsonProperty("num_results")
    private int numResults;
    private Response response;
}
