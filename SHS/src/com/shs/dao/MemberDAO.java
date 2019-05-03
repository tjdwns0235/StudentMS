package com.shs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shs.dto.MemberDTO;
import com.shs.mybatis.SqlMapConfig;

public class MemberDAO {
	//MyBatis ���ð� ȣ��
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	//mapper�� �����ϱ� ���� SqlSession
	SqlSession sqlSession;
	
	//singleton������ Ȱ���� DAO��ü ���
	//: ��ü������ 1ȸ�� �����ϰ� ������ ��ü�� �������� ����
	//: + �ܺο����� ��ü������ �Ұ����ϰ� ���!
	private MemberDAO(){}
	
	// �ܺο��� ������ ����� ��ü ����(instance)
	private static MemberDAO instance = new MemberDAO();
	//�ܺο��� getInstance() �� ȣ���ϸ� ��ü�� ������
	public static MemberDAO gerInstance() {
		return instance;
	}
	int result = 0;
	
	public int memInsert(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession(true);// 2�� commit ���
		
		try {
			result = sqlSession.insert("memInsert", mDto);
			
			if (result > 0) {
				System.out.println("��ϼ���");
			} else {
				System.out.println("��Ͻ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
		
		// sqlSession.commit(); // 1�� commit ���
	}
	public List<MemberDTO> memSelect() {
		sqlSession = sqlSessionFactory.openSession();
		List<MemberDTO> list = null;
		try {
			list = sqlSession.selectList("memSelect"); // � SQL���� �����Ұ�����
			
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
	
	//�л��˻�(�̸�)
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
