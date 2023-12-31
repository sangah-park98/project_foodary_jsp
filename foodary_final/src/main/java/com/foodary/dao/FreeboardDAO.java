package com.foodary.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.foodary.vo.FreeboardVO;

public class FreeboardDAO {

	private static FreeboardDAO instance = new FreeboardDAO();
	private FreeboardDAO() { }
	public static FreeboardDAO getInstance() {
		return instance;
	}
	
//	FreeboardService 클래스에서 호출되는 mapper와 메인글이 저장된 객체를 넘겨받고 freeboard.xml 파일의
//	insert sql 명령을 실행하는 메소드
	public void insert(SqlSession mapper, FreeboardVO vo) {
		// System.out.println("FreeboardDAO의 insert()");
		mapper.insert("Freeboard.insert", vo);
	}
	
//	FreeboardService 클래스에서 호출되는 mapper를 넘겨받고 메인글 전체 개수를 얻어오는 freeboard.xml 파일의
//	select sql 명령을 실행하는 메소드
	public int selectCount(SqlSession mapper) {
		// System.out.println("FreeboardDAO의 selectCount()");
		return (int) mapper.selectOne("Freeboard.selectCount");
	}
	
//	FreeboardService 클래스에서 호출되는 mapper와 1페이지 분량의 시작 인덱스, 끝 인덱스가 저장된 HashMap 객체를
//	넘겨받고 1페이지 분량의 메인글 목록을 얻어오는 freeboard.xml 파일의 select sql 명령을 실행하는 메소드
	public ArrayList<FreeboardVO> selectList(SqlSession mapper, HashMap<String, Integer> hmap) {
		// System.out.println("FreeboardDAO의 selectList()");
		return (ArrayList<FreeboardVO>) mapper.selectList("Freeboard.selectList", hmap);
	}
	
//	FreeboardService 클래스에서 호출되는 mapper와 조회수를 증가시킬 글번호를 넘겨받고 조회수를 증가시키는
//	freeboard.xml 파일의 update sql 명령을 실행하는 메소드
	public void increment(SqlSession mapper, int idx) {
		// System.out.println("FreeboardDAO의 increment()");
		mapper.update("Freeboard.increment", idx);
	}
	
//	FreeboardService 클래스에서 호출되는 mapper와 조회수를 증가시킨 글번호를 넘겨받고 조회수를 증가시킨
//	글 1건을 얻어오는 freeboard.xml 파일의 select sql 명령을 실행하는 메소드
	public FreeboardVO selectByIdx(SqlSession mapper, int idx) {
		// System.out.println("FreeboardDAO의 selectByIdx()");
		return (FreeboardVO) mapper.selectOne("Freeboard.selectByIdx", idx);
	}
	
//	FreeboardService 클래스에서 호출되는 mapper와 삭제할 메인글의 글번호를 넘겨받고 메인글 1건을 삭제하는
//	freeboard.xml 파일의 delete sql 명령을 실행하는 메소드
	public void delete(SqlSession mapper, int idx) {
		// System.out.println("FreeboardDAO의 delete()");
		mapper.delete("Freeboard.delete", idx);
	}
	
//	FreeboardService 클래스에서 호출되는 mapper와 삭제할 정보가 저장된 객체를 넘겨받고 메인글 1건을 수정하는
//	freeboard.xml 파일의 update sql 명령을 실행하는 메소드
	public void update(SqlSession mapper, FreeboardVO vo) {
		// System.out.println("FreeboardDAO의 update()");
		mapper.update("Freeboard.update", vo);
	}
	
//	FreeboardService 클래스에서 호출되는 mapper를 넘겨받고 모든 공지글 목록을 얻어오는 freeboard.xml 파일의 
//	update sql 명령을 실행하는 메소드 
	public ArrayList<FreeboardVO> selectNotice(SqlSession mapper) {
		// System.out.println("FreeboardDAO의 selectNotice()");
		return (ArrayList<FreeboardVO>) mapper.selectList("Freeboard.selectNotice");
	}
	
}
