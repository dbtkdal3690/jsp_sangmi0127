package com.jhs.exam.exam2.app;

import com.jhs.exam.exam2.container.Container;
import com.jhs.mysqliutil.MysqlUtil;

public class App {
	public static boolean isDevMode() {
		// �� �κ��� false�� �ٲٸ� production ��� �̴�.
		return true;
	}

	public static void init() {
		// DB ����
		MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
		MysqlUtil.setDevMode(isDevMode());

		// ���� ��ü ����
		Container.init();
	}
}