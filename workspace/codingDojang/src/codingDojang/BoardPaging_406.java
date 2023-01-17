package codingDojang;

public class BoardPaging_406 {
	public static int paging(int allBoards, int boardsPerPage) {
		int result = 0;
		if(boardsPerPage > 0) {
			result = allBoards % boardsPerPage > 0 ? (allBoards / boardsPerPage) + 1 : allBoards / boardsPerPage;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(paging(101, 10));
	}
	
}
