package com.powerbroker.resource.controller;

import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.model.BulletinDTO;
import com.powerbroker.resource.model.BulletinStateDTO;
import com.powerbroker.resource.service.BulletinService;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/bulletin")
public class BulletinController extends AbstractCRUDHandler<Long, BulletinDTO, BulletinService> {

    @PostMapping("/read")
    public GenericResponse<Void> read(@RequestBody @Valid BulletinDTO request, BindingResult bindingResult) throws Exception {

        return ControllerTemplate.call(bindingResult, (GenericResponse<Void> response) -> {

            getService().read(ValueUtil.idDecode(request.getId()));
            response.setResult(true);
        });
    }

    @GetMapping("/state")
    public GenericResponse<BulletinStateDTO> state() throws Exception {

        return ControllerTemplate.call((GenericResponse<BulletinStateDTO> response) -> {
            response.setData(getService().state());
            response.setResult(true);
        });
    }

    protected Sort getSort() {
        return new Sort(Sort.Direction.DESC, "createAt");
    }
}
