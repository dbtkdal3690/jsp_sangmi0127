<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
response.setHeader("Loation", "usr/home/main");
%>