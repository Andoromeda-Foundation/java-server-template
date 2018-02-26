/**
 * For Business Activities.
 * <p>
 * Copyright 2016 zhongxin, BSS Team. All rights reserved.
 * May not be used without authorization.
 * <p>
 * Create At 2016年8月28日
 */
package com.powerbroker.common.handler;

import com.powerbroker.common.service.CRUDService;
import com.powerbroker.common.service.CRUDServiceAware;
import com.powerbroker.common.service.PageableService;
import com.powerbroker.common.utils.ReflectionUtils;
import com.powerbroker.common.utils.ValueUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.data.domain.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author william
 */
@Slf4j
public abstract class AbstractCRUDHandler<ID, T, S extends CRUDService<ID, T>> extends GenericHandler
        implements CRUDServiceAware<S>, BeanFactoryAware {

    private Class<S> defaultServiceClass;

    @Setter
    private BeanFactory beanFactory;

    @SuppressWarnings("unchecked")
    protected AbstractCRUDHandler() {
        defaultServiceClass = ReflectionUtils.getClassGenricType(getClass(), 2);
    }

    @Override
    public S getService() {
        return beanFactory.getBean("default" + defaultServiceClass.getSimpleName(), defaultServiceClass);
    }

    @PostMapping
    public GenericResponse<T> create(@RequestBody @Valid T request, BindingResult bindingResult) throws Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<T> response) -> {

            response.setData(getService().create(request));
            response.setResult(true);
        });
    }

    @GetMapping(value = "/{id}")
    public GenericResponse<T> retrieve(@PathVariable("id") String id) throws Exception {

        return ControllerTemplate.call((GenericResponse<T> response) -> {

            ID transferId = (ID) ValueUtil.idDecode(id);
            if (null != transferId) {
                response.setData(getService().retrieve(transferId));
            }
            response.setResult(true);
        });
    }

    @PostMapping(value = "/find")
    public GenericResponse<T> retrieve(@RequestBody @Valid T request, BindingResult bindingResult) throws Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<T> response) -> {

            response.setData(getService().retrieveByCondition(request));
            response.setResult(true);
        });
    }

    @PutMapping
    public GenericResponse<Void> update(@RequestBody @Valid T request, BindingResult bindingResult) throws
            Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<Void> response) -> {

            response.setResult(getService().update(request));
        });
    }

    @DeleteMapping(value = "/{id}")
    public GenericResponse<Void> delete(@PathVariable("id") String id) throws Exception {

        return ControllerTemplate.call((GenericResponse<Void> response) -> {

            response.setResult(getService().delete((ID) ValueUtil.idDecode(id)));
        });
    }

    @DeleteMapping
    public GenericResponse<Void> delete() throws Exception {

        return ControllerTemplate.call((GenericResponse<Void> response) -> {

            getService().deleteAll();
            response.setResult(true);
        });
    }

    @GetMapping(value = "/listAll")
    public GenericResponse<List<T>> listAll() throws Exception {

        return ControllerTemplate.call((GenericResponse<List<T>> response) -> {

            List allData = ((PageableService) getService()).listAllActive();
            extractResponse(response, new PageImpl(allData));
        });
    }

    @GetMapping(value = "/listAll/{num}")
    public GenericResponse<List<T>> listAll(@PathVariable(value = "num") Integer num) throws Exception {

        return internalListAll(num, null);
    }

    @GetMapping(value = "/listAll/{num}/{page_size}")
    public GenericResponse<List<T>> listAll(@PathVariable(value = "num") Integer num,
                                            @PathVariable(value = "page_size") Integer pageSize) throws Exception {

        return internalListAll(num, pageSize);
    }

    @GetMapping(value = "/list")
    public GenericResponse<List<T>> list() throws Exception {

        return internalList(null, null);
    }

    @GetMapping(value = "/list/{num}")
    public GenericResponse<List<T>> list(@PathVariable(value = "num") Integer num) throws Exception {

        return internalList(num, null);
    }

    @GetMapping(value = "/list/{num}/{page_size}")
    public GenericResponse<List<T>> list(@PathVariable(value = "num") Integer num,
                                         @PathVariable(value = "page_size") Integer pageSize) throws Exception {
        return internalList(num, pageSize);
    }

    @PostMapping(value = "/search")
    public GenericResponse<List<T>> query(@RequestBody @Valid T request, BindingResult bindingResult) throws
            Exception {

        return internalQuery(null, null, request);
    }

    @PostMapping(value = "/search/{num}")
    public GenericResponse<List<T>> query(@PathVariable(value = "num") Integer num,
                                          @RequestBody @Valid T request, BindingResult bindingResult) throws Exception {
        return internalQuery(num, null, request);
    }

    @PostMapping(value = "/search/{num}/{page_size}")
    public GenericResponse<List<T>> query(@PathVariable(value = "num") Integer num,
                                          @PathVariable(value = "page_size") Integer pageSize,
                                          @RequestBody @Valid T request, BindingResult bindingResult) throws Exception {
        return internalQuery(num, pageSize, request);
    }


    private GenericResponse<List<T>> internalListAll(Integer pageNumber, Integer pageSize) throws Exception {
        return ControllerTemplate.call((GenericResponse<List<T>> response) -> {

            Page<T> data = ((PageableService) getService()).listAll(getPageRequest(pageNumber, pageSize));

            extractResponse(response, data);
        });
    }

    private GenericResponse<List<T>> internalList(Integer pageNumber, Integer pageSize) throws Exception {
        return ControllerTemplate.call((GenericResponse<List<T>> response) -> {

            Page<T> data = ((PageableService) getService()).listActive(getPageRequest(pageNumber, pageSize));

            extractResponse(response, data);
        });
    }

    private GenericResponse<List<T>> internalQuery(Integer pageNumber, Integer pageSize, T request) throws Exception {
        return ControllerTemplate.call((GenericResponse<List<T>> response) -> {

            Page<T> data = ((PageableService) getService()).list(request, getPageRequest(pageNumber, pageSize));

            extractResponse(response, data);
        });
    }

    int defaultPageSize() {
        return 10;
    }

    int defaultPageNumber() {
        return 0;
    }

    protected Pageable getPageRequest(Integer pageNumber, Integer pageSize) {

        return getPageRequest(pageNumber, pageSize, null);
    }

    protected Pageable getPageRequest(Integer pageNumber, Integer pageSize, Sort sort) {

        PageRequest pageRequest;

        if (null == sort) {
            sort = getSort();
        }

        if (null != sort) {
            pageRequest = new PageRequest(setAndGetPageNumber(pageNumber), setAndGetPageSize(pageSize), sort);
        } else {
            pageRequest = new PageRequest(setAndGetPageNumber(pageNumber), setAndGetPageSize(pageSize));
        }
        return pageRequest;
    }


    protected Sort getSort() {
        return null;
    }

    protected int setAndGetPageSize(Integer pageSize) {
        if (null == pageSize) {
            return defaultPageSize();
        } else {
            return pageSize;
        }
    }

    protected int setAndGetPageNumber(Integer pageNumber) {
        if (null == pageNumber) {
            return defaultPageNumber();
        } else {
            if (pageNumber > 0) {
                return pageNumber - 1;
            }
            return pageNumber;
        }
    }
}
