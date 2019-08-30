package cn.demo.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.demo.entity.User;

/**
 * 	登录拦截器
 * @author 黄震
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
			Object handler)throws IOException {
		
		HttpSession session  = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}else {
			return true;
		}
	}
}