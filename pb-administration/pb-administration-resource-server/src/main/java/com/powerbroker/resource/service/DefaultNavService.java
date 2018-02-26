package com.powerbroker.resource.service;

import com.powerbroker.auth.model.PBAuthUser;
import com.powerbroker.common.service.AbstractJPAService;
import com.powerbroker.common.utils.ValueUtil;
import com.powerbroker.resource.dao.NavDAO;
import com.powerbroker.resource.entity.Nav;
import com.powerbroker.resource.model.LightSidebarDTO;
import com.powerbroker.resource.model.NavDTO;
import com.powerbroker.resource.model.RoleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author william
 */
@Slf4j
@Service
@Transactional
public class DefaultNavService extends AbstractJPAService<Long, NavDTO, Nav, NavDAO> implements NavService {

    @Resource
    private RoleService roleService;

    @Transactional(readOnly = true)
    public Page<NavDTO> listActive(Pageable pageable) {

        PBAuthUser authUser = (PBAuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Long roleId = authUser.getRoleIds().get(0);

        RoleDTO roleDTO = roleService.retrieve(roleId);

        Set<String> sidebarIds = new HashSet<>();

        for (LightSidebarDTO sidebarDTO : roleDTO.getSidebars()) {
            sidebarIds.add(sidebarDTO.getId());
        }

        List<NavDTO> navDTOs = roleDTO.getNavs().stream().sorted(Comparator.comparing(e -> ValueUtil.idDecode(e.getId()))).collect(Collectors.toList());

        navDTOs = navDTOs.stream().map(navDTO -> {
            List<LightSidebarDTO> filteredSidebarDTOS = navDTO.getSidebars().stream().filter(lightSidebarDTO -> sidebarIds.contains(lightSidebarDTO.getId())).collect(Collectors.toList());
            navDTO.setSidebars(filteredSidebarDTOS);
            return navDTO;
        }).collect(Collectors.toList());

        return new PageImpl<>(navDTOs);
    }
}
