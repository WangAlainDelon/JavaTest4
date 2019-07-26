package com.wx.exam1.dao;

import com.wx.exam1.domain.Film;
import com.wx.exam1.domain.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FilmMapper {
    List<Film> select() throws Exception;

    void insertFilm(Film film);

    List<Film> selectByPage(Page page);

    Integer totalCount();

}
