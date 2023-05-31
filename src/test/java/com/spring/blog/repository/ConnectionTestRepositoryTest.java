package com.spring.blog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConnectionTestRepositoryTest {
    @Autowired // 테스트코드는 필드 주입을 해도 괜찮은 경우가 많음
    ConnectionTestRepository connectionTestRepository;

    @Test
    public void getNowTest(){
        System.out.println("얻어온 현재 시간 : " + connectionTestRepository.getNow());
    }
}
