package com.spring.blog.dto;

import com.spring.blog.entity.Reply;
import lombok.*;

import java.time.LocalDateTime;

@Getter@Setter@AllArgsConstructor
@NoArgsConstructor@ToString@Builder
public class ReplyFindByIdDTO {

    private long replyId;
    private long blogId;
    private String replyWriter;
    private String replyContent;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;

    // DTO는 Entity 객체를 이용해 생성될 수 있어야 하지만,
    // 반대의 경우는 성립하지 않는다.(Entity는 DTO 내부 구조를 알 필요가 없다)
    public ReplyFindByIdDTO(Reply reply){
        this.replyId = reply.getReplyId();
        this.replyWriter = reply.getReplyWriter();
        this.replyContent = reply.getReplyContent();
        this.publishedAt = reply.getPublishedAt();
        this.updatedAt = reply.getUpdatedAt();
    }
}
