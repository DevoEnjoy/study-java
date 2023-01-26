package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.UserVO;

public class UserDAO {

	public Connection connection; // ���� ��ü
	public PreparedStatement preparedStatement; // ���� ���� ��ü
	public ResultSet resultSet; // ��� ���̺� ��ü

	private static final int KEY = ' ';
//	���̵� �ߺ��˻�
	public boolean checkId(String userIdentification) {
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_IDENTIFICATION = ?";
		boolean result = false;
		connection = DBConnecter.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userIdentification);
			resultSet = preparedStatement.executeQuery();

			resultSet.next();
			result = resultSet.getInt(1) == 0;	// �ߺ��� ������ true ����

		} catch (SQLException e) {
			System.out.println("checkId(String) SQL�� ����");
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

//	ȸ������
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

//	�α���
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

//	          DB���� ��ȸ�� ���� �ִٸ�
			if (resultSet.next()) {
//	             �α��� �� ȸ�� ��ȣ ��������
				userId = resultSet.getLong(1);
			}

		} catch (SQLException e) {
			System.out.println("login() SQL ����");
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

//	��ȣȭ
//	public String encrypt(String password) {
//		String encryptedPw = "";
//		for (String str : password.split("")) {
//			encryptedPw += String.valueOf(str.charAt(0) + KEY);
//		}
//		return encryptedPw;
//	}
//	
//	��ȣȭ
//	public String dencrypt(String encryptedPw) {
//		String dencryptedPw = "";
//		for (String str : encryptedPw.split("")) {
//			dencryptedPw += String.valueOf(str.charAt(0) - KEY);
//			
//		}
//		return dencryptedPw;
//	}
	
//	ȸ��Ż��
	public void delete(Long userId) {
		String query = "DELETE FROM TBL_USER WHERE USER_NUMBER = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
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

//	���̵� ã��
	public String findIdByUserPhoneNumber(String userPhoneNumber) {
		String query = "SELECT USER_IDENTIFICATION FROM TBL_USER WHERE USER_PHONE = ?";
		String userId = null;
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhoneNumber);
			resultSet = preparedStatement.executeQuery();

//		         ��ȿ�� �ڵ��� ��ȣ���
			if (resultSet.next()) {
//		            ���̵� �����´�.
				userId = resultSet.getString(1);
			}

		} catch (SQLException e) {
			System.out.println("L181 findIdByUserPhoneNumber() SQL�� ����");
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

	
	
//	��й�ȣ ����
	public void updateUserPassword(String userId, String newUserPassword) {
//	      ���̵�� ��ȸ�Ͽ� ���� ��й�ȣ�� ���ο� ��й�ȣ�� �����Ѵ�.
		String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, encrypt(newUserPassword));
			preparedStatement.setString(1, newUserPassword);
			preparedStatement.setString(2, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("L230 updateUserPassword() SQL ����");
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

//	ȸ������ ����
	public void update(UserVO userVO) {
		int i = 0;
		String query = "UPDATE TBL_USER "
				+ "SET USER_NAME = ?, USER_PASSWORD = ?, USER_PHONE = ?, USER_NICKNAME = ?, USER_EMAIL = ?, USER_ADDRESS = ?, "
//		            TO_DATE()�� ������� �ʾ��� �� format���� ���� �߻� �� TO_DATE()�� �˸´� ������ �ۼ����ش�.
//		            DBMS�� DATE Ÿ�Կ� ���ڿ� �Ǵ� NULL�� �ֱ� ���ؼ��� TO_DATE()�Լ��� ����Ͽ� �־��ش�. 
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

//	ȸ������ ��ȸ
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
			System.out.println("L314 select(Long) SQL�� ����");
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

//	��õ��
	public int getRecommenderCount(String userId) {
//	      ȸ���� ��õ�� ������� ���� ����.
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
			System.out.println("L352 getRecommenderCount() SQL�� ����");
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

//	���� ��õ�� ���
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

			//	�� ���� ��õ������ �� �� ���� ������ �� �̻� ����� ���� ������ �ϳ��� ���� �����´�.
			while (resultSet.next()) {
				UserVO userVO = new UserVO();

				//	�� ���� ��ü ������ userVO ��ü�� ����ش�.
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

//		            ��ü ������ ��� Model ��ü�� ArrayList �ڷᱸ���� ������� ����ش�.
				users.add(userVO);
			}

		} catch (SQLException e) {
			System.out.println("L406 getRecommenderCount() SQL�� ����");
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

	//	���� ��õ�� ���(�ϳ�)
	public UserVO getRecommender(String userIdentification) {
		int i = 0;
	    //	��õ�� ����� ���̵�� ��ü ������ ��ȸ�Ѵ�.
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
			System.out.println("L458 getRecommenderCount() SQL�� ����");
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
