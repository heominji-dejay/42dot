package com.dot.service;

import com.dot.domain.Board;
import com.dot.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<Board> getBoardListByMenuId(Integer menuId) {
        return boardMapper.getBoardListByMenuId(menuId);
    }

    // 기타 필요한 메소드...
}
