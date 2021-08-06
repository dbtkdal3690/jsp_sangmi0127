package com.jhs.exam.exam2.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Rq {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private boolean isInvalid = false;
	private String controllerTypeName;
	private String controllerName;
	private String actionMethodName;

	public Rq(HttpServletRequest req, HttpServletResponse resp) {
		// ������ �ĸ����͸� UTF-8�� �ؼ�
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// ������ HTML ������ ���鶧 UTF-8 �� ����
		resp.setCharacterEncoding("UTF-8");

		// HTML�� UTF-8 �����̶�� ���� ���������� �˸���.
		resp.setContentType("text/html; charset=UTF-8");

		this.req = req;
		this.resp = resp;

		String requestUri = req.getRequestURI();
		String[] requestUriBits = requestUri.split("/");

		int minBitsCount = 5;

		if (requestUriBits.length < minBitsCount) {
			isInvalid = true;
			return;
		}

		int controllerTypeNameIndex = 2;
		int controllerNameIndex = 3;
		int actionMethodNameIndex = 4;

		this.controllerTypeName = requestUriBits[controllerTypeNameIndex];
		this.controllerName = requestUriBits[controllerNameIndex];
		this.actionMethodName = requestUriBits[actionMethodNameIndex];
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public boolean isInvalid() {
		return isInvalid;
	}

	public String getControllerTypeName() {
		return controllerTypeName;
	}

	public String getControllerName() {
		return controllerName;
	}

	public String getActionMethodName() {
		return actionMethodName;
	}

	public void print(String str) {
		try {
			resp.getWriter().append(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void println(String str) {
		print(str + "\n");
	}
}