package com.wx.exam1.utils;

import com.wx.exam1.domain.Page;

import java.util.List;

/**
 * 将分页查询的结果数据封装成Page
 */
public class BeanUtil {

    public static <T> Page<T> toPagedResult(List<T> datas) {
        Page<T> result = new Page<T>();
        if (datas instanceof Page) {
            com.github.pagehelper.Page page = (com.github.pagehelper.Page) datas;
            result.setPag(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
        }
        else {
            result.setPag(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
        }

        return result;
    }

}
