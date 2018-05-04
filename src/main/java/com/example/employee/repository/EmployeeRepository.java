package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  //以下所有的*都代表变量

  //1.查询名字是*的第一个employee
  Employee findOneByName(String name);

  //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息
  Employee findOneByNameLikeAndSalaryGreaterThan(String name, Integer salary);

  //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名
  @Query("select e.name from Employee e where e.salary=(select max(e2.salary) from Employee e2 where e2.companyId=:companyId)")
  String findNameByCompanyIdAndMaxSalary(@Param("companyId") Integer companyId);

  //4.实现对Employee的分页查询，每页两个数据
  Page<Employee> findAll(Pageable pageable);

  //5.查找**的所在的公司的公司名称
  
  @Query("select c.companyName from Company c where c.id = (select e.companyId from Employee e where e.name=:name)")
  String findCompanyNameByEmployeeName(@Param("name") String name);

  //6.将*的名字改成*,输出这次修改影响的行数

  @Modifying
  @Query("update Employee e set e.name=:new where e.name=:old")
  @Transactional
  Integer updateName(@Param("old") String name, @Param("new") String newName);

  //7.删除姓名是*的employee

  void deleteOneByName(String name);

}
