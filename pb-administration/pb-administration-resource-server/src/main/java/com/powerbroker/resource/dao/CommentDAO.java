package com.powerbroker.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.powerbroker.resource.entity.Comment;

/**
 * @author william
 */
@Repository
public interface CommentDAO extends JpaRepository<Comment, Long> {
}
