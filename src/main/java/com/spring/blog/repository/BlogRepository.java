package com.spring.blog.repository;

import com.spring.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogRepository {
    //전체 데이터 조회 기능
    // Blog 엔터티 하나가 포스팅 row 하나를 받을 수 있고 n개의 복수의 Blog 엔터티를 받아와야 하므로, List로 감싸줌
    List<Blog> findAll();
}
