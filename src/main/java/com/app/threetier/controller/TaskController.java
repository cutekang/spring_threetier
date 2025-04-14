package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.PostVO;
import com.app.threetier.domain.ProductVO;
import com.app.threetier.mapper.TaskMapper;
import com.app.threetier.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/task/*")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("product")
    public void goToProduct(Model model) {
        model.addAttribute("productVO", new ProductVO());
    }

    @PostMapping("product")
    public RedirectView product(ProductVO productVO) {
        taskService.addProduct(productVO);
        return new RedirectView("/post/list");
    }

    @GetMapping("list")
    public void goToList(Model model) {
        List<ProductVO> products = taskService.findAllProduct();
        model.addAttribute("products", products);
    }
}
