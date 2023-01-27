package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.ReplyDTO;
import domain.ReplyVO;

public class ReplyDAO {
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;

//	댓글 추가 ex update
	public void insert(ReplyVO replyVO) {
		int i = 0;
		String query = "INSERT INTO TBL_REPLY (REPLY_ID, REPLY_CONTENT, REPLY_REGISTER_DATE, REPLY_UPDATE_DATE, USER_ID, "
				+ "BOARD_ID, REPLY_GROUP, REPLY_DEPTH) " + "VALUES(SEQ_REPLY.NEXTVAL, ?, SYSDATE, SYSDATE, ?, ?, SEQ_REPLY.CURRVAL, 0)";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++i, replyVO.getReplyContent());
			preparedStatement.setLong(++i, replyVO.getUserId());
			preparedStatement.setLong(++i, replyVO.getBoardId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("createDeep()");
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

//	대댓글 추가 ex update
	public void insert(ReplyVO replyVO, Long parentReplyId) {
		int i = 0;
		String query = "INSERT INTO TBL_REPLY (REPLY_ID, REPLY_CONTENT, REPLY_REGISTER_DATE, REPLY_UPDATE_DATE, USER_ID, "
				+ "BOARD_ID, REPLY_GROUP, REPLY_DEPTH) " + "VALUES(SEQ_REPLY.NEXTVAL, ?, SYSDATE, SYSDATE, ?, ?, "
				+ "(SELECT REPLY_GROUP FROM TBL_REPLY WHERE REPLY_ID = ?), "
				+ "(SELECT REPLY_DEPTH + 1 FROM TBL_REPLY WHERE REPLY_ID = ?))";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++i, replyVO.getReplyContent());
			preparedStatement.setLong(++i, replyVO.getUserId());
			preparedStatement.setLong(++i, replyVO.getBoardId());
			preparedStatement.setLong(++i, parentReplyId);
			preparedStatement.setLong(++i, parentReplyId);

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

//	댓글 전체 조회 ex query
	public ArrayList<ReplyVO> selectAll(Long boardId) {
		int i = 0;
		String query = "SELECT REPLY_ID, REPLY_CONTENT, REPLY_REGISTER_DATE, REPLY_UPDATE_DATE, USER_ID, "
				+ "BOARD_ID, REPLY_GROUP, REPLY_DEPTH " + "FROM TBL_REPLY " + "WHERE BORAD_ID = ? AND REPLY_DEPTH = 0";
		ReplyVO replyVO = null;
		ArrayList<ReplyVO> arListResult = null;

		try {
			arListResult = new ArrayList<ReplyVO>();
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, boardId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				replyVO = new ReplyVO();
				replyVO.setReplyId(resultSet.getLong(++i));
				replyVO.setReplyContent(resultSet.getString(++i));
				replyVO.setReplyRegisterDate(resultSet.getString(++i));
				replyVO.setReplyUpdateDate(resultSet.getString(++i));
				replyVO.setUserId(resultSet.getLong(++i));
				replyVO.setBoardId(resultSet.getLong(++i));
				replyVO.setReplyGroup(resultSet.getLong(++i));
				replyVO.setReplyDepth(resultSet.getLong(++i));

				// 전체 정보가 담긴 Model 객체를 ArrayList 자료구조에 순서대로 담아준다.
				arListResult.add(replyVO);
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
		return arListResult;
	}

//	댓글 전체 조회(강의)
	public ArrayList<ReplyDTO> selectAll(){
		ArrayList<ReplyDTO> result = null;
		ReplyDTO replyDTO = null;
		int i = 0;
		String query = 
				"SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, "
//				+ "USER_PASSWORD, "
				+ "USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, "
				+ "USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID, "
//				+ "RECOMMEND_COUNT, "
				+ "REPLY_ID, REPLY_CONTENT, REPLY_REGISTER_DATE, REPLY_UPDATE_DATE, "
				+ "BOARD_ID, REPLY_GROUP, REPLY_DEPTH "
				+ "FROM REPLY_DTO";
		try {
			result = new ArrayList<ReplyDTO>();
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				i = 0;
				replyDTO = new ReplyDTO();
				replyDTO.setUserId(resultSet.getLong(++i));
				replyDTO.setUserIdentification(resultSet.getString(++i));
				replyDTO.setUserName(resultSet.getString(++i));
//				replyDTO.setUserPassword(dencrypt(resultSet.getString(++i)));
//				replyDTO.setUserPassword(resultSet.getString(++i));
				replyDTO.setUserPhone(resultSet.getString(++i));
				replyDTO.setUserNickname(resultSet.getString(++i));
				replyDTO.setUserEmail(resultSet.getString(++i));
				replyDTO.setUserAddress(resultSet.getString(++i));
				replyDTO.setUserBirth(resultSet.getString(++i));
				replyDTO.setUserGender(resultSet.getString(++i));
				replyDTO.setUserRecommenderId(resultSet.getString(++i));
				replyDTO.setReplyId(resultSet.getLong(++i));
				replyDTO.setReplyContent(resultSet.getString(++i));
				replyDTO.setReplyRegisterDate(resultSet.getString(++i));
				replyDTO.setReplyUpdateDate(resultSet.getString(++i));
				replyDTO.setBoardId(resultSet.getLong(++i));
				replyDTO.setReplyGroup(resultSet.getLong(++i));
				replyDTO.setReplyDepth(resultSet.getLong(++i));

//		            전체 정보가 담긴 Model 객체를 ArrayList 자료구조에 순서대로 담아준다.
				result.add(replyDTO);
			}

		} catch (SQLException e) {
			System.out.println("selectAll() SQL문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {// resultSet을 썼으므로 닫아줌
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
		return result;
	}
	
//	대댓글 전체 조회 ex query
	public ArrayList<ReplyVO> selectAll(Long boardId, Long parentReplyId) {
		int i = 0;
		String query = "SELECT REPLY_ID, REPLY_CONTENT, REPLY_REGISTER_DATE, REPLY_UPDATE_DATE, USER_ID, "
				+ "BOARD_ID, REPLY_GROUP, REPLY_DEPTH " + "FROM TBL_REPLY "
				+ "WHERE BORAD_ID = ? AND REPLY_GROUP = ? REPLY_DEPTH > 0";
		ReplyVO replyVO = null;
		ArrayList<ReplyVO> arListResult = null;

		try {
			arListResult = new ArrayList<ReplyVO>();
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, boardId);
			preparedStatement.setLong(2, parentReplyId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				replyVO = new ReplyVO();
				replyVO.setReplyId(resultSet.getLong(++i));
				replyVO.setReplyContent(resultSet.getString(++i));
				replyVO.setReplyRegisterDate(resultSet.getString(++i));
				replyVO.setReplyUpdateDate(resultSet.getString(++i));
				replyVO.setUserId(resultSet.getLong(++i));
				replyVO.setBoardId(resultSet.getLong(++i));
				replyVO.setReplyGroup(resultSet.getLong(++i));
				replyVO.setReplyDepth(resultSet.getLong(++i));

//		            전체 정보가 담긴 Model 객체를 ArrayList 자료구조에 순서대로 담아준다.
				arListResult.add(replyVO);
			}

		} catch (SQLException e) {
			System.out.println("selectAll() SQL문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {// resultSet을 썼으므로 닫아줌
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
		return arListResult;
	}

	
	
//	댓글 수정 ex update
	public void update(ReplyVO replyVO) {
		int i = 0;
		String query = "UPDATE TBL_REPLY " + "SET REPLY_CONTENT = ?, REPLY_UPDATE_DATE = SYSDATE "
				+ "WHERE REPLY_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);

			// 내용 수정
			preparedStatement.setString(++i, replyVO.getReplyContent());

			// 받은 replyVO객체에서 replyId 받아서 넣기
			preparedStatement.setLong(++i, replyVO.getReplyId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update() SQL문 오류");
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

//	댓글 삭제 ex update
	public void delete(Long replyId) {
		String query = "DELETE FROM TBL_REPLY WHERE REPLY_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, replyId);
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

}
