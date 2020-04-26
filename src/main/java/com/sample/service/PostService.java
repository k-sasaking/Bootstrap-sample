package com.sample.service;

import java.util.List;
import java.util.Optional;

import com.sample.entity.Article;
import com.sample.form.PostForm;

public interface PostService {
	
	public List<Article> getAllArticles();
	public Optional<Article> getArticleById(int id);
	public void createArticle(PostForm form);

}
