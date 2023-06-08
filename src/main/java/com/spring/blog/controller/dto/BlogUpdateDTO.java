package com.spring.blog.controller.dto;


import com.spring.blog.entity.Blog;
import lombok.*;

@Getter@Setter@Builder@ToString
@AllArgsConstructor@NoArgsConstructor
public class BlogUpdateDTO {
    // UPDATE시, 필요한 데이터는
    // 글쓴이, 글제목, 글본문, 글번호
    private long blogId;
    private String writer;
    private String blogTitle;
    private String blogContent;

    // 엔터티 데이터를 DTO로 변환해주기 위한 생성자
    // DTO가 엔터티의 하위개념이므로, DTO는 엔터티의 내부구조를 알아야 작동할 수 있지만,
    // 엔터티는 DTO를 구조와 상관없이 작동해야 하므로, 엔터티를 DTO로 바꾸는건 가능해야 하지만
    // 그 반대는 성립하지 않음
    public BlogUpdateDTO(Blog blog){
        this.blogId = blog.getBlogId();
        this.writer = blog.getWriter();
        this.blogTitle = blog.getBlogTitle();
        this.blogContent = blog.getBlogContent();
    }
}
