package kr.or.team4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.team4.dto.MemberDto;
import kr.or.team4.utils.ConnectionHelper;

/*
	DB연결 POOL 방식으로
	insert into mvcregister(id,pwd,email) values (?, ?, ?)
*/
public class MemberDao {
	
	public int writeOK(MemberDto md) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into mvcregister(id,pwd,email) values (?, ?, ?)";
		int row = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			
//			pstmt.setInt(1, reg.getId());
//			pstmt.setString(2, reg.getPwd());
//			pstmt.setString(3, reg.getEmail());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		
		return row;
	}
	
	// ================================================================
	public List<MemberDto> getAllMemberDtoList() {
		List<MemberDto> MemberDtolist = new ArrayList<MemberDto>();
		ResultSet rs = null;
		String sql = "select id, pwd, name, age, gender, email, ip from koreaMember";	
		PreparedStatement pstmt = null;
		////////////////////////////////////
		Connection conn = null;
		//////////////////////////////////
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			// CRUD

			rs = pstmt.executeQuery();// 명령 실행....

			// rs를 통해서 DB서버 MemberDtory에 생성된 정보를 조회
			// 처리(화면조회)
			// 만약에 중간에 DB연결 close() ..연결기반 ...
			while (rs.next()) {
				MemberDtolist.add(new MemberDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return MemberDtolist;
	}
//	select where id
	public MemberDto getMemberDtoListById(String id) {
		MemberDto MemberDto = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select id, pwd, name, age, gender, email, ip from koreaMember where id = ?";
		////////////////////////////////////
		Connection conn = null;
		//////////////////////////////////
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				MemberDto = new MemberDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
			} else {
				System.out.println("검색 결과가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return MemberDto;
	}
	
//	insert
	public int insertMemberDto(MemberDto MemberDto) {		
		PreparedStatement pstmt = null;
		String sql = "insert into koreaMember(id, pwd, name, age, gender, email, ip) values (?, ?, ?, ?, ?, ?, ?)";
		int row = 0;////////////////////////////////////
		Connection conn = null;
		//////////////////////////////////
		System.out.println(MemberDto);
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, MemberDto.getId());
			pstmt.setString(2, MemberDto.getPwd());
			pstmt.setString(3, MemberDto.getName());
			pstmt.setInt(4, MemberDto.getAge());
			pstmt.setString(5, MemberDto.getGender());
			pstmt.setString(6, MemberDto.getEmail());
			pstmt.setString(7, MemberDto.getIp());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return row;
	}
//	delete
	public int deleteMemberDto(String id) {		
		PreparedStatement pstmt = null;
		String sql = "delete from koreaMember where id=?";
		int row = 0;////////////////////////////////////
		Connection conn = null;
		//////////////////////////////////
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return row;
	}
//	update
	public int updateMemberDto(MemberDto MemberDto) {		
		PreparedStatement pstmt = null;
		String sql = "update koreaMember set age=?, name=?, gender=? ,email = ? where id=?";
		int row = 0;////////////////////////////////////
		Connection conn = null;
		//////////////////////////////////
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, MemberDto.getAge());
			pstmt.setString(2, MemberDto.getName());
			pstmt.setString(3, MemberDto.getGender());
			pstmt.setString(4, MemberDto.getEmail());
			pstmt.setString(5, MemberDto.getId());
			
			row = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return row;
	}
//	select where like
	public List<MemberDto> getMemberDtoByLikeEmail(String like){		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from koreaMember where email like ?";
		List<MemberDto> MemberDtolist = new ArrayList<MemberDto>();////////////////////////////////////
		Connection conn = null;
		//////////////////////////////////
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + like + "%");
			
			// CRUD

			rs = pstmt.executeQuery();// 명령 실행....

			// rs를 통해서 DB서버 MemberDtory에 생성된 정보를 조회
			// 처리(화면조회)
			// 만약에 중간에 DB연결 close() ..연결기반 ...
			while (rs.next()) {
				MemberDtolist.add(new MemberDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return MemberDtolist;
	}
	//ID 유무 함수
		public String isCheckById(String id) {
		
			String isMemberDtoid=null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql="select id from MemberDto where id=?";
			////////////////////////////////////
			Connection conn = null;
			//////////////////////////////////
			try {
			conn = ConnectionHelper.getConnection("oracle");
				  pstmt = conn.prepareStatement(sql);
				  pstmt.setString(1, id);
				  		
				  rs = pstmt.executeQuery();
				  if(rs.next()) {
					  //같은 ID 존재
					  isMemberDtoid = "false";
				  }else {
					  //사용가능한 ID
					  isMemberDtoid = "true";
				  }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				ConnectionHelper.close(rs);
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(conn);
			}
			
			return isMemberDtoid;
		}
	
}
