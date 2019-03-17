package com.springPro.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TestInfoDto  implements Serializable{

	private Integer id;

	@NotEmpty(message="name不能为空")
	private String name;
	
	private String gender;
	
	private String hobby;

	@NotNull(message = "年龄不能为空")
    @Min(value = 1, message = "年龄最小1岁")
	private Integer age;

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

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "TestInfo [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", hobby=" + hobby + ", age=" + age + "]";
	}
	
}
