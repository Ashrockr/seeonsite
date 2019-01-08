package com.ajs.seeonsite.seeonsite.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Image {

	@Id
	private Long id;

	private String name;

	private String type;

	@Lob
	private byte[] pic;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "home_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Home home;

	public Image() {
	}

	public Image(long id, String name, String type, byte[] pic) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.pic = pic;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
}
