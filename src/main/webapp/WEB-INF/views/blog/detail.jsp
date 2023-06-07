<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container text-center">
    <h1 class="text-center">${blog.blogId}번의 게시물 목록</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <div class="row first-row">
                <div class="col-1"> 글번호</div>
                <div class="col-3"> 글제목</div>
                <div class="col-3"> 글쓴이</div>
                <div class="col-2"> 쓴날짜</div>
                <div class="col-2"> 수정일</div>
                <div class="col-1"> 조회수</div>
            </div>
        </tr>
        </thead>
        <tbody>
        <tr>
            <div class="row">
                <div class="col-1"> ${blog.blogId}</div>
                <div class="col-3"> ${blog.blogContent}</div>
                <div class="col-3"> ${blog.writer}</div>
                <div class="col-2"> ${blog.publishedAt}</div>
                <div class="col-2"> ${blog.updateAt}</div>
                <div class="col-1"> ${blog.blogCount}</div>
            </div>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>