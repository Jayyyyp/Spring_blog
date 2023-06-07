package com.spring.blog.controller;

import com.spring.blog.entity.Blog;
import com.spring.blog.exception.NotFoundBlogIdException;
import com.spring.blog.service.BlogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller // 컨트롤러 어노테이션은
            // 1. 빈 등록 기능 2. url 매핑 처리 기능을 함께 가지고 있으므로 다른 어노테이션과 교환해서 쓸 수 없다.
@RequestMapping("/blog")
@Log4j2 // sout이 아닌 로깅을 통한 디버깅을 위해 선언
public class BlogController {
    // 컨트롤러 레이어는 서비스 레이어를 직접 호출한다.\
     private BlogService blogService;
     @Autowired // 생성자 주입
     public BlogController(BlogService blogService){
         this.blogService = blogService;
     }

     // /blog/list 주소로 get방식 접속했을때,
    // 1. 서비스 객체를 이용하여 게시글 전체 얻기
    // 2. 얻어온 게시글을 .jsp로 보낼 수 있게 적재하기
    // 3. .jsp에서 볼 수 있도록 출력하기
    // 해당 파일의 이름은 board/list.jsp
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        List<Blog> blogList = blogService.findAll();

        model.addAttribute("blogList", blogList);

        return "blog/list";
    }

    // 디테일 페이지의 주소 패턴
    // /blog/detail/글번호
    // 위 방식으로 글번호를 입력받아, service를 이용해 해당 글 번호 요소만 얻어
    // 뷰에 적재하는 코드
    @RequestMapping(value = "/detail/{blogId}", method = RequestMethod.GET)
    public String detail(@PathVariable long blogId, Model model){
        Blog blog = blogService.findById(blogId);
          if(blog == null){
              try {
                  throw new NotFoundBlogIdException("없는 ID로 조회하셨습니다. 조회번호 : " + blogId);
              } catch (NotFoundBlogIdException e) {
//                  e.printStackTrace();
                  return "blog/NotFoundBlogIdExceptionPage";
              }
          }
//         Blog blog = blogService.findById(blogId);
//         model.addAttribute("blog", blog);
           model.addAttribute("blog", blog);

         return "blog/detail";
    }

    // 폼페이지와 실제 등록 url은 같은 url을 쓴다
    // 폼페이지는 GET방식으로 접속했을때 연결해주고
    // 폼에서 작성완료한 내용을 POST 방식으로 제출해 저장하도록 만들기
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(){
         return"blog/blog-form";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(Blog blog){
        // 서비스객체를 이용하여 저장하고,
        blogService.save(blog);
        // 리다이렉트로 list로 돌아오기
         return"redirect:/blog/list";
    }

    // DELETE로직은 삭제후 /blog/list로 리다이렉트 되어 자료가 삭제된 것을 확인하기
    // 글 번호만으로 삭제 진행하기
    // 디테일 페이지에 삭제버튼을 추가하고, 해당 버튼을 클릭했을때, 삭제 번호가 전달되어
    // 전달받은 번호를 토대로 삭제하도록 로직 구성하기
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(long blogId){
         blogService.deleteById(blogId);

         return "redirect:/blog/list";
    }

    // update 구문은 다른 내역은 insert와 비슷하지만
    // 한 가지 차이점은 폼이 이미 기존에 작성된 정보로 채워져 있다.
    // 이를 구현하기 위해 수정 버튼이 눌렸을때, 제일 먼저 해당 글 정보를 획득한 다음,
    // 폼페이지에 model.addAttribute()로 보내줘야 한다.
    // 이를 위해 value = 를 이용하면 미리 원하는 내용으로 폼을 채워둘 수 있다.
    @RequestMapping(value = "/updateform", method = RequestMethod.POST)
    public String update(long blogId, Model model){
        // blogId를 이용해서 blog 객체 받아오기
        Blog blog = blogService.findById(blogId);
        // .jsp로 보내기 위해 적재
        model.addAttribute("blog", blog);

        return "blog/blog-update-form";
    }

    // /blog/update 주소로 POST 요청을 넣으면 글이 수정되게 하기
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Blog blog){
         // 받아온 blog 엔터티로 글 수정

        blogService.update(blog);

        // 리다이렉트는 가능하면 해당 글 번호의 디테일 페이지로 넘어가게 하고,
        // 어려우면 list로 넘어가게 하기
         return "redirect:/blog/detail/" + blog.getBlogId();
    }
}
