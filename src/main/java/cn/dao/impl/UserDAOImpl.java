package cn.dao.impl;


import cn.dao.UserDAO;
import cn.model.User;

import java.util.List;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

	@Override
	public User getUser(String name) {
		String sql = "SELECT * " +
				"FROM qianzhenghao WHERE name = ?";
		return query(sql, name);
	}


	@Override
	public void insert(User user) {
		String sql = "INSERT INTO qianzhenghao (name, gender,age) VALUES " +
				"(?, ?,?)";
		long userid = insert(sql, user.getName(), user.getGender(),
		user.getAge());
	}

	@Override
	public User getUser(int id) {
		String sql = "SELECT id,name,gender,age " +
				"FROM qianzhenghao WHERE id = ?";
		return query(sql, id);
	}
	@Override
	public List<User> getUser() {
		String sql = "SELECT *" +
				"FROM qianzhenghao ";
		return queryForList(sql);
	}

}
