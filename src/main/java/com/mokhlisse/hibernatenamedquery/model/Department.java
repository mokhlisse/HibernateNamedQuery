package com.mokhlisse.hibernatenamedquery.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity(name = "department")
@NamedQueries({ @NamedQuery(name = "@SQL_GET_TOTAL_DEPT", query = "select count(1) from department"),
		@NamedQuery(name = "@HQL_GET_DEPT_NAME_BY_ID", query = "SELECT d.name FROM department d WHERE d.id=:id"),
		@NamedQuery(name = "@HQL_GET_ALL_DEPT", query = "FROM department") })
public class Department {

	@Id
	@Column(name = "dpt_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private int dptId;
	@NonNull
	private String name;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "department")
	private List<Employee> employees = new ArrayList<>();

	public int getDptId() {
		return dptId;
	}

	public void setDptId(int dptId) {
		this.dptId = dptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [dptId=" + dptId + ", name=" + name + ", employees=" + employees + "]";
	}
}
