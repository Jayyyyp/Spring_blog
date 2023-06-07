<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
        div {
            border: 2px solid black;
        }

    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center">${blog.blogId}번의 게시물 목록</h1>

            <div class="row first-row">
                <div class="col-1"> 글번호</div>
                <div class="col-3"> 글제목</div>
                <div class="col-3"> 글쓴이</div>
                <div class="col-2"> 쓴날짜</div>
                <div class="col-2"> 수정일</div>
                <div class="col-1"> 조회수</div>
            </div>

            <div class="row">
                <div class="col-1"> ${blog.blogId}</div>
                <div class="col-3"> ${blog.blogTitle}</div>
                <div class="col-3"> ${blog.writer}</div>
                <div class="col-2"> ${blog.publishedAt}</div>
                <div class="col-2"> ${blog.updateAt}</div>
                <div class="col-1"> ${blog.blogCount}</div>
            </div>

                <div class="col-1">
                    <a href="/blog/list"><button class="btn btn-secondary">목록으로</button> </a>
                </div>
            <form action="/blog/delete" method="POST">
                <input type="hidden" name="blogId" value="${blog.blogId}">
                <input type="submit" class="btn btn-warning" value="삭제">
            </form>
            <form action="/blog/updateform" method="POST">
                <input type="hidden" name="blogId" value="${blog.blogId}">
                <input type="submit" class="btn btn-info" value="수정하기">
            </form>

</div>
</body>
</html>