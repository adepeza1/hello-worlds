package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.OracleDbConn;
import com.exception.BusinessException;
import com.model.User;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isValidUser(User user) throws BusinessException {
		boolean b =false;
		try {
			String sql="select username from loginmaster where username=? and password=?";
			Connection connection=OracleDbConn.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, user.getUsername());
			preparedstatement.setString(2, user.getPassword());
			ResultSet resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
				b=true;
			}else {
				throw new BusinessException("Invalid login Credentials");
			}
			
		} catch (ClassNotFoundException e) {
			throw new BusinessException("Internal Error"+e);
		} catch (SQLException e) {
			throw new BusinessException("Internal Error"+e);
		}
		return b;
	}

}
