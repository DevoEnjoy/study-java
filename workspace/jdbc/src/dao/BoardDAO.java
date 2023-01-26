package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BoardDTO;
import domain.BoardVO;

public class BoardDAO {
	public Connection connection; // 연결 객체
	public PreparedStatement preparedStatement; // 쿼리 관리 객체
	public ResultSet resultSet; // 결과 테이블 객체

//	게시글 추가
	public void create(Long userId) {
		int i = 0;
		String query = "INSERT INTO TBL_BOARD (BOARD_ID, BOARD_TITLE, BOARD_CONTENT, USER_ID) "
				+ "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?)";
		BoardVO boardVO = new BoardVO();
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++i, boardVO.getBoardTitle());
			preparedStatement.setString(++i, boardVO.getBoardContent());
			preparedStatement.setLong(++i, boardVO.getUserId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("create()");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				if (resultSet != null) {
//					resultSet.close();
//				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

//	게시글 조회
	public BoardDTO select() {
		int i = 0;
		String query = "SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, BOARD_UPDATE_DATE, USER_ID, "
				+ "USER_IDENTIFICATION, USER_NAME, USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID "
				+ "FROM TBL_USER U JOIN TBL_BOARD B "
				+ "ON U.USER_ID = B.USER_ID AND BOARD_ID = ?";
		BoardDTO boardDTO = null;

		try {
			boardDTO = new BoardDTO();
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(++i, boardDTO.getBoardId());
			resultSet = preparedStatement.executeQuery();

		} catch (SQLException e) {
			System.out.println("create()");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				if (resultSet != null) {
//					resultSet.close();
//				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return boardDTO;

	}

//	게시글 수정
	public void update(BoardVO boardVO) {
		int i = 0;
		String query = "UPDATE TBL_BOARD " + "SET BOARD_TITLE=?, BOARD_CONTENT=?, BOARD_UPDATE_DATE=SYSDATE "
				+ "WHERE BOARD_ID = ? AND USER_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++i, boardVO.getBoardTitle());
//			preparedStatement.setString(++i, encrypt(userVO.getUserPassword()));
			preparedStatement.setString(++i, boardVO.getBoardContent());
			preparedStatement.setLong(++i, boardVO.getBoardId());
			preparedStatement.setLong(++i, boardVO.getUserId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("L269 update() SQL문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

//	게시글 삭제
	public void delete(Long boardId) {
		String query = "DELETE FROM TBL_BOARD WHERE BOARD_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, boardId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete() SQL문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

//	게시글 전체 조회
	public ArrayList<BoardVO> selectAll() {
		int i = 0;
		ArrayList<BoardVO> boards = new ArrayList<BoardVO>();
		String query = "SELECT BOARD_ID, BOARD_TITLE, BOARD_CONTENT, BOARD_REGISTER_DATE, BOARD_UPDATE_DATE, USER_ID "
				+ "FROM TBL_BOARD";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setBoardId(resultSet.getLong(++i));
				boardVO.setBoardTitle(resultSet.getString(++i));
				boardVO.setBoardContent(resultSet.getString(++i));
				boardVO.setBoardRegisterDate(resultSet.getString(++i));
				boardVO.setBoardUpdateDate(resultSet.getString(++i));
				boardVO.setUserId(resultSet.getLong(++i));

//		            전체 정보가 담긴 Model 객체를 ArrayList 자료구조에 순서대로 담아준다.
				boards.add(boardVO);
			}

		} catch (SQLException e) {
			System.out.println("selectAll() SQL문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return boards;
	}

}
