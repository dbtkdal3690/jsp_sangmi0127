package com.jhs.exam.exam2.http.controller;

import java.util.List;

import com.jhs.exam.exam2.container.Container;
import com.jhs.exam.exam2.dto.Article;
import com.jhs.exam.exam2.dto.ResultData;
import com.jhs.exam.exam2.http.Rq;
import com.jhs.exam.exam2.service.ArticleService;

public class UsrArticleController extends Controller {
	private ArticleService articleService = Container.articleService;

	@Override
	public void performAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "list":
			actionShowList(rq);
			break;
		case "write":
			actionShowWrite(rq);
			break;
		case "doWrite":
			actionDoWrite(rq);
			break;
		default:
			rq.println("�������� �ʴ� ������ �Դϴ�.");
			break;
		}
	}

	private void actionShowList(Rq rq) {
		List<Article> articles = articleService.getForPrintArticles();

		rq.setAttr("articles", articles);
		rq.jsp("usr/article/list");
	}

	private void actionDoWrite(Rq rq) {
		String title = rq.getParam("title", "");
		String body = rq.getParam("body", "");
		String redirectUri = rq.getParam("redirectUri", "../article/list");

		if (title.length() == 0) {
			rq.historyBack("title�� �Է����ּ���.");
			return;
		}

		if (body.length() == 0) {
			rq.historyBack("body�� �Է����ּ���.");
			return;
		}

		ResultData writeRd = articleService.write(title, body);
		int id = (int) writeRd.getBody().get("id");

		redirectUri = redirectUri.replace("[NEW_ID]", id + "");

		rq.replace(writeRd.getMsg(), redirectUri);
	}

	private void actionShowWrite(Rq rq) {
		rq.jsp("usr/article/write");
	}
}