package player.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import player.model.vo.Player;

public class PlayerDAO {
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	public List<Player> selectAll() {
		String sql = "SELECT * FROM PLAYER_TBL";
		Player player = null;
		List<Player> pList = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			pList = new ArrayList<Player>();
			while(rset.next()) {
				player = new Player();
				player.setPlayerName(rset.getString("PLAYER_NAME"));
				player.setGoal(rset.getInt("GOAL"));
				player.setAssist(rset.getInt("ASSIST"));
				pList.add(player);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	
	public List<Player> selectGoalDesc() {
		String sql = "SELECT * FROM PLAYER_TBL ORDER BY GOAL DESC";
		List<Player> pList = null;
		Player player = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			pList = new ArrayList<Player>();
			while(rset.next()) {
				player = new Player();
				player.setPlayerName(rset.getString("PLAYER_NAME"));
				player.setGoal(rset.getInt("GOAL"));
				player.setAssist(rset.getInt("ASSIST"));
				pList.add(player);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	
	public List<Player> selectAssistDesc() {
		String sql = "SELECT * FROM PLAYER_TBL ORDER BY ASSIST DESC";
		List<Player> pList = null;
		Player player = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			pList = new ArrayList<Player>();
			while(rset.next()) {
				player = new Player();
				player.setPlayerName(rset.getString("PLAYER_NAME"));
				player.setGoal(rset.getInt("GOAL"));
				player.setAssist(rset.getInt("ASSIST"));
				pList.add(player);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	
	public Player selectOneByName(String playerName) {
		String sql = "SELECT * FROM PLAYER_TBL WHERE PLAYER_NAME = '"+playerName+"'";
		Player player = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				player = new Player();
				player.setPlayerName(rset.getString("PLAYER_NAME"));
				player.setGoal(rset.getInt("GOAL"));
				player.setAssist(rset.getInt("ASSIST"));
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
	
	public int updatePlayer(Player player) {
		String sql = "UPDATE PLAYER_TBL SET GOAL = ? , ASSIST = ? WHERE PLAYER_NAME = ?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, player.getGoal());
			pstmt.setInt(2, player.getAssist());
			pstmt.setString(3, player.getPlayerName());
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
