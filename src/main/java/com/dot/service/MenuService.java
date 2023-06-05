package com.dot.service;

import com.dot.domain.Menu;
import com.dot.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public Menu getMenuByUrl(String menuUrl) {
        return menuMapper.getMenuByUrl(menuUrl);
    }

    // 기타 필요한 메소드...
}

