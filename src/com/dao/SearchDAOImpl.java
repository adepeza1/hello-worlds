package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbutil.OracleDbConn;
import com.exception.BusinessException;
import com.to.Player;
import com.to.Team;

public class SearchDAOImpl implements SearchDAO{

	@Override
	public Player getPlayerById(String id) throws BusinessException {
		Player player = null;
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql ="select p.id, p.name,p.dob, p.email, p.gender, p.contact,t.teamnames from player p join teams t on p.team_id = t.team_id where p.id=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, id);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {
				player=new Player();
				player.setId( id);
				player.setName(resultset.getString("name"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setEmai(resultset.getString("email"));
				player.setTeamname(resultset.getString("teamnames"));
				player.setDob(resultset.getDate("dob"));
			}else {
				throw new BusinessException("Player invalid");
	
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error "+e);

		}
		return player;
	}

	@Override
	public Player getPlayerByContact(long contact) throws BusinessException {
		Player player = null;
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql ="select p.id, p.name,p.dob, p.email, p.gender, p.contact,t.teamnames from player p join teams t on p.team_id = t.team_id where p.contact=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setLong(1, contact);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {
				player=new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setGender(resultset.getString("gender"));
				player.setContact(contact);
				player.setEmai(resultset.getString("email"));
				player.setTeamname(resultset.getString("teamnames"));
				player.setDob(resultset.getDate("dob"));
			}else {
				throw new BusinessException("Player invalid");
	
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error "+e);
			
		
		}
		return player;
	}

	@Override
	public Player getPlayerByEmail(String email) throws BusinessException {
		Player player = null;
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql ="select p.id, p.name,p.dob, p.email, p.gender, p.contact,t.teamnames from player p join teams t on p.team_id = t.team_id where p.email=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, email);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next()) {
				player=new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setEmai(email);
				player.setTeamname(resultset.getString("teamnames"));
				player.setDob(resultset.getDate("dob"));
			}else {
				throw new BusinessException("Player invalid");
	
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error "+e);

		}
		return player;
	}

	@Override
	public List<Player> getPlayersbyGender(String gender) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql ="select p.id, t.teamnames,p.name,p.dob, p.email, p.gender, p.contact from player p join teams t on p.team_id = t.team_id where p.gender=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, gender);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next()) {
				
				Player player=new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setGender(gender);
				player.setContact(resultset.getLong("contact"));
				player.setEmai(resultset.getString("email"));
				player.setTeamname(resultset.getString("teamnames"));
				player.setDob(resultset.getDate("dob"));
				playerList.add(player);
				
			}
			if(playerList.size()==0) {
				throw new BusinessException("Player invalid");
	
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error "+e);

		}
		
		return playerList;
	}

	@Override
	public List<Player> getPlayersbyName(String name) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql ="select p.id, t.teamnames,p.name,p.dob, p.email, p.gender, p.contact from player p join teams t on p.team_id = t.team_id where p.name=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, name);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next()) {
				
				Player player=new Player();
				player.setId(resultset.getString("id"));
				player.setName(name);
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setEmai(resultset.getString("email"));
				player.setTeamname(resultset.getString("teamnames"));
				player.setDob(resultset.getDate("dob"));
				playerList.add(player);
				
			}
			if(playerList.size()==0) {
				throw new BusinessException("Player invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error "+e);
		}
		
		return playerList;
	}

	@Override
	public List<Player> getPlayersbyTeamName(String teamname) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql ="select p.id, p.name,p.dob, p.email, p.gender, p.contact from player p join teams t on p.team_id = t.team_id where t.teamnames=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, teamname);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next()) {
				
				Player player=new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setEmai(resultset.getString("email"));
				player.setTeamname(teamname);
				player.setDob(resultset.getDate("dob"));
				playerList.add(player);		
			}
			if(playerList.size()==0) {
				throw new BusinessException("Player invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error "+e);

		}
		
		return playerList;
	}

	@Override
	public List<Player> getPlayersbyDob(Date dob) throws BusinessException {
		List<Player> playerList=new ArrayList<>();
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql ="select p.id, p.name, t.teamnames,p.email, p.gender, p.contact from player p join teams t on p.team_id = t.team_id where p.dob=?";
			
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setDate(1,new java.sql.Date(dob.getTime()));
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next()) {
				
				Player player=new Player();
				player.setId(resultset.getString("id"));
				player.setName(resultset.getString("name"));
				player.setGender(resultset.getString("gender"));
				player.setContact(resultset.getLong("contact"));
				player.setEmai(resultset.getString("email"));
				player.setTeamname(resultset.getString("teamnames"));
				player.setDob(dob);
				playerList.add(player);	
			}
			if(playerList.size()==0) {
				throw new BusinessException("No records for the DOB - >  "+dob);
	
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error "+e);

		}
		
		return playerList;
	}

	@Override
	public Player addPlayer(Player player) throws BusinessException {
		try (Connection connection=OracleDbConn.getConnection()) {

			String sql="{call REGISTERPLAYER(?,?,?,?,?,?,?,?)}";
			CallableStatement callablestatement = connection.prepareCall(sql);
			callablestatement.registerOutParameter(1, java.sql.Types.VARCHAR);
			callablestatement.setString(2,player.getName());
			callablestatement.setDate(3, new java.sql.Date(player.getDob().getTime()));
			callablestatement.setString(4, player.getEmai());
			callablestatement.setString(5, player.getGender());
			callablestatement.setString(6,player.getTeamname());
			callablestatement.registerOutParameter(7, java.sql.Types.VARCHAR);
			callablestatement.setLong(8, player.getContact());
			
			callablestatement.execute();

			if(callablestatement.getString(7) == null)
			{
				player.setId(callablestatement.getString(1));
			}	
			else
			{
				throw new SQLException(callablestatement.getString(7));
			}
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Internal error "+e);
				
			}
			System.out.println(player);
			return player;
	}


	

	@Override
	public int deletePlayer(String id) throws BusinessException {
		int c=0;
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql = "delete from Player where id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error "+e);
			
		}
		return c;
	}

	@Override
	public int updatePlayerContact(String id, long contact) throws BusinessException {
		int c =0;
		Player player = null;
		try (Connection connection=OracleDbConn.getConnection()) {
			String sql = "update Player set contact = ? where id =?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			player=new Player();
			preparedStatement.setLong(1, contact);
			preparedStatement.setString(2, id);
			 c = preparedStatement.executeUpdate();
			 
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error "+e);
		}
		
		return c;
		
	}

	@Override
	public int addTeam(Team team) throws BusinessException {

		try (Connection connection=OracleDbConn.getConnection()) {
			String sql = "{call regteam(?,?,?)}";
			CallableStatement callablestatement = connection.prepareCall(sql);
			//set the values
			callablestatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callablestatement.setString(2,team.getTeamname());
			callablestatement.setString(3,team.getCoachname());
			
			callablestatement.execute();
			team.setTeam_id(callablestatement.getInt(1));
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error "+e);
			
		}
		return team.getTeam_id();
	}


}
