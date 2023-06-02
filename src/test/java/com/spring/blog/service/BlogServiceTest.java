package com.spring.blog.service;

import com.spring.blog.entity.Blog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class BlogServiceTest {

    @Autowired
    BlogService blogService;

    @Test
    @Transactional // 이 테스트의 결과가 디비 커밋을 하지않음
    public void findAllTest(){
        // given : 없음

        // when : 전체 데이터 가져오기
        List<Blog> blogList = blogService.findAll();
        // then : 길이가 3일 것이다.
        assertEquals(3, blogList.size());
    }

    @Test
    @Transactional
    public void findByIdTest(){
        // given : 조회할 번호인 2번 변수에 저장, 예상되는 글쓴이, 본문정보 저장
        long blogId = 2;
        String writer = "2번유저";
        String blogTitle = "2번제목";
        // when : DB에서 2번 유저 얻어오기
        Blog blog = blogService.findById(blogId);
        // then : 얻어온 유저의 번호는 blogId변수, 글쓴이는 writer변수, 제목은 blogTitle변수에 든 값일 것이다.
        assertEquals(blogId, blog.getBlogId());
        assertEquals(writer, blog.getWriter());
        assertEquals(blogTitle, blog.getBlogTitle());
    }

    @Test
    @Transactional
    // @Commit // 트랜잭션 적용된 테스트의 결과를 커밋하여 디비에 반영되도록 만든다.
    public void deleteByIdTest(){
        // given
        long blogId = 2;
        // when
        blogService.deleteById(blogId);
        // then
        assertEquals(2, blogService.findAll().size());
        assertNull(blogService.findById(blogId));
    }

}
