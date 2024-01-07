package com.encore.bbs.comment.controller;

import com.encore.bbs.comment.dto.CommentDTO;
import com.encore.bbs.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/save")
    public String saveComment(CommentDTO commentDTO) {
        commentService.addComment(commentDTO);
        return "성공";
        // return "redirect:/board/detail/?bbsId=" + commentDTO.getBbsId(); // 댓글 추가 후 해당 게시글 상세 페이지로 리다이렉트
    }

    @PostMapping("/save")
    public ResponseEntity save(CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);

        try {
            commentService.addComment(commentDTO);

            // 댓글 작성 성공하면 댓글 목록을 가져와서 리턴
            List<CommentDTO> commentDTOList = commentService.getCommentsByBbsId(commentDTO.getBbsId());
            return new ResponseEntity<>(commentDTOList, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            // 해당 게시글이 존재하지 않는 경우
            return new ResponseEntity<>("해당 게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // 댓글 작성 실패 시 예외 처리
            return new ResponseEntity<>("댓글 작성에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //조회 - 상세페이지/목록보이기
    @GetMapping("/list/{bbsId}")
    public List<CommentDTO> getCommentsByBbsId(@PathVariable Long bbsId) {
        return commentService.getCommentsByBbsId(bbsId);
    }

    //수정
    @PostMapping("/update/{commentId}")
    @ResponseBody //http
    public ResponseEntity<String> updateComment(@PathVariable Long commentId, @RequestBody CommentDTO commentDTO) {
        try {
            commentService.updateComment(commentId, commentDTO);
            return new ResponseEntity<>("수정완료", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("수정에러", HttpStatus.BAD_REQUEST);
        }
    }

    //삭제
    @PostMapping("/delete/{commentId}")
    @ResponseBody
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);

        return "redirect:/board/";
    }

}
