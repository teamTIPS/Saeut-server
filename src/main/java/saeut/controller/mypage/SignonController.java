package saeut.controller.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import saeut.domain.Account;
import saeut.service.facade.MyPageFacade;

@Controller
public class SignonController {

	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping("/shop/signon.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("id") String id, Model model) throws Exception {
		
		Account account = myPageFacade.getAccountByUserId(id);
		System.out.println("내가 출력한 계정 아이디 : " + account.getId());
		System.out.println("폰번호2rff3 : " + account.getPhone());
		
		return new ModelAndView("account/SignOnForm");
	}
	
}
