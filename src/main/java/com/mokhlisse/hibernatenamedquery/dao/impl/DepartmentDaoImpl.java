package com.mokhlisse.hibernatenamedquery.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mokhlisse.hibernatenamedquery.dao.DepartmentDao;
import com.mokhlisse.hibernatenamedquery.model.Department;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long getTotalDept() {
		Session session = sessionFactory.getCurrentSession();
		Optional<Long> totalDept = session.createNamedQuery("@SQL_GET_TOTAL_DEPT", Long.class).uniqueResultOptional();
		if (totalDept.isPresent()) {
			return totalDept.get();
		} else {
			return 0;
		}
	}

	@Override
	public String getDeptNameById(int id) throws DepartmentNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Query<String> query = session.createNamedQuery("@HQL_GET_DEPT_NAME_BY_ID", String.class);
		query.setParameter("id", id);
		Optional<String> names = query.uniqueResultOptional();

		if (names.isPresent()) {
			return names.get();
		} else {
			throw new DepartmentNotFoundException("no department with id=" + id);
		}
	}

	@Override
	public List<Department> getAllDepartement() {

		Session session = sessionFactory.getCurrentSession();
		Query<Department> query = session.createNamedQuery("@HQL_GET_ALL_DEPT", Department.class);
		List<Department> departments = query.getResultList();

		return departments;
	}

}
