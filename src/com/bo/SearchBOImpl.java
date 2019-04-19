package com.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.SearchDAO;
import com.dao.SearchDAOImpl;
import com.exception.BusinessException;
import com.to.Player;
import com.to.Team;

public class SearchBOImpl implements SearchBo{

		private SearchDAO searchDAO;
	@Override
	public Player getPlayerById(String id) throws BusinessException {
		Player player = null;
		if(id.matches("[Pp]{1}[a-zA-Z]{2}[0-9]{7}")){
			searchDAO=getSearchDAO();
			player= searchDAO.getPlayerById(id);
		}
		else {
			throw new BusinessException("Entered player id "+id+" is invalid");
		}
		return player;
	}

	@Override
	public Player getPlayerByContact(long contact) throws BusinessException {
		Player player = null;
		if((contact+"").matches("[0-9]{10}"))
		{
			searchDAO=getSearchDAO();
			player= searchDAO.getPlayerByContact(contact);
		
		}
		else {
			throw new BusinessException("Entered player Contact "+contact+" is invalid");
		}
		return player;
	}

	@Override
	public Player getPlayerByEmail(String email) throws BusinessException {
		Player player = null;
		if(email.matches("^(.*)@(.*)"))
		{
			searchDAO=getSearchDAO();
			player= searchDAO.getPlayerByEmail(email);
		}
		else {
			throw new BusinessException("Entered player id "+email+" is invalid");
		}
		return player;
	}

	@Override
	public List<Player> getPlayersbyGender(String gender) throws BusinessException {
		List<Player> playerList = null;
		System.out.println(gender);
		if(gender.matches("[FfMm]{1}")) {
			searchDAO=getSearchDAO();
			playerList=searchDAO.getPlayersbyGender(gender);
		}
		else {
			throw new BusinessException("Gender is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersbyName(String name) throws BusinessException {
		List<Player> playerList = null;
		
		if(name.matches("[a-zA-Z]{3,9}")) {
			searchDAO=getSearchDAO();
			playerList=searchDAO.getPlayersbyName(name);
			System.out.println("if");
		}
		else {
			throw new BusinessException("Name is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersbyTeamName(String teamname) throws BusinessException {
		List<Player> playerList = null;
		if(teamname.matches("[a-zA-Z ]{3,15}")) {
			searchDAO=getSearchDAO();
			playerList=searchDAO.getPlayersbyTeamName(teamname);
			
		}
		else {
			throw new BusinessException("Team name is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersbyDob(Date dob) throws BusinessException {
		List<Player> playerList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		sdf.setLenient(false);
		String temp=sdf.format(dob);
		 try {
			dob = sdf.parse(temp);
			searchDAO= getSearchDAO();
			playerList = searchDAO.getPlayersbyDob(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return playerList;
	}

	private SearchDAO getSearchDAO() {
		if(searchDAO == null) {
			searchDAO = new SearchDAOImpl();
			
		}
		return searchDAO;
	}

	@Override
	public Player addPlayer(Player player) throws BusinessException {
		if(!player.getName().matches("[a-zA-Z]{3,15}"))
		{
			throw new BusinessException("The current name: " + player.getName() + " is invalid.");
		}
		if(!player.getEmai().matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"))
		{
			throw new BusinessException("The current email: " + player.getEmai() + " is invalid.");
		}
		if(!player.getGender().matches("[mfMF]"))
		{
			throw new BusinessException("The current gender: " + player.getGender() + " is invalid.");
		}
		if(String.valueOf(player.getContact()).length() != 10)
		{
			throw new BusinessException("The current contact number: " + player.getContact() + " is invalid.");
		}
		if(!player.getTeamname().matches("[a-zA-Z ]{3,15}"))
		{
			throw new BusinessException("The current team name: " + player.getTeamname() + " is invalid.");
		}

		searchDAO = getSearchDAO();
		player = searchDAO.addPlayer(player);
		return player;
	}

	

	@Override
	public int deletePlayer(String id) throws BusinessException {
		int c=0;
		
		if(id.matches("[Pp]{1}[a-zA-Z]{2}[0-9]{7}")) {
			searchDAO=getSearchDAO();
			c=searchDAO.deletePlayer(id);
		}
		return c;
	}

	@Override
	public int updatePlayerContact(String id, long contact) throws BusinessException {
		int c =0;
		boolean k = true;
		if(id.matches("[Pp]{1}[a-zA-Z]{2}[0-9]{7}")) {
			searchDAO=getSearchDAO();
			k = true;
		}
		if((contact+"").matches("[0-9]{10}")) {
			searchDAO=getSearchDAO();
			k = true;
		}
		if(k=true) {
			c=searchDAO.updatePlayerContact(id,contact);
			}
		return c;
	}

	@Override
	public int addTeam(Team team) throws BusinessException {
		
		int c = 0;
		boolean p = false;
		
	
		if(team.getTeamname().matches("[a-zA-Z]{3,15}")) {
			searchDAO=getSearchDAO();
			p = true;
		}
		else {
			throw new BusinessException("Team name is invalid");
		}
		if((team.getCoachname()+"").matches("[a-zA-Z]{2,15}")) {
			searchDAO=getSearchDAO();
			p = true;
		}
		if(p=true) {
		c=searchDAO.addTeam(team);
		}
		else {
			throw new BusinessException("Coach name is invalid");
		}

		return c;
	}

	



}
