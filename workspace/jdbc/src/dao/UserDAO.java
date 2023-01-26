package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.UserVO;

public class UserDAO {

	public Connection connection; // 연결 객체
	public PreparedStatement preparedStatement; // 쿼리 관리 객체
	public ResultSet resultSet; // 결과 테이블 객체

	private static final int KEY = ' ';
//	아이디 중복검사
	public boolean checkId(String userIdentification) {
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		boolean result = false;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			result = resultSet.getInt(1) == 0;	// 중복이 없으면 true 리턴

		} catch (SQLException e) {
			System.out.println("checkId(String) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
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
				throw new RuntimeException(e);
			}
		}
		return result;
	}

//	회원가입
	public void join(UserVO userVO) {
		int i = 0;
		String query = "INSERT INTO TBL_USER " + " (USER_ID, USER_IDENTIFICATION, USER_NAME, "
				+ "USER_PASSWORD, USER_PHONE, USER_NICKNAME, " + "USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, "
				+ "USER_RECOMMENDER_ID) " + "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++i, userVO.getUserIdentification());	// 1
			preparedStatement.setString(++i, userVO.getUserName());				// 2
//			preparedStatement.setString(++i, encrypt(userVO.getUserPassword()));// 3
			preparedStatement.setString(++i, userVO.getUserPassword());			// 3
			preparedStatement.setString(++i, userVO.getUserPhone());			// 4
			preparedStatement.setString(++i, userVO.getUserNickname());			// 5
			preparedStatement.setString(++i, userVO.getUserEmail());			// 6
			preparedStatement.setString(++i, userVO.getUserAddress());          // 7
			preparedStatement.setString(++i, userVO.getUserBirth());            // 8
			preparedStatement.setString(++i, userVO.getUserGender());           // 9
			preparedStatement.setString(++i, userVO.getUserRecommenderId());    // 10

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("L55 join()");
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

//	로그인
	public Long login(String userIdentification, String userPassword) {
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_IDENTIFICATION = ? AND USER_PASSWORD = ?";
		Long userId = -1L;
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
//			preparedStatement.setString(2, encrypt(userPassword));
			preparedStatement.setString(2, userPassword);
			resultSet = preparedStatement.executeQuery();

//	          DB에서 조회된 행이 있다면
			if (resultSet.next()) {
//	             로그인 된 회원 번호 가져오기
				userId = resultSet.getLong(1);
			}

		} catch (SQLException e) {
			System.out.println("login() SQL 오류");
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
		return userId;
	}

//	암호화
//	public String encrypt(String password) {
//		String encryptedPw = "";
//		for (String str : password.split("")) {
//			encryptedPw += String.valueOf(str.charAt(0) + KEY);
//		}
//		return encryptedPw;
//	}
//	
//	복호화
//	public String dencrypt(String encryptedPw) {
//		String dencryptedPw = "";
//		for (String str : encryptedPw.split("")) {
//			dencryptedPw += String.valueOf(str.charAt(0) - KEY);
//			
//		}
//		return dencryptedPw;
//	}
	
//	회원탈퇴
	public void delete(Long userId) {
		String query = "DELETE FROM TBL_USER WHERE USER_NUMBER = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
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

//	아이디 찾기
	public String findIdByUserPhoneNumber(String userPhoneNumber) {
		String query = "SELECT USER_IDENTIFICATION FROM TBL_USER WHERE USER_PHONE = ?";
		String userId = null;
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhoneNumber);
			resultSet = preparedStatement.executeQuery();

//		         유효한 핸드폰 번호라면
			if (resultSet.next()) {
//		            아이디를 가져온다.
				userId = resultSet.getString(1);
			}

		} catch (SQLException e) {
			System.out.println("L181 findIdByUserPhoneNumber() SQL문 오류");
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

		return userId;
	}

	
	
//	비밀번호 변경
	public void updateUserPassword(String userId, String newUserPassword) {
//	      아이디로 조회하여 기존 비밀번호를 새로운 비밀번호로 변경한다.
		String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, encrypt(newUserPassword));
			preparedStatement.setString(1, newUserPassword);
			preparedStatement.setString(2, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("L230 updateUserPassword() SQL 오류");
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

//	회원정보 수정
	public void update(UserVO userVO) {
		int i = 0;
		String query = "UPDATE TBL_USER "
				+ "SET USER_NAME = ?, USER_PASSWORD = ?, USER_PHONE = ?, USER_NICKNAME = ?, USER_EMAIL = ?, USER_ADDRESS = ?, "
//		            TO_DATE()를 사용하지 않았을 때 format관련 오류 발생 시 TO_DATE()로 알맞는 형식을 작성해준다.
//		            DBMS의 DATE 타입에 문자열 또는 NULL을 넣기 위해서는 TO_DATE()함수를 사용하여 넣어준다. 
				+ "USER_BIRTH = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), USER_GENDER = ? " + "WHERE USER_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(++i, userVO.getUserName());
//			preparedStatement.setString(++i, encrypt(userVO.getUserPassword()));
			preparedStatement.setString(++i, userVO.getUserPassword());
			preparedStatement.setString(++i, userVO.getUserPhone());
			preparedStatement.setString(++i, userVO.getUserNickname());
			preparedStatement.setString(++i, userVO.getUserEmail());
			preparedStatement.setString(++i, userVO.getUserAddress());
			preparedStatement.setString(++i, userVO.getUserBirth());
			preparedStatement.setString(++i, userVO.getUserGender());
			preparedStatement.setLong(++i, userVO.getUserId());
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

//	회원정보 조회
	public UserVO select(Long userId) {
		int i = 0;
		String query = "SELECT USER_ID, USER_IDENTIFICATION, USER_NAME, USER_PASSWORD,"
				+ " USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, "
				+ "USER_GENDER, USER_RECOMMENDER_ID " + "FROM TBL_USER WHERE USER_ID = ?";
		UserVO userVO = null;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(++i));
				userVO.setUserIdentification(resultSet.getString(++i));
				userVO.setUserName(resultSet.getString(++i));
//				userVO.setUserPassword(dencrypt(resultSet.getString(++i)));
				userVO.setUserPassword(resultSet.getString(++i));
				userVO.setUserPhone(resultSet.getString(++i));
				userVO.setUserNickname(resultSet.getString(++i));
				userVO.setUserEmail(resultSet.getString(++i));
				userVO.setUserAddress(resultSet.getString(++i));
				userVO.setUserBirth(resultSet.getString(++i));
				userVO.setUserGender(resultSet.getString(++i));
				userVO.setUserRecommenderId(resultSet.getString(++i));
			}

		} catch (SQLException e) {
			System.out.println("L314 select(Long) SQL문 오류");
			e.printStackTrace();
		} catch (Exception e) {
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
				throw new RuntimeException(e);
			}
		}

		return userVO;
	}

