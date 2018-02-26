package com.powerbroker.auth.service;

import com.powerbroker.auth.dao.ClientDAO;
import com.powerbroker.auth.dao.UserDAO;
import com.powerbroker.auth.entity.Client;
import com.powerbroker.auth.entity.Hierarchy;
import com.powerbroker.auth.entity.Role;
import com.powerbroker.auth.entity.User;
import com.powerbroker.auth.model.PBAuthUser;
import com.powerbroker.common.utils.StringUtil;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author william
 */
@Service("pbAuthUserDetailsService")
public class PBAuthUserDetailsService implements UserDetailsService {

    @Resource
    private UserDAO userDAO;

    @Resource
    private ClientDAO clientDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String clientId = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            clientId = authentication.getName();
        }

        PBAuthUser pbAuthUser;
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (StringUtil.hasText(clientId) && clientId.equalsIgnoreCase("bss-and-service")) {
            Client client = clientDAO.findByUsername(username);
            authorities.addAll(buildClientAuthority(client.getHierarchies()));
            pbAuthUser = buildForClientAuthentication(client, authorities);
        } else {
            User user = userDAO.findByUsername(username);
            authorities.addAll(buildUserAuthority(user.getRoles()));
            pbAuthUser = buildForUserAuthentication(user, authorities);
        }

        return pbAuthUser;
    }

    private PBAuthUser buildForUserAuthentication(User user,
                                                  List<GrantedAuthority> authorities) {
        PBAuthUser pbAuthUser = new PBAuthUser(user.getUsername(), user.getPassword(),
                true, true, true, true, authorities);
        pbAuthUser.setId(user.getId());
        pbAuthUser.setRoleIds(user.getRoles().stream().map(role -> role.getId()).collect(Collectors.toList()));
        pbAuthUser.setType(1);
        return pbAuthUser;
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {

        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.addAll(roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));

        List<GrantedAuthority> result = new ArrayList<>(authorities);

        return result;
    }

    private PBAuthUser buildForClientAuthentication(Client client,
                                                    List<GrantedAuthority> authorities) {
        PBAuthUser pbAuthUser = new PBAuthUser(client.getUsername(), client.getPassword(),
                true, true, true, true, authorities);
        pbAuthUser.setId(client.getId());
        pbAuthUser.setRoleIds(client.getHierarchies().stream().map(hierarchies -> hierarchies.getId()).collect
                (Collectors.toList
                        ()));
        pbAuthUser.setType(2);
        return pbAuthUser;
    }

    private List<GrantedAuthority> buildClientAuthority(Set<Hierarchy> hierarchies) {

        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.addAll(hierarchies.stream().map(hierarchy -> new SimpleGrantedAuthority(hierarchy.getName())).collect(Collectors.toList()));

        List<GrantedAuthority> result = new ArrayList<>(authorities);

        return result;
    }
}
