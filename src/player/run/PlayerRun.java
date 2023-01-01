package player.run;

import java.util.List;

import player.controller.PlayerController;
import player.model.dao.PlayerDAO;
import player.model.vo.Player;
import player.view.PlayerView;

public class PlayerRun {

	public static void main(String[] args) {
		PlayerView view = new PlayerView();
		PlayerDAO pDao = new PlayerDAO();
		PlayerController conn = new PlayerController();
		List<Player> pList = null;
		String playerName = "";
		Player player = null;
		goodbye : 
		while(true) {
			int choice = view.menu();
			switch(choice) {
			case 1 : 
				// 전체조회
				pList = conn.showAllPlayer();
				view.showAll(pList);
				break;
			case 2 : 
				// 득점순 조회
				pList = conn.showGoalDesc();
				view.showAll(pList);
				break;
			case 3: 
				// 도움순 조회
				pList = conn.showAssistDesc();
				view.showAll(pList);
				break;
			case 4: 
				// 수정
				playerName = view.inputPlayerName();
				player = conn.printOneByName(playerName);
				if(player != null) {
					player = view.modifyPlayer(player);
					conn.modifyPlayer(player);
					System.out.println("수정 완료");
				} else
					System.out.println("수정 실패");
				break;
			case 0 : break goodbye;
			default : break;
			}
		}

	}

}
