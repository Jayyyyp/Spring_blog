package com.spring.blog.service;

import com.spring.blog.entity.Blog;

import java.util.List;

public interface BlogService {
    // 비즈니스 로직을 담당할 메서드를 "정의"만 하면 됨
    // 전체 블로그 포스팅을 조회하는 메서드 findAll()을 선언하기

    List<Blog> findAll();

    // 단일 포스팅을 조회하는 메서드 findById를 선언하기
    Blog findById(long blogId);

    // 단일 포스팅을 삭제하는 메서드 deleteById를 선언하기
   void deleteById(long blogId);

}
