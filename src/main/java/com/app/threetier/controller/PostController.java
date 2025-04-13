package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.PostVO;
import com.app.threetier.mapper.PostMapper;
import com.app.threetier.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final HttpSession session;

    @GetMapping("list")
    public void gotoList(Model model){
        model.addAttribute("posts", postService.getList());
    }

    @GetMapping("write")
    public void gotoWrite(Model model){
        model.addAttribute("postVO", new PostVO());
        model.addAttribute("memberId", ((MemberVO)session.getAttribute("member")).getId());
    }

    @PostMapping("write")
    public RedirectView write(PostVO postVO){
        postService.write(postVO);
        return new RedirectView("/post/list");
    }

    @GetMapping("edit")
    public void gotoEdit(@RequestParam Long id, Model model){
        Long memberId = ((MemberVO)session.getAttribute("member")).getId();
        PostVO postVO = postService.getPostById(id).orElseThrow(() -> new RuntimeException("PostVO Not Found"));
        model.addAttribute("postVO", postVO);
        model.addAttribute("memberId", memberId);
    }

    @PostMapping("edit")
    public RedirectView edit(PostVO postVO){
        postService.edit(postVO);
        return new RedirectView("/post/list");
    }

    @GetMapping("read")
    public void gotoRead(@RequestParam("id") Long id, Model model){

        model.addAttribute("post", postService.getPostById(id).orElseThrow(() -> {
            throw new RuntimeException("Post Not Found");
        }));
    }

    @GetMapping("delete")
    public RedirectView delete(@RequestParam("id") Long id){
        postService.delete(id);
        return new RedirectView("/post/list");
    }
}
