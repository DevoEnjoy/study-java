package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BoardDTO;
import domain.BoardVO;

public class BoardDAO {
	public Connection connection; // ���� ��ü
	public PreparedStatement preparedStatement; // ���� ���� ��ü
	public ResultSet resultSet; // ��� ���̺� ��ü

//	�Խñ� �߰�
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

//	�Խñ� ��ȸ
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

//	�Խñ� ����
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
			System.out.println("L269 update() SQL�� ����");
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

//	�Խñ� ����
	public void delete(Long boardId) {
		String query = "DELETE FROM TBL_BOARD WHERE BOARD_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, boardId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete() SQL�� ����");
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

//	�Խñ� ��ü ��ȸ
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

//		            ��ü ������ ��� Model ��ü�� ArrayList �ڷᱸ���� ������� ����ش�.
				boards.add(boardVO);
			}

		} catch (SQLException e) {
			System.out.println("selectAll() SQL�� ����");
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
