package kr.ac.kopo.kopo08.service;

import org.springframework.data.domain.Page;

import kr.ac.kopo.kopo08.domain.BoardItem;

public class PageCal {
    private int startPage;
    private int endPage;
    private int totalPage;
    private boolean nextPage;
    private boolean prevPage;
    
    public PageCal(Page<BoardItem> page) {
        this.startPage = 1;
        this.endPage = 10;
        this.totalPage = page.getTotalPages();
        this.nextPage;
        this.prevPage;
        
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

}
