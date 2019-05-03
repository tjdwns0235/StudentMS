package com.shs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shs.dto.MemberDTO;
import com.shs.mybatis.SqlMapConfig;

public class MemberDAO {
	//MyBatis 세팅값 호출
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	//mapper에 접급하기 위한 SqlSession
	SqlSession sqlSession;
	
	//singleton패턴을 활용한 DAO객체 사용
	//: 객체생성은 1회만 동작하고 생성된 객체를 빌려쓰는 형태
	//: + 외부에서는 객체생성이 불가능하게 잠금!
	private MemberDAO(){}
	
	// 외부에서 빌려서 사용할 객체 생성(instance)
	private static MemberDAO instance = new MemberDAO();
	//외부에서 getInstance() 를 호출하면 객체를 빌려줌
	public static MemberDAO gerInstance() {
		return instance;
	}
	int result = 0;
	
	public int memInsert(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession(true);// 2번 commit 방법
		
		try {
			result = sqlSession.insert("memInsert", mDto);
			
			if (result > 0) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
		
		// sqlSession.commit(); // 1번 commit 방법
	}
	public List<MemberDTO> memSelect() {
		sqlSession = sqlSessionFactory.openSession();
		List<MemberDTO> list = null;
		try {
			list = sqlSession.selectList("memSelect"); // 어떤 SQL문을 실행할것인지
			
			for (MemberDTO memberDTO : list) {
				System.out.println(memberDTO.getSid() + ",");
				System.out.println(memberDTO.getSname() + ",");
				System.out.println(memberDTO.getSphone() + ",");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return list;
	}
	
	//학생검색(이름)
	public List<MemberDTO> memSearch(String name) {
		List<MemberDTO> list = null;
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("memSearch", name);
			
			for (MemberDTO memberDTO : list) {
				System.out.println(memberDTO.getSid() + ",");
				System.out.println(memberDTO.getSname() + ",");
				System.out.println(memberDTO.getSphone() + ",");
				System.out.println();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
}
