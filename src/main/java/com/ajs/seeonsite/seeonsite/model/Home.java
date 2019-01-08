package com.ajs.seeonsite.seeonsite.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Home {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String location;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner;

	@OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
	private Set<Image> images;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Boolean getIsApplied() {
		return isApplied;
	}

	public void setIsApplied(Boolean isApplied) {
		this.isApplied = isApplied;
	}

	@CreatedDate
	private Date postedOn;

	private Boolean isApplied;

	public Home() {

	}

}