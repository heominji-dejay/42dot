package com.dot.controller.admin;

import com.dot.domain.admin.Content;
import com.dot.service.admin.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/content")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("contentList", contentService.findAll());
        model.addAttribute("content", new Content());
        return "admin/content";
    }

    @GetMapping("/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("content", contentService.findById(id));
        return "admin/contentEdit";
    }

    @PostMapping
    public String save(Content content) {
        contentService.save(content);
        return "redirect:/admin/content";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        contentService.deleteById(id);
        return "redirect:/admin/content";
    }
}

