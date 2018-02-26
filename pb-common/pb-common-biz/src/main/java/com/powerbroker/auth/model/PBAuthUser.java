package com.powerbroker.auth.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.*;

/**
 * @author william
 */
public class PBAuthUser extends User {

    public PBAuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public PBAuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private Integer type;

    @Setter
    @Getter
    private List<Long> roleIds = new ArrayList<>();

    @Setter
    @Getter
    private Map<String, Object> extra = new HashMap<>();
}
