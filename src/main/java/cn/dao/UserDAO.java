package cn.dao;


import cn.model.User;

import java.util.List;

public interface UserDAO {


	public abstract User getUser(String username);


	void insert(User user);

	User getUser(int i);

	List<User> getUser();
}

