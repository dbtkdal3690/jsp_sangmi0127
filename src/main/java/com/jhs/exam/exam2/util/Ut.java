package com.jhs.exam.exam2.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ut {
	public static String f(String format, Object... args) {
		return String.format(format, args);
	}

	public static Map<String, Object> mapOf(Object... args) {
        if (args.length % 2 != 0) {
            throw new IllegalArgumentException("���ڸ� ¦���� �Է����ּ���.");
        }

        int size = args.length / 2;

        Map<String, Object> map = new LinkedHashMap<>();

        for (int i = 0; i < size; i++) {
            int keyIndex = i * 2;
            int valueIndex = keyIndex + 1;

            String key;
            Object value;

            try {
                key = (String) args[keyIndex];
            } catch (ClassCastException e) {
                throw new IllegalArgumentException("Ű�� String���� �Է��ؾ� �մϴ�. " + e.getMessage());
            }

            value = args[valueIndex];

            map.put(key, value);
        }

        return map;
    }

}