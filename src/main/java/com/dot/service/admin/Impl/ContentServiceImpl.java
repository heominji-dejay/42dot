package com.dot.service.admin.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dot.domain.admin.Content;
import com.dot.mapper.admin.ContentMapper;
import com.dot.service.admin.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentMapper contentMapper;

    @Autowired
    public ContentServiceImpl(ContentMapper contentMapper) {
        this.contentMapper = contentMapper;
    }

    @Override
    public List<Content> findAll() {
        return contentMapper.findAll();
    }

    @Override
    public Content findById(Long id) {
        return contentMapper.findById(id);
    }

    @Override
    @Transactional
    public void save(Content content) {
        if (content == null) {
            contentMapper.insert(content);
        } else {
            contentMapper.update(content);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        contentMapper.deleteById(id);
    }
}
