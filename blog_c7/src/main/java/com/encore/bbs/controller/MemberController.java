package com.encore.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.bbs.dto.MemberDTO;
import com.encore.bbs.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor // DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션. final 혹은 @NotNull이 붙은 필드의 생성자를 자동으로 만들어준다.
public class MemberController {

	private final MemberService memberService; // 왜 이렇게 쓰지? 이해 필요. 어쨌든 의존성 주입하여 MemberService에 값을 넣어주기 위해 사용한다.
	// @RequiredArgsConstructor에 의해 memberService의 생성자 함수가 만들어지고 거기에 값이 입력되면 Service 클래스로 의존성 주입한다.
	// 일단 @RequiredArgsConstructor은 final이 붙은 필드에만 생성자를 만들기 때문에 final을 붙인다
	// 의존성 주입의 3가지 방법
	// 1. 생성자 주입(Constructor Injection)
	// 2. 필드 주입(Field Injection)
	// 3. 수정자 주입(Setter Injection)
	// @RequiredArgsConstructor 어노테이션과 같이 쓴다.

	@GetMapping("/save")
	public String saveForm() {
		return "save";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute MemberDTO memberDTO) { 
		// 클래스를 객체로 받기 위해 @modelAttribute를 썼다. 하나의 값을 받으려면 @RequestParam 쓰면 됨.
		// save.html에서 받은 값이 @ModelAttribute로 memberDTO에 전부 담긴다. 마치 setter 메서드
		// 결국 DTO에 담긴 값의 최종 목적지는 DB다. 이는 컨트롤러에서 서비스 클래스로 보내야 한다.
		int saveResult = memberService.save(memberDTO);
		if(saveResult > 0) {
			return "login";
		} else {
			return "save"; // 저장이 잘 돼서 리턴으로 받은 값이 0이기 때문에 else 구문 실행 후 /save url로 이동 
		}
		// 결과값이 Bad Request, status=400라고 나왔다면 
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, // 값을 다 쓰지 않더라도 객체로 받는게 편하다.
										HttpSession session) { // HttpSession을 쓰는 이유는, 나의 로그인 계정(정보)이 계속 나를 따라다니도록 만들기 위함이다. 
		boolean loginResult = memberService.login(memberDTO);
		if(loginResult) {
			session.setAttribute("loginId", memberDTO.getMemberId());
			// 로그인이 성공한 경우, 세션에 현재 로그인한 사용자의 아이디를 저장하는 코드
			// setAttribute 메서드는 세션에 속성(attribute)을 설정하는 메서드다. 
			// 세션 객체에는 여러 속성을 저장할 수 있으며, 각 속성은 고유한 이름(키)을 가지게되는데 이때 "loginId"는 세션에 저장될 속성의 이름(키)이다. 
			return "main";
		} else {
			return "login";
		}
	}

}