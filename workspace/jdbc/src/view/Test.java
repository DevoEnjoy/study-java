package view;

import dao.ReplyDAO;
import domain.ReplyVO;

public class Test {
	public static void main(String[] args) {
//		UserDAO userDAO = new UserDAO();
//		if(userDAO.checkId("hds1234")) {
//			System.out.println("사용 가능한 아이디");
//			return;
//		}
//		System.out.println("중복된 아이디");
		
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
//		//	가입
//		userDAO.join(userVO);
		
//      Connection connection = DBConnecter.getConnection();
//      try {
//         connection.close();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
      
//      로그인
//      System.out.println(userDAO.login("daniel1993", "asd"));
//      System.out.println(userDAO.login(userVO.getUserIdentification(), userVO.getUserPassword()));
      
//      회원정보 수정
//      UserVO userVO = userDAO.select(userDAO.login("daniel1993", "asd"));
//      userVO.setUserBirth(null);
//      userDAO.update(userVO);
      
//      아이디 찾기
//      System.out.println(userDAO.findIdByUserPhoneNumber("01023451236"));
      
//      비밀번호 변경
//      userDAO.updateUserPassword("daniel1993", "asd");
//      System.out.println(userDAO.select(userDAO.login("daniel1993", "asd")));
//      System.out.println("d");
      
//      회원탈퇴
//      userDAO.delete(userDAO.login("jbg", "5678"));
      
//      추천수
//      System.out.println(userDAO.getRecommenderCount("hgd"));
      
//      나를 추천한 사람
//      userDAO.getRecommendedUsers("hds").forEach(System.out::println);
      
//      내가 추천한 사람
//      System.out.println(userDAO.getRecommender("hgd"));
		
		
		// 원댓글VO
		ReplyVO replyVO = new ReplyVO();
//		replyVO.setBoardId(1L);
//		replyVO.setReplyContent("테스트2java");
//		replyVO.setReplyDepth(0L);
//		replyVO.setReplyGroup(2L);
//		replyVO.setUserId(1L);
		
		// 댓글VO 등록
		ReplyDAO replyDAO = new ReplyDAO();
//		replyDAO.insert(replyVO);
		
		// 대댓글 내용 추가
		replyVO.setReplyContent("대댓글테스트1");
		replyVO.setBoardId(1L);
		replyVO.setUserId(2L);
		replyDAO.insert(replyVO, 1L);
		
		
		
		
		
	}
}
