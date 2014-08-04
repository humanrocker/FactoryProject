package com.factoryproject.test;

import java.util.List;

import com.factoryproject.dao.*;
import com.factoryproject.data.Message;
import com.factoryproject.data.News;
import com.factoryproject.data.User;

/**
 * Test class for DAOs.
 * 
 * @author TonyHong
 * 
 */
public class TestService {
	static User godOfXie = new User("GodOfXie", "martin", 0);
	static User littleRed = new User("LittleRed", "wayhome", 1);
	static User tony = new User("Tony", "sea", 1);
	static User sonOf6 = new User("SonOf6", "666", 0);
	static User canon = new User("Canon", "1234", 0);
	static User fox = new User("Fox", "4321", 0);

	static Message m0 = new Message("Sheisse", tony);
	static News n0 = new News("Little Red shites on his desk !!!!!", littleRed);

	private static boolean testUserHibernateDAO() {
		boolean result = true;
		UserHibernateDAO uhdao = new UserHibernateDAO();

		uhdao.addUser(godOfXie);
		uhdao.addUser(littleRed);
		uhdao.addUser(tony);
		uhdao.addUser(sonOf6);
		uhdao.addUser(canon);
		uhdao.addUser(fox);

		System.out.println("Init user list: ");
		List<User> ul = uhdao.findAll();
		for (User u : ul) {
			System.out.println(u);
		}

		if (!uhdao.findUserByName("Tony").getUsername().equals("Tony"))
			result = false;

		if (!uhdao.getPasswordByUsername("Fox").equals("4321"))
			result = false;

		if (uhdao.getPermissionByUsername("SonOf6") != 0)
			result = false;

		uhdao.deleteUser(littleRed);
		if (uhdao.findUserByName("LittleRed") != null)
			result = false;

		uhdao.setPasswordByUsername("GodOfXie", "sheisse");
		if (!uhdao.findUserByName("GodOfXie").getPassword().equals("sheisse"))
			result = false;

		uhdao.setPermissionByUsername("Tony", 2);
		if (uhdao.findUserByName("Tony").getPermission() != 2)
			result = false;

		if (!uhdao.findUsersByPermission(2).get(0).getUsername().equals("Tony"))
			result = false;

		uhdao.flush();
		uhdao.clear();

		// // Not tested! ID is managed by DB
		// User u1 = uhdao.findUserByID(1);
		// uhdao.deleteUser(u1);

		System.out.println("Final user list: ");
		ul = uhdao.findAll();
		for (User u : ul) {
			System.out.println(u);
		}

		// Clean up
		uhdao.close();

		return result;
	}

	private static boolean testMessageHibernateDAO() {
		MessageHibernateDAO mhdao = new MessageHibernateDAO();
		mhdao.addMessage(m0);
		return false;
	}

	private static boolean testNewsHibernateDAO() {
		NewsHibernateDAO nhdao = new NewsHibernateDAO();
		nhdao.addNews(n0);
		return false;
	}

	/**
	 * 
	 * Test suit entrance.
	 */
	public static boolean test() {
		boolean result = false;

		result = testUserHibernateDAO();
		// testMessageHibernateDAO();
		// testNewsHibernateDAO();

		// System.out.println("findMessagesBySpeaker: " + goS.getUsername()
		// + "\n \t Message: " + mhdao.findMessagesBySpeaker(goS));
		// System.out.println("findMessagesBySpeaker: " + seaman.getUsername()
		// + "\n \t News" + mhdao.findMessagesBySpeaker(seaman));
		//
		// System.out.println("findNewsByContent(Part of): " + "Shei"
		// + "\n \t Message: " + nhdao.findNewsByContent("Shei"));
		return result;
	}
}
