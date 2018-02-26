package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.resource.model.TraceDTO;
import com.powerbroker.resource.service.TraceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/tracing")
public class TraceController extends AbstractCRUDHandler<Long, TraceDTO, TraceService> {

    @PostMapping(value = "/latest")
    public GenericResponse<TraceDTO> latest(@RequestBody @Valid TraceDTO request, BindingResult bindingResult) throws Exception {

        return ControllerTemplate.call((GenericResponse<TraceDTO> response) -> {

            Page<TraceDTO> list = getService().list(request, getPageRequest(null, 1));
            if (!CollectionUtils.isEmpty(list.getContent())) {
                response.setData(list.getContent().get(0));
            }
            response.setResult(true);
        });
    }

    @Override
    protected Sort getSort() {
        return new Sort(Sort.Direction.DESC, "committedAt");
    }
}
