package com.spring.blog.service;

import com.spring.blog.entity.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    @Transactional
    public void saveTest(){
        // given : Blog 객체에 필요 데이터인 writer, blogTitle, blogContent를 주입해 builder패턴으로 생성
        String writer = "4번유저";
        String blogTitle = "4번제목";
        String blogContent = "4번본문";

        Blog blog = Blog.builder()
                .writer(writer)
                .blogTitle(blogTitle)
                .blogContent(blogContent)
                .build();

        int lastBlogIndex = 3;
        // when : save를 호출해 DB에 저장
        blogService.save(blog);

        // then : 전체 요소의 개수가 4개인지 확인하고,
        // 현재 얻어온 마지막 포스팅의 writer, blogTitle, blogContent가 생성시 사용한 자료와 일치하는지 확인
        assertEquals(4, blogService.findAll().size());
        assertEquals(writer, blogService.findAll().get(lastBlogIndex).getWriter());
        assertEquals(blogTitle, blogService.findAll().get(lastBlogIndex).getBlogTitle());
        assertEquals(blogContent, blogService.findAll().get(lastBlogIndex).getBlogContent());

    }

    @Test
    @Transactional
    public void updateTest(){
        // given
        int blogId = 2;
        String blogTitle = "새로운제목";
        String blogContent = "새로운본문";

        Blog blog = Blog.builder()
                .blogId(blogId)
                .blogTitle(blogTitle)
                .blogContent(blogContent)
                .build();

        // when
        blogService.update(blog);
        // then
        assertEquals(blogId, blogService.findById(blogId).getBlogId());
        assertEquals(blogTitle, blogService.findById(blogId).getBlogTitle());
        assertEquals(blogContent, blogService.findById(blogId).getBlogContent());
    }

}
