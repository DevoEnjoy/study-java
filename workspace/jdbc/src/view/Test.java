package view;

import dao.ReplyDAO;
import domain.ReplyVO;

public class Test {
	public static void main(String[] args) {
//		UserDAO userDAO = new UserDAO();
//		if(userDAO.checkId("hds1234")) {
//			System.out.println("��� ������ ���̵�");
//			return;
//		}
//		System.out.println("�ߺ��� ���̵�");
		
//		System.out.println(userDAO.select(1L));
//		UserVO userVO = new UserVO();
//		userVO.setUserIdentification("daniel1993");
//		userVO.setUserEmail("asd@gmail.com");
//		userVO.setUserGender("M");
//		userVO.setUserName("asd");
//		userVO.setUserPassword("asd");
//		userVO.setUserPhone("0102345123");
		
//		UserVO userVO = new UserVO();
//		userVO.setUserIdentification("daniel1993");
//		userVO.setUserEmail("asd23@gmail.com");
//		userVO.setUserGender("M");
//		userVO.setUserName("asd2");
//		userVO.setUserPassword("asd2");
//		userVO.setUserPhone("01023451236");
		
//		UserVO userVO = new UserVO();
//		userVO.setUserIdentification("daniel19932");
//		userVO.setUserEmail("asd24@gmail.com");
//		userVO.setUserGender("M");
//		userVO.setUserName("asd5");
//		userVO.setUserPassword("asd2");
//		userVO.setUserPhone("01023451237");
//		
////		userVO.setUserAddress("asd");
////		userVO.setUserBirth("1993-06-13");
////		userVO.setUserNickname("asd");
//		userVO.setUserRecommenderId("daniel93");
//		
//		
//		//	����
//		userDAO.join(userVO);
		
//      Connection connection = DBConnecter.getConnection();
//      try {
//         connection.close();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
      
//      �α���
//      System.out.println(userDAO.login("daniel1993", "asd"));
//      System.out.println(userDAO.login(userVO.getUserIdentification(), userVO.getUserPassword()));
      
//      ȸ������ ����
//      UserVO userVO = userDAO.select(userDAO.login("daniel1993", "asd"));
//      userVO.setUserBirth(null);
//      userDAO.update(userVO);
      
//      ���̵� ã��
//      System.out.println(userDAO.findIdByUserPhoneNumber("01023451236"));
      
//      ��й�ȣ ����
//      userDAO.updateUserPassword("daniel1993", "asd");
//      System.out.println(userDAO.select(userDAO.login("daniel1993", "asd")));
//      System.out.println("d");
      
//      ȸ��Ż��
//      userDAO.delete(userDAO.login("jbg", "5678"));
      
//      ��õ��
//      System.out.println(userDAO.getRecommenderCount("hgd"));
      
//      ���� ��õ�� ���
//      userDAO.getRecommendedUsers("hds").forEach(System.out::println);
      
//      ���� ��õ�� ���
//      System.out.println(userDAO.getRecommender("hgd"));
		
		
		// �����VO
		ReplyVO replyVO = new ReplyVO();
//		replyVO.setBoardId(1L);
//		replyVO.setReplyContent("�׽�Ʈ2java");
//		replyVO.setReplyDepth(0L);
//		replyVO.setReplyGroup(2L);
//		replyVO.setUserId(1L);
		
		// ���VO ���
		ReplyDAO replyDAO = new ReplyDAO();
//		replyDAO.insert(replyVO);
		
		// ���� ���� �߰�
		replyVO.setReplyContent("�����׽�Ʈ1");
		replyVO.setBoardId(1L);
		replyVO.setUserId(2L);
		replyDAO.insert(replyVO, 1L);
		
		
		
		
		
	}
}
