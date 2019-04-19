package com.bo;

import java.util.Date;
import java.util.List;

import com.exception.BusinessException;
import com.to.Player;
import com.to.Team;

public interface SearchBo {
	
	public Player addPlayer(Player player)throws BusinessException;
	public int addTeam(Team team)throws BusinessException;
	public int deletePlayer(String id)throws BusinessException;
	public int updatePlayerContact(String id, long contact)throws BusinessException;
	
	public Player getPlayerById(String id) throws BusinessException;
	public Player getPlayerByContact(long contact) throws BusinessException;
	public Player getPlayerByEmail(String email) throws BusinessException;
	public List<Player> getPlayersbyGender(String gender)throws BusinessException;
	public List<Player> getPlayersbyName(String name)throws BusinessException;
	public List<Player> getPlayersbyTeamName(String teamname)throws BusinessException;
	public List<Player> getPlayersbyDob(Date dob)throws BusinessException;

}
