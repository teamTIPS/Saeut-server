package saeut.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import saeut.security.JwtComponent;
import saeut.security.JwtComponent.TOKEN_TYPE;

@Component
public class AuthCheckInterceptor implements HandlerInterceptor{
	// 모든 api 컨트롤러에 대해 토큰 유효셩 확인 
	
	@Autowired
	private JwtComponent jwtUtil;
	
   	    
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		//안드에서 request와 함께 헤더로 보내준 access token의 유효성 검증을 한다. 
		/*
		 * 1.헤더에서 at 받아온다.
		 * 2. at의 유효성 검증을 한다. 
		 * 3. 유효하면 true, 아니면 Bad Reqeust 응답을 보내준다. response 설정 
		 */
		
        String token = request.getHeader("Authorization");
		String subject = this.jwtUtil.extractUsername(token, TOKEN_TYPE.ACCESS_TOKEN);
		final UserDetails user = this.jwtUtil.getUserDetailService().loadUserByUsername(subject);
		
        if(!jwtUtil.validateToken(token, user, TOKEN_TYPE.ACCESS_TOKEN)) {  // 토큰의 유효성 검증
        	 throw new IllegalArgumentException("Can't retrieve Token");
        };
        return true;
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
