package cn.yunhe.springboot_crud.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {
    //1.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //1.获得session
        String user = (String)request.getSession().getAttribute("user");
        if(StringUtils.isEmpty(user)){
            //2.没有登录--登录页面
            request.setAttribute("msg","权限不足,请先登录!");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }
        return true;
    }

    //2
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //3
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
