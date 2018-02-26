package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.resource.model.CommentDTO;
import com.powerbroker.resource.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController extends AbstractCRUDHandler<Long, CommentDTO, CommentService> {

}
