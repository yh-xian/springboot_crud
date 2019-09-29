package cn.yunhe.springboot_crud.dao;

import cn.yunhe.springboot_crud.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}
