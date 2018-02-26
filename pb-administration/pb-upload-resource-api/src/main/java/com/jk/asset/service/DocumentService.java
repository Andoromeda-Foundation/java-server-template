package com.jk.asset.service;

import com.powerbroker.common.service.PageableService;
import com.jk.asset.model.DocumentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author william
 */
public interface DocumentService extends PageableService<Long, DocumentDTO> {

    DocumentDTO upload(List<MultipartFile> files);
}