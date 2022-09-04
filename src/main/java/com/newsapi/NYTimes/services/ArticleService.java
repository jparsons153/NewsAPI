package com.newsapi.NYTimes.services;

import com.newsapi.NYTimes.models.Article;
import com.newsapi.NYTimes.models.Doc;
import com.newsapi.NYTimes.models.NytResponse;
import com.newsapi.NYTimes.models.NytSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Value("${api_key}")
    private String apikey;

    @Value("${mostPopularUrl}")
    private String mostPopularUrl;

    @Value("${searchUrl}")
    private String searchUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Article> getMostPopular() {
        NytResponse response = restTemplate.getForObject(mostPopularUrl + "api-key=" + apikey, NytResponse.class);
        //List<Article> results = new ArrayList<>();
        if (response != null && response.getStatus().equals("OK")) {
            List<Article> articles = response.getResults();
            for (Article article : articles) {
                if (article.getMedia() != null && article.getMedia().size() > 0) {
                    article.setImageUrl(article.getMedia().get(0).getMediaMetadata().get(2).getUrl());
                }
            }
            System.out.println(response.getResults().get(1).getImageUrl());
            return articles;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Doc> getSearchResults(String searchText) {
        ResponseEntity<NytSearchResponse> searchResponse = restTemplate.getForEntity(searchUrl + searchText + "api-key" + apikey, NytSearchResponse.class);

        if (searchResponse != null && searchResponse.getStatusCode().is2xxSuccessful()) {
            List<Doc> docs = (List<Doc>) searchResponse.getBody();
            for (Doc doc : docs) {
                if (doc.getMultimedia().get(0).getSubtype().equals("largeHorizontal375")) {
                    doc.setImageUrl("https://www.nytimes.com/" + doc.getMultimedia().get(0).getUrl());
                }
            }
            return docs;
        }
        return new ArrayList<>();
    }
}