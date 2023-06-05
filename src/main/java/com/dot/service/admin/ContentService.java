package com.dot.service.admin;

import com.dot.domain.admin.Content;

import java.util.List;

public interface ContentService {
    List<Content> findAll();
    Content findById(Long id);
    void save(Content content);
    void deleteById(Long id);
}
