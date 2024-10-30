package vn.iotstar.configs;

import java.sql.Date;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityTransaction;

import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;
import vn.iotstar.entity.Video;

public class Test {

	public static void main(String[] args) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();
//		Category cate = new Category();
//
//		cate.setCategoryname("Iphone");
//
//		cate.setImages("abc.jpg");
//
//		cate.setStatus(1);

//		Video video = new Video();
//
//		video.setVideoId("v001");
//
//		video.setTitle("test");
//
//		video.setCategory(cate);
		
		User user = new User();
		user.setUsername("GG");
		user.setPassword("12345");
		user.setImages("profile.jpg");
		user.setFullname("ABC");
		user.setEmail("ffhslkjdhvlkzhgk");
		user.setPhone("0123456789");
		long millis = System.currentTimeMillis();  
		user.setCreateDate(new Date(millis));

		try {

			trans.begin();
//			enma.persist(cate);
//			enma.persist(video);
			enma.persist(user);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

}