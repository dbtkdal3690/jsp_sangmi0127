package com.jhs.exam.exam2.interceptor;

import com.jhs.exam.exam2.http.Rq;

public class NeedLoginInterceptor extends Interceptor {

	@Override
	public boolean runBeforeAction(Rq rq) {
		switch (rq.getActionPath()) {
		case "/usr/article/list":
		case "/usr/article/detail":
		case "/usr/home/main":
		case "/usr/member/login":
		case "/usr/member/doLogout":
		case "/usr/member/doLogin":
		case "/usr/member/doJoin":
		case "/usr/member/findLoginId":
		case "/usr/member/doFindLoginId":
		case "/usr/member/findLoginPw":
		case "/usr/member/doFindLoginPw":
			return true;
		}
		
		if ( rq.isNotLogined() ) {
			rq.historyBack("�α��� �� �̿����ּ���.");
			
			return false;
		}

		return true;
	}

}