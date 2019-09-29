package cn.yunhe.springboot_crud.entity;

//部门

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 一对一
 * 一对多
 * 多对多
 * 部门和员工? 一个部门有多个员工,一个员工只能属于一个部门---一对多
 */
@Entity
@Table
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String departmentName;

	@OneToMany(targetEntity = Employee.class,mappedBy = "department")
	private Set<Employee> employees = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
