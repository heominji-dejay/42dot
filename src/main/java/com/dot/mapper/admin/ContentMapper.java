package com.dot.mapper.admin;

import com.dot.domain.admin.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {
    List<Content> findAll();
    Content findById(Long id);
    void insert(Content content);
    void update(Content content);
    void deleteById(Long id);
}