//	추천수
	public int getRecommenderCount(String userId) {
//	      회원을 추천한 사람들의 수를 센다.
		String query = "SELECT COUNT(USER_RECOMMENDER_ID) FROM TBL_USER " + "WHERE USER_RECOMMENDER_ID = ?";
		int recommenderCount = 0;
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			recommenderCount = resultSet.getInt(1);

		} catch (SQLException e) {
			System.out.println("L352 getRecommenderCount() SQL문 오류");
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
		return recommenderCount;
	}

//	나를 추천한 사람
	public ArrayList<UserVO> getRecommendedUsers(String userId) {
		int i = 0;
		String query = "SELECT USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID, USER_IDENTIFICATION FROM TBL_USER "
				+ "WHERE USER_RECOMMENDER_ID = ?";
		ArrayList<UserVO> users = new ArrayList<UserVO>();
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();

			//	몇 명이 추천했을지 알 수 없기 때문에 더 이상 결과가 없을 때까지 하나씩 행을 가져온다.
			while (resultSet.next()) {
				UserVO userVO = new UserVO();

				//	각 행의 전체 정보를 userVO 객체에 담아준다.
				userVO.setUserId(resultSet.getLong(++i));
				userVO.setUserName(resultSet.getString(++i));
				userVO.setUserPassword(resultSet.getString(++i));
				userVO.setUserPhone(resultSet.getString(++i));
				userVO.setUserNickname(resultSet.getString(++i));
				userVO.setUserEmail(resultSet.getString(++i));
				userVO.setUserAddress(resultSet.getString(++i));
				userVO.setUserBirth(resultSet.getString(++i));
				userVO.setUserGender(resultSet.getString(++i));
				userVO.setUserRecommenderId(resultSet.getString(++i));
				userVO.setUserIdentification(resultSet.getString(++i));

//		            전체 정보가 담긴 Model 객체를 ArrayList 자료구조에 순서대로 담아준다.
				users.add(userVO);
			}

		} catch (SQLException e) {
			System.out.println("L406 getRecommenderCount() SQL문 오류");
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
		return users;
	}

	//	내가 추천한 사람(하나)
	public UserVO getRecommender(String userIdentification) {
		int i = 0;
	    //	추천한 사람의 아이디로 전체 정보를 조회한다.
		String query = "SELECT USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH, USER_GENDER, USER_RECOMMENDER_ID, USER_ID FROM TBL_USER "
				+ "WHERE USER_ID = "
				+ "("
				+ "SELECT NVL(USER_RECOMMENDER_ID, \'\') FROM TBL_USER " + "WHERE USER_IDENTIFICATION = ?"
				+ ")";
		UserVO userVO = null;

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				userVO = new UserVO();
				userVO.setUserId(resultSet.getLong(++i));
				userVO.setUserName(resultSet.getString(++i));
				userVO.setUserPassword(resultSet.getString(++i));
				userVO.setUserPhone(resultSet.getString(++i));
				userVO.setUserNickname(resultSet.getString(++i));
				userVO.setUserEmail(resultSet.getString(++i));
				userVO.setUserAddress(resultSet.getString(++i));
				userVO.setUserBirth(resultSet.getString(++i));
				userVO.setUserGender(resultSet.getString(++i));
				userVO.setUserRecommenderId(resultSet.getString(++i));
				userVO.setUserIdentification(resultSet.getString(++i));
			}

		} catch (SQLException e) {
			System.out.println("L458 getRecommenderCount() SQL문 오류");
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
		return userVO;
	}
}
