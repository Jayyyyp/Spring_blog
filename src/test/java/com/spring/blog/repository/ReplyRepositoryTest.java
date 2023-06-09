package com.spring.blog.repository;

import com.spring.blog.dto.ReplyFindByIdDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReplyRepositoryTest {

    @Autowired
    ReplyRepository replyRepository;

    @Test
    @Transactional
    @DisplayName("2번 글에 연동된 댓글 개수가 4개인지 확인")
    public void findByBlogIdTest(){
        // given : 2번 글을 조회하기 위한 fixture 저장
        long blogId = 2;
        // when : findAllByBlogId() 호출 및 결과 자료 저장
        List<ReplyFindByIdDTO> result = replyRepository.findByBlogId(blogId);
        // then : 2번 글에 연동된 댓글이 4개일 것이다 라고 단언
        assertEquals(4, result.size());
    }

    @Test
    @Transactional
    @DisplayName("댓글번호 3번 자료의 댓글은 3번이고, 글쓴이~")
    public void findByReplyIdTest(){
        // given :
        long replyId = 3;

        // when
        ReplyFindByIdDTO reply = replyRepository.findByReplyId(replyId);
        // then
        assertEquals(replyId, reply.getReplyId());
        assertEquals("에취", reply.getReplyWriter());
    }

}
