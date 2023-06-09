##
CREATE TABLE reply(
                      reply_id int primary key auto_increment,
                      blog_id int not null,
                      reply_writer varchar(40) not null,
                      reply_content varchar(200) not null,
                      published_at datetime default now(),
                      updated_at datetime default now()
);

# 외래키설정
# blog_id에는 기존에 존재하는 글의 blog_id만 들어가야 한다.
alter table reply add constraint fk_reply
	foreign key(blog_id)
    references blog(blog_id);

# 더미데이터 입력
INSERT INTO reply VALUES(null, 2, "댓글쓴사람", "1빠댓글", now(), now()),
					(null, 2, "챱챱맨", "챱챱챱챱챱", now(), now()),
					(null, 2, "에취", "에쵸!!", now(), now()),
					(null, 2, "코딩마스터", "틱틱탁틱틱", now(), now()),
					(null, 3, "우르르", "용병단", now(), now());