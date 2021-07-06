package kr.ac.kopo.kopo08.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    //fetch type이 Lazy로 되어있으면 늦게 가져옴 느긋하게 eager은 바로
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "board")
    private List<BoardItem> boardItems;

    public Board() {
    }
    
    public Board(Long id) {
        this.id = id;
    }

    public Board(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Board(String title) {
        this.title = title;
    }

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

	public List<BoardItem> getBoardItems() {
		return boardItems;
	}

	public void setBoardItems(List<BoardItem> boardItem) {
		this.boardItems = boardItem;
	}

}
