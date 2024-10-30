package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;

public interface IUserDao {

	void insert(User user);

	int count();

	List<User> findAll(int page, int pagesize);

	List<User> searchByUsername(String usname);

	List<User> findAll();

	User findById(int userid);

	void delete(int userid) throws Exception;

	void update(User user);

	User findByUsername(String name) throws Exception;

}