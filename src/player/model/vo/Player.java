package player.model.vo;

public class Player {
	
	private String playerName;
	private int goal;
	private int assist;
	
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	
	
	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", goal=" + goal + ", assist=" + assist + "]";
	}
}
