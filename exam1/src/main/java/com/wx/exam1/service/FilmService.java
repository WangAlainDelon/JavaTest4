package com.wx.exam1.service;

import com.wx.exam1.domain.Film;
import com.wx.exam1.domain.Page;

public interface FilmService {
    Page<Film> queryByPage(Integer pageNo, Integer pageSize) throws Exception;

    void insertFilm(Film film);

}
