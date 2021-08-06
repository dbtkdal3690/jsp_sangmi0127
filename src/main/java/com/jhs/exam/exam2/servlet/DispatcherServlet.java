package com.jhs.exam.exam2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhs.mysqliutil.MysqlUtil;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������ �ĸ����͸� UTF-8�� �ؼ�
		req.setCharacterEncoding("UTF-8");

		// ������ HTML ������ ���鶧 UTF-8 �� ����
		resp.setCharacterEncoding("UTF-8");

		// HTML�� UTF-8 �����̶�� ���� ���������� �˸���.
		resp.setContentType("text/html; charset=UTF-8");

		String requestUri = req.getRequestURI();
		String[] requestUriBits = requestUri.split("/");

		int minBitsCount = 5;

		if (requestUriBits.length < minBitsCount) {
			resp.getWriter().append("�ùٸ� ��û�� �ƴմϴ�.");
			return;
		}		

		int controllerTypeNameIndex = 2;
		int controllerNameIndex = 3;
		int actionMethodNameIndex = 4;

		String controllerTypeName = requestUriBits[controllerTypeNameIndex];
		String controllerName = requestUriBits[controllerNameIndex];
		String actionMethodName = requestUriBits[actionMethodNameIndex];

		resp.getWriter().append("controllerTypeName : " + controllerTypeName);
		resp.getWriter().append("<br>");
		resp.getWriter().append("controllerName : " + controllerName);
		resp.getWriter().append("<br>");
		resp.getWriter().append("actionMethodName : " + actionMethodName);

		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
		MysqlUtil.setDevMode(true);

		MysqlUtil.closeConnection();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}