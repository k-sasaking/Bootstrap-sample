package com.sample.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
    	
    	ArrayList<Article> articles = new ArrayList<Article>();
    	articles.add(new Article("Tom", "Hello World!!"));
    	articles.add(new Article("Alex", "Let's enjoy Springbooooooot!!", false));
    	articles.add(new Article("Emily", "We can do it!"));
    	articles.add(new Article("Ann",  "Awesome!!"));
    	
    	model.addAttribute("message", "This is sample page"); 	
    	model.addAttribute("articles", articles); 
    	
        return "index";
    }
    
    
    class Article {
    	
    	public String postName;
    	public Date postDate;
    	public String postText;
    	public boolean isPublished;
    	
    	Article(String name, String text) {
    		this.postName = name;
    		this.postDate = new Date();
    		this.postText = text;
    		this.isPublished = true;
    	}
    	
    	Article(String name, String text, boolean isPublished) {
    		this(name, text);
    		this.isPublished = isPublished;
    	}
    	
    }
    
}