package com.mooc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name = "session")
@Entity
public class Session implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	
	private Date startDate;
	private Date endDate;
	@OneToOne(mappedBy="session")
	private Trainer trainer;
	private List <Learner> learners;
	private String description;
	
	private List<CourseOfSession> coursesOfSession;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@OneToMany(mappedBy = "session",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	public List<CourseOfSession> getCoursesOfSession() {
		return coursesOfSession;
	}
	public void setCoursesOfSession(List<CourseOfSession> coursesOfSession) {
		this.coursesOfSession = coursesOfSession;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	public List <Learner> getLearners() {
		return learners;
	}
	public void setLearners(List <Learner> learners) {
		this.learners = learners;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

}