package player.controller;

import java.util.List;

import player.model.dao.PlayerDAO;
import player.model.vo.Player;

public class PlayerController {
	
	/**
	 * 전체 선수 조회
	 * @return
	 */
	public List<Player> showAllPlayer() {
		PlayerDAO pDao = new PlayerDAO();
		List<Player> pList = pDao.selectAll();
		return pList;
	}
	/**
	 * 득점순 조회
	 * @return
	 */
	public List<Player> showGoalDesc() {
		PlayerDAO pDao = new PlayerDAO();
		List<Player> pList = pDao.selectGoalDesc();
		return pList;
	}
	/**
	 * 도움순 조회
	 * @return
	 */
	public List<Player> showAssistDesc() {
		PlayerDAO pDao = new PlayerDAO();
		List<Player> pList = pDao.selectAssistDesc();
		return pList;
	}
	
	public Player printOneByName(String PlayerName) {
		PlayerDAO pDao = new PlayerDAO();
		Player player = pDao.selectOneByName(PlayerName);
		return player;
	}
	
	public int modifyPlayer(Player player) {
		PlayerDAO pDao = new PlayerDAO();
		int result = pDao.updatePlayer(player);
		return result;
	}

}
