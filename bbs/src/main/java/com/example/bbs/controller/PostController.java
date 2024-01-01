package com.example.bbs.controller;

import com.example.bbs.domain.HashTag;
import com.example.bbs.domain.Post;
import com.example.bbs.mapper.HashTagMapper;
import com.example.bbs.mapper.PostMapper;
import com.example.bbs.service.HashTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {



    @Autowired
    private HashTagService hashTagService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post()); // 게시글 폼 불러오기
        return "create";
    }
    @PostMapping("/create")
    public String createPost(@ModelAttribute("post") Post post, @RequestParam("hashtags") String hastags) {
        hashTagService.savePostWithHashtags(post, hastags);
        return "redirect:/create";
    }
}
