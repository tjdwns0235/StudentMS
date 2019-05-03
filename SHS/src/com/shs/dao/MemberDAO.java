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
	public static MemberDAO getInstance() {
		return instance;
	}
	int result = 0;
	
	public int memInsert(MemberDTO mDto) {
		//(11) mybatis�� ����ϱ� ���� sqlSessionFactory�� ����Ͽ�
		// sqlSession�� ����
		// �Ű������� true�� �־� auto commit ��� �߰�
		sqlSession = sqlSessionFactory.openSession(true);// 2�� commit ���
		
		try {
			//(12) ������ sqlSession�� ����Ͽ� mybatis insert ������ ����
				// memInsert�� ID������ ������ SQL���� ����
				// SQL�� ���ε�����(ex: #{sid})�� �� ���� mDto
//				   ���:mapper.xml ���� memInsert SQL���� mDto���� ���ε������� ä���ְ� SQL���� �����ض�
			result = sqlSession.insert("memInsert", mDto);
			// (14) DB���� ������ SQL���� ����� result ������ ���
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
//		(15) DB���� SQL�� �������� ��� result ������ ȣ���ߴ���(InsertPlayAction)���� ����
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
	public MemberDTO memInfo(int id) {
		sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDto = null;
		
		try {
			mDto = sqlSession.selectOne("memInfo", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return mDto;
	}
	public int memUpdate(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			result = sqlSession.update("memUpdate", mDto);
			if (result > 0) {
				System.out.println("��������");
			} else {
				System.out.println("��������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	public int memDelete (int id) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			result = sqlSession.delete("memDelete", id);
			if (result > 0) {
				System.out.println("��������");
			} else {
				System.out.println("��������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
		
	}
}
