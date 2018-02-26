package com.powerbroker.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author william
 */
public interface PageableService<ID, DTO> extends CRUDService<ID, DTO> {

  Page<DTO> listActive(Pageable pageable);

  List<DTO> listAllActive();

  Page<DTO> listAll(Pageable pageable);

  Page<DTO> list(DTO condition, Pageable pageable);
}
