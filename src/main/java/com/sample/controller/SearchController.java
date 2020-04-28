package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.entity.Article;
import com.sample.service.PostService;


@Controller
public class SearchController {
	
	@Autowired
    private PostService postService;
	
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(
    		Model model,
    		@RequestParam(name = "word", required = false)
    		String searchWord) {
    	
    	if("".equals(searchWord))
    		return "forward:/";
    	List<Article> articles = postService.searchArticles(searchWord);
    	
    	model.addAttribute("message", "This is sample page"); 	
    	model.addAttribute("articles", articles); 
    	model.addAttribute("word", searchWord); 
    	
        return "index";
    }
        
}
