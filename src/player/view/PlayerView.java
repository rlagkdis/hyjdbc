package player.view;

import java.util.List;
import java.util.Scanner;

import player.model.vo.Player;

public class PlayerView {
	
	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 메뉴 ===");
		System.out.println("1. 전체 조회");
		System.out.println("2. 득점순으로 조회");
		System.out.println("3. 도움순으로 조회");
		System.out.println("4. 골, 도움 수정");
		System.out.println("메뉴 입력 : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void showAll(List<Player> pList) {
		System.out.println("=== 전체 선수 조회 ===");
		for(Player pOne : pList) {
			System.out.print("이름 : " + pOne.getPlayerName());
			System.out.print(", 골 : " + pOne.getGoal());
			System.out.println(", 도움 : " + pOne.getAssist());
		}
	}
	
	public String inputPlayerName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 선수 이름 입력 : ");
		String playerName = sc.next();
		return playerName;
	}
	
	public Player modifyPlayer(Player player) {
		Scanner sc = new Scanner(System.in);
		System.out.println("골 입력 : ");
		int goal = sc.nextInt();
		System.out.println("도움 입력 : ");
		int assist = sc.nextInt();
		player.setGoal(goal);
		player.setAssist(assist);
		return player;
	}
	
	public void displaySuccess(String message) {
		System.out.println("");
	}

}
