package com.powerbroker.resource.service;

import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.PowerStationDAO;
import com.powerbroker.resource.dao.UserDAO;
import com.powerbroker.resource.entity.District;
import com.powerbroker.resource.entity.PowerStation;
import com.powerbroker.resource.entity.Role;
import com.powerbroker.resource.entity.User;
import com.powerbroker.resource.model.PowerStationDTO;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author william
 */
@Service
@Transactional
public class DefaultPowerStationService extends AbstractJPAService<Long, PowerStationDTO, PowerStation, PowerStationDAO> implements PowerStationService {

    @Resource
    private UserDAO userDAO;

    @Override
    public List<PowerStationDTO> listAllActive() {

        User currentUser = userDAO.findOne(getCurrentAuthUserId());

        boolean isAdmin = false;

        if (!CollectionUtils.isEmpty(currentUser.getRoles())) {
            for (Role role : currentUser.getRoles()) {
                if (null != role.getAdmin() && role.getAdmin()) {
                    isAdmin = true;
                    break;
                }
            }
        }

        if (isAdmin) {
            return super.listAllActive();
        } else {

            Set<District> districts = currentUser.getStaff().getDistricts();

            PowerStation probe = new PowerStation();
            probe.setDistricts(districts);
            Example<PowerStation> example = Example.of(probe);
            List<PowerStationDTO> data = dao.findAll(example).stream()
                    .map(entity -> ValueUtil.dump(entity, dtoClass))
                    .collect(Collectors.toList());


//            Set<PowerStation> powerStations = new HashSet<>();
//
//            if (!CollectionUtils.isEmpty(districts)) {
//                for (District district : districts) {
//                    powerStations.addAll(district.getPowerStations());
//                }
//            }
//
//            return new PageImpl<>(new ArrayList<>(powerStations)).map(entity -> ValueUtil
//                    .dump(entity, dtoClass)).getContent();
            return data;
        }
    }
}
