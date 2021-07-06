package kr.ac.kopo.kopo08.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //테이블 취급을 해주는 어노테이션
public class Sample {

	@Id //pk의미
	@GeneratedValue //auto increment 쓰겠음
	@Column
	private Long id;

	@Column
	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
