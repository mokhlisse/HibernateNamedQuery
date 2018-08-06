package com.mokhlisse.hibernatenamedquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.mokhlisse.hibernatenamedquery.config.PersistenceConfig;
import com.mokhlisse.hibernatenamedquery.dao.DepartmentDao;
import com.mokhlisse.hibernatenamedquery.dao.impl.DepartmentNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class HibernateNamedQueryApplicationTests {

	@Autowired
	private DepartmentDao departmentDao;

	@Test
	@Ignore
	public void namedQueryTest() {

		assertTrue(departmentDao.getTotalDept() == 2);
	}

	@Test
	@Ignore
	public void getDeptNameByIdTest() throws DepartmentNotFoundException {

		assertEquals("Software Development", departmentDao.getDeptNameById(1));
	}

	@Test(expected = DepartmentNotFoundException.class)
	@Ignore
	public void getDeptNameByIdUnmatchedTest() throws DepartmentNotFoundException {
		departmentDao.getDeptNameById(0);
		
	}
	
	@Test
	public void getAllDepartementTest(){
		
		System.out.println(departmentDao.getAllDepartement());
	}

}
