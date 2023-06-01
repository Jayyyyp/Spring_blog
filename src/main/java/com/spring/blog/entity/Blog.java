package com.spring.blog.entity;

import lombok.*;

import java.sql.Date;

// 역직렬화(디비 -> 자바객체)가 가능하도록 blog 테이블 구조에 맞춰서 멤버변수를 선언하기
@Setter@Getter@ToString
@NoArgsConstructor@AllArgsConstructor
@Builder // 빌더 패턴 생성자를 쓸 수 있게 해줌
public class Blog {
        private int blogId; // 숫자는 어지간하면 long형을 사용
        private String writer;
        private String blogTitle;
        private String blogContent;
        private Date publishedAt;
        private Date updateAt;
        private long blogCount;

}
