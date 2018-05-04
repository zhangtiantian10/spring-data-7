package com.example.employee.entity;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private String gender;

  private Integer age;

  private Integer salary;

  private Integer companyId;

  public Employee(String name, Integer age, String gender, Integer salary, Integer companyId, Integer id) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.age = age;
    this.salary = salary;
    this.companyId = companyId;
  }

  public Employee() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }
}
