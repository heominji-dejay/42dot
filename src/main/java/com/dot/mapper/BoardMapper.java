package com.dot.mapper;

import com.dot.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoardListByMenuId(Integer menuId);
    // 기타 필요한 메소드...
}