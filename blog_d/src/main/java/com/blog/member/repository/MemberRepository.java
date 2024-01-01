package com.blog.member.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.blog.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository // 어노테이션이 붙어있는 클래스는 스프링 빈으로 객체를 만들어 사용할 수 있도록 한다. 그러려면 의존성으로 주입을 받아야 한다.
// DB와 관련이 있음. 마이바티스에 sql 쿼리문을 정의하게 되는데, 쿼리 호출, 매개변수 넘겨주고, 리턴값 있으면 리턴해주는 역할 한다.
// @Repository어노테이션이 있는 MemberRepository 클래스의 save 메서드는 DB에 직접 값을 전달하는 역할을 한다. 곧 DB 연결을 하는 가장 직접적인 클래스 
// 자바와 DB를 이어주는 최전선이다.
@RequiredArgsConstructor // 의존성 주입
public class MemberRepository {

	private final SqlSessionTemplate sql; // 마이바티스에서 제공하는 클래스. CRUD 제공
	
	public int save(MemberDTO memberDTO) {
		System.out.println("memberDTO = " + memberDTO); // 매개변수로 전달받은 값이 제대로 오고 있는지를 확인한다.
		return sql.insert("Member.save", memberDTO);
		// 매퍼.xml 파일의 매퍼 네임스페이스.id / save는 insert 태그의 이름(변수)임. 
		// 즉, 매퍼.xml 파일에 Member이름의 매퍼에 save 태그에 memberDTO를 넘겨준다.
		// 그럼 "Member.save"가 어떻게 memberMapper.xml을 찾아 갔는가? sql.insert(a, b)에서 a는 namespace와 sql의 id를 결합한 부분을 찾아들어간다.
		// 파일들을 확인했을때 memberMapper.xml 파일에 Member 네임 스페이스가 있었고, save 아이디를 가진 sql문이 있었기에 연결된 것이다. 
	}

	public MemberDTO login(MemberDTO memberDTO) {
		return sql.selectOne("Member.login", memberDTO); // login sql id 호출 memberDTO객체 넘겨줌.
		// selectOne은 조회 결과가 하나라는 것을 의미함. 여러개면 selectList 사용. 만약 여러개가 출력되는데 selectOne쓰면 500에러 발생함.
		// 조회 결과를 확인해서 있으면 return 없으면 null값을 리턴.
	}

}
