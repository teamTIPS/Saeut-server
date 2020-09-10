package saeut.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthCheckInterceptor implements HandlerInterceptor{
	// 모든 api 컨트롤러에 대해 토큰 유효셩 확인 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		// 안드에서 넘어온 access token과 refresh token이 userid의 토큰과 같으면 컨트롤러 넘겨주고
		// 아니라면 베드리케스트 응답 해주기 
		
		
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {// 컨트롤러 실행후, 아직 뷰를 실행하기 전 , 만약 api에서는 응답 보내기 전 
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception { // 뷰를 실행한 후  만약 api에서는 응답 후 
	}

}
