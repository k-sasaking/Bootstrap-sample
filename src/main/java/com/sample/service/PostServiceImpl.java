package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Article;
import com.sample.form.PostForm;
import com.sample.repository.ArticleRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
    private ArticleRepository articleRepository;
	
	@Override
	public List<Article> getAllArticles() {
		
		return articleRepository.findAll();
	}

	@Override
	public void createArticle(PostForm form) {
		
		articleRepository.saveAndFlush(new Article(form));
	}

}
