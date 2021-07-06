package kr.ac.kopo.kopo08.repository.mapper;

import java.io.Serializable;

public class SampleCondition implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String title;
	private Long id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
