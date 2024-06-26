package com.edu.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.database.SqlSessionFactoryManager;

public class Mybatis_JUnitTest {

	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
		
		
	}

}
