package com.example.milahan;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
class User{

  @Id 
  @Column(name="user_id")
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
  private Integer id;
  @Column(name="user_name")
  private String name;
  @Column(name="email", nullable = false, unique = true)
  private String email;
  @Column(name="user_role")
  private Integer role;
  @Column(name="password")
  private String password;

  User() {}

  User(String name, String email, Integer role, String password) {
    this.name = name;
    this.email = email;
    this.role = role;
    this.password = password;
  }
  
  public String getPassword() {
	return password;
  }
	
	public void setPassword(String password) {
		this.password = password;
	}

  public String getEmail() {
	return this.email;
  }

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return this.id;
	}

  public String getName() {
    return this.name;
  }

  public Integer getRole() {
    return this.role;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof User))
      return false;
    User employee = (User) o;
    return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name) && Objects.equals(this.email, employee.email)
        && Objects.equals(this.role, employee.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name,this.email, this.role);
  }

  @Override
  public String toString() {
    return "User{" + "id=" + this.id + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' +  ", role='" + this.role + '\'' + '}';
  }
}