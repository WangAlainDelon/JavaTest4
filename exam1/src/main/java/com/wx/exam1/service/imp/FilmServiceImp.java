package com.wx.exam1.service.imp;


import com.github.pagehelper.PageHelper;
import com.wx.exam1.dao.FilmMapper;
import com.wx.exam1.domain.Film;
import com.wx.exam1.service.FilmService;
import com.wx.exam1.utils.BeanUtil;
import com.wx.exam1.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FilmServiceImp implements FilmService {
    @Resource
    private FilmMapper filmMapper;

    /***
     * 插件分页查询
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public Page<Film> queryByPage(Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        List<Film> select = filmMapper.select();
        return BeanUtil.toPagedResult(select);
    }

    @Override
    public void insertFilm(Film film) {
        filmMapper.insertFilm(film);
    }

}
