package cn.yunhe.springboot_crud.dao;

import cn.yunhe.springboot_crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
