package kr.co.dong.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor{

	 @Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
		 HttpSession session = request.getSession();
		 if(session.getAttribute("userid") == null) {
			 response.sendRedirect(request.getContextPath() + "/user/login");
			 return false;
		 }
		 
			return true;
		}
	 
	 @Override
	 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				@Nullable ModelAndView modelAndView) throws Exception {
		}
	 
	 @Override
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
				@Nullable Exception ex) throws Exception {
		}
}
