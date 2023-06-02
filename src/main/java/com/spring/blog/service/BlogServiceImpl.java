package com.spring.blog.service;

import com.spring.blog.entity.Blog;
import com.spring.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // 빈 컨테이너에 적재
public class BlogServiceImpl implements BlogService{

    BlogRepository blogRepository;
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findAll(){
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(long blogId){
        return blogRepository.findById(blogId);
    }

    @Override
    public void deleteById(long blogId) {
        blogRepository.deleteById(blogId);
    }


}
