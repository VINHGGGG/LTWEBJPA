package vn.iotstar.dao;

import java.util.List;

import jakarta.persistence.*;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;

public class UserDao implements IUserDao {

	@Override

	public void insert(User user) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.persist(user);// insert vào bảng

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override

	public void update(User user) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			enma.merge(user);// update vào bảng

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override

	public void delete(int userid) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			User user = enma.find(User.class, userid);

			if (user != null) {

				enma.remove(user);

			} else {

				throw new Exception("Không tìm thấy");

			}

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override

	public Category findById(int cateid) {

		EntityManager enma = JPAConfig.getEntityManager();

		Category category = enma.find(Category.class, cateid);

		return category;

	}

	@Override

	public Category findByCategoryname(String name) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM Category c WHERE c.categoryname =:catename";

		try {

			TypedQuery<Category> query = enma.createQuery(jpql, Category.class);

			query.setParameter("catename", name);

			Category category = query.getSingleResult();

			if (category == null) {

				throw new Exception("Tên category đã tồn tại");

			}

			return category;

		} finally {

			enma.close();

		}

	}

	@Override

	public List<Category> findAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);

		return query.getResultList();

	}

	@Override

	public List<Category> searchByName(String catname) {

		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM Category c WHERE c.catename like :catname";

		TypedQuery<Category> query = enma.createQuery(jpql, Category.class);

		query.setParameter("catename", "%" + catname + "%");

		return query.getResultList();

	}

	@Override

	public List<Category> findAll(int page, int pagesize) {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);

		query.setFirstResult(page * pagesize);

		query.setMaxResults(pagesize);

		return query.getResultList();

	}

	@Override


	 public int count() {


	 EntityManager enma = JPAConfig.getEntityManager();


	 String jpql = "SELECT count(c) FROM Category c";


	 Query query = enma.createQuery(jpql);


	 return ((Long)query.getSingleResult()).intValue();


	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> searchByUsername(String usname) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public User findByUsername(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}