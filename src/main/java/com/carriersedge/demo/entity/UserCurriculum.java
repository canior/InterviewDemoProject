package com.carriersedge.demo.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user_curriculum")
public class UserCurriculum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "created", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id")
	private Carrier carrier;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
	private Curriculum curriculum;
	
	@Column(name = "username")
	private String username;
	
	public UserCurriculum() {
		Calendar calendar = Calendar.getInstance();
		this.setCreated(calendar.getTime());
	}
	
	/**
	 * 
	 * @param user
	 * @param curriculum
	 * @param createdBy
	 */
	public UserCurriculum(User user, Curriculum curriculum, User createdBy) {
		this();
		this.setUsername(user.getUsername());
		this.setCurriculum(curriculum);
		this.setCreatedBy(createdBy.getUsername());
		this.setCarrier(createdBy.getCarrier());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserCurriculum [created=" + created + ", carrier=" + carrier + ", createdBy=" + createdBy
				+ ", curriculum=" + curriculum + ", username=" + username + "]";
	}
}
