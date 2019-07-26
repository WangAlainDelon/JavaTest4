package com.wx.exam1.controller;

import com.wx.exam1.annotation.MyBody;
import com.wx.exam1.domain.Film;
import com.wx.exam1.domain.Page;
import com.wx.exam1.service.FilmService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/film")
public class FilmController {
    private static final Logger logger = LoggerFactory.getLogger(FilmController.class);
    @Autowired
    private FilmService filmService;

    /**
     * 插入一条电影数据，只有电影的三个字段title,description,language_id
     * json数据格式：{"title": "dada","description": "nvjsdk","language_id":1}
     *
     * @param film
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createFilm(@Valid @RequestBody Film film) {
        try {
            filmService.insertFilm(film);
            return ResponseEntity.ok("New Film ID：" + film.getFilm_id());
        } catch (Exception e) {
            logger.info(" Instert Film Exceprtion   " + film + "  Data Exception " + e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    /***
     * 传入pageSize 和page,插件分页查询电影表
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list(@MyBody("page") Page page) throws Exception {
        System.out.println(page.getPag());
        System.out.println(page.getPageSize());
        Page<Film> pagedResult = filmService.queryByPage(page.getPag(), page.getPageSize());
        return toJson(pagedResult);
    }

    private static String toJson(Object pagedResult) {
        JSONObject jsonObj = null;
        if (pagedResult != null) {
            JsonConfig jsonConfig = new JsonConfig();
            jsonObj = JSONObject.fromObject(pagedResult, jsonConfig);
            jsonObj.element("isError", false);
            jsonObj.element("errorMsg", "");
        }
        return jsonObj.toString();
    }

}
