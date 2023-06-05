package com.dot.mapper;

import com.dot.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
    Menu getMenuByUrl(String menuUrl);
    // 기타 필요한 메소드...
}
