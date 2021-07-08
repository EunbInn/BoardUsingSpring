package kr.ac.kopo.kopo08.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo08.domain.Board;

@Service
public class BoardService {
    public List<Board> showBoards(List<Board> boards) {
        for (Board board : boards) {
            board.setTitle(board.getTitle()
                                .replaceAll(">", "&gt;")
                                .replaceAll("<", "&lt;")
                                .replaceAll("\n", "<br>")
                                .replaceAll(" ", "&nbsp;"));
        }

        return boards;
    }
    
    public Board showBoard(Board board) {
        board.setTitle(board.getTitle()
                            .replaceAll(">", "&gt;")
                            .replaceAll("<", "&lt;")
                            .replaceAll("\n", "<br>")
                            .replaceAll(" ", "&nbsp;"));
    
        return board;
    }
}
