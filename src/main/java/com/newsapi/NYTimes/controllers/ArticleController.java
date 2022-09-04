package com.newsapi.NYTimes.controllers;

import com.newsapi.NYTimes.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("articleList", articleService.getMostPopular());
        return "index";
    }

    // display search bar + popular articles
    @GetMapping("/search")
    public String searchDisplay(Model searchModel){
        searchModel.addAttribute("articleList",articleService.getMostPopular());
        return "search";
    }

    // take request param from search bar, create query and return List<doc> back to the view
    @PostMapping("/search/")
    public String returnSearchResults(@RequestParam("searchString")String searchString, Model searchModel){
        searchModel.addAttribute("docs",articleService.getSearchResults(searchString));
        return "search-results";
    }
}