package com.sample.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.entity.Article;
import com.sample.form.PostForm;
import com.sample.service.PostService;

@Controller
public class PostController {
	
	@Autowired
    private PostService postService;
	
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String post_form(
    		Model model,
    		@ModelAttribute("postForm")
    		PostForm postForm
    	) {
    	
    	model.addAttribute("message", "This is post page"); 	
    	model.addAttribute("postForm", postForm); 	
    	
        return "post_form";
        
    }
    
    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String post_create(
    		Model model,
    		@ModelAttribute("postForm")
    		@Validated
    		PostForm postForm,
    		BindingResult result
    	) {

    	if(result.hasErrors()) {
    		
        	model.addAttribute("message", "This is post page"); 	
        	model.addAttribute("postForm", postForm); 	
        	
            return "post_form";
    	}
    	
    	postService.createArticle(postForm);
    	
        return "redirect:/admin";
        
    }
    
    @RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
    public String post_edit(
    		Model model,
    		@PathVariable("id") int id,
    		@ModelAttribute("postForm")
    		PostForm postForm
    	) {
    	
    	Optional<Article> resultArticle = postService.getArticleById(id);
		if(resultArticle.isPresent()) {
    		model.addAttribute("message", "This is post page"); 	
        	model.addAttribute("postForm", new PostForm(resultArticle.get())); 	
        	
            return "post_form";
    	}
		return "error/404";
    	
    }
    
    @RequestMapping(value = "/post/delete/confirm/{id}", method = RequestMethod.GET)
    public String post_delete_confirm(
    		Model model,
    		@PathVariable("id") int id
    	) {
    	
    	Optional<Article> resultArticle = postService.getArticleById(id);
		if(resultArticle.isPresent()) {
    		model.addAttribute("message", "This is delete page"); 	
        	model.addAttribute("article", resultArticle.get()); 	
        	
            return "delete_confirm";
    	}
		return "error/404";
    	
    }
    
    @RequestMapping(value = "/post/delete/complete", method = RequestMethod.POST)
    public String post_delete_complete(
    		Model model,
    		@ModelAttribute("id")
    		Integer id
    	) {

    	postService.deleteArticle(id);
        return "redirect:/admin";
    	
    }

}