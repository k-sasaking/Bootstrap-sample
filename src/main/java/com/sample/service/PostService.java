package com.sample.service;

import java.util.List;

import com.sample.entity.Article;
import com.sample.form.PostForm;

public interface PostService {
	
	public List<Article> getAllArticles();
	public void createArticle(PostForm form);

}
