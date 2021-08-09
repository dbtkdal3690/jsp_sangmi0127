package com.jhs.exam.exam2.http.controller;

import com.jhs.exam.exam2.http.Rq;
import com.jhs.exam.exam2.http.controller.UsrArticleController;
import com.jhs.exam.exam2.repository.ArticleRepository;
import com.jhs.exam.exam2.service.ArticleService;

public class Controller {
	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	
	public static void init() {
		articleRepository = new ArticleRepository();
		articleService = new ArticleService();
		usrArticleController = new UsrArticleController();
		
	}

	public void performAction(Rq rq) {
		// TODO Auto-generated method stub
		
	}
}