package com.encore.bbs.comment.service;

import com.encore.bbs.comment.mapper.CommentMapper;
import com.encore.bbs.comment.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    //추후 게시판 mapper을 추가해야 함. ----------

    @Override
    public List<CommentDTO> getCommentsByBbsId(Long bbsId) {
        return commentMapper.getCommentsByBbsId(bbsId);
    }

    @Override
    @Transactional
    public void addComment(CommentDTO commentDTO) {
        commentMapper.addComment(commentDTO);
    }

    @Override
    @Transactional
    public void updateComment(Long commentId, CommentDTO commentDTO) {
        CommentDTO existingComment = commentMapper.findCommentById(commentId);

        if (existingComment != null) {  // 기존댓글이 존재한다면 , dto와 db update
            commentDTO.setCommentId(commentId);
            commentMapper.updateComment(commentDTO);
        }
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentMapper.deleteComment(commentId);
    }

    @Override
    public int countAllComments() {
        return commentMapper.countAllComments();
    }

    @Override
    public CommentDTO findCommentById(Long commentId) {
        return commentMapper.findCommentById(commentId);
    }
}
