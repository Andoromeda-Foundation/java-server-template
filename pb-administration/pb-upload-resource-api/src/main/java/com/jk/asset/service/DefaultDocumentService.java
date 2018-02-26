package com.jk.asset.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.jk.asset.dao.DocumentDAO;
import com.jk.asset.entity.Document;
import com.jk.asset.model.DocumentDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultDocumentService extends AbstractJPAService<Long, DocumentDTO, Document, DocumentDAO> implements
        DocumentService {

    @Value("${file.uploadedFolder}")
    private String uploadedFolder;

    @Override
    public DocumentDTO upload(List<MultipartFile> files) {

        DocumentDTO documentDTO = null;

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue;
            }
            try {
                byte[] bytes = file.getBytes();
                String checksum = DigestUtils.md5Hex(bytes);
                String originalFileName = file.getOriginalFilename();
                String savedName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(originalFileName);
                String savedPath = String.join("/", uploadedFolder, savedName);
                Path path = Paths.get(savedPath);
                Files.write(path, bytes);

                documentDTO = new DocumentDTO();
                documentDTO.setOriginName(originalFileName);
                documentDTO.setSavedName(savedName);
                documentDTO.setContentType(file.getContentType());
                documentDTO.setLength(file.getSize());
                documentDTO.setChecksum(checksum);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return documentDTO;
    }
}