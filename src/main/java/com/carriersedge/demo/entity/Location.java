package com.carriersedge.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")	
	private String name;

	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
        name = "location_curriculum", 
        joinColumns = { @JoinColumn(name = "location_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "curriculum_id") }
    )
    Set<Curriculum> curriculums;
	
	
	public Location() {
		this.setCurriculums(new HashSet<Curriculum>());
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Curriculum> getCurriculums() {
		return curriculums;
	}


	public void setCurriculums(Set<Curriculum> curriculums) {
		this.curriculums = curriculums;
	}

	
	public void addCurriculum(Curriculum curriculum) {
		this.curriculums.add(curriculum);
	}
	

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", curriculums=" + curriculums + "]";
	}
	
}
