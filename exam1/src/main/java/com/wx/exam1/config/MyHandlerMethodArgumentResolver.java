package com.wx.exam1.config;

import com.wx.exam1.annotation.MyBody;
import com.wx.exam1.domain.Page;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        /**是否是支持类型，是的话返回true*/
        return methodParameter.hasParameterAnnotation(MyBody.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        Page pageObj = new Page();
        try {
            pageObj.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
            pageObj.setPag(Integer.parseInt(request.getParameter("page")));
            return pageObj;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
