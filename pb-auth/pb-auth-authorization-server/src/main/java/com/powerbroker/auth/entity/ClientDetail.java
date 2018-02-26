package com.powerbroker.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author william
 */
@Entity
@Setter
@Getter
@Table(name = "client_details")
public class ClientDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;

    private String clientSecret;

    private String resourceIds;

    private String scope;

    private String authorizedGrantTypes;

    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectURI;

    private String authorities;

    private int accessTokenValidity;

    private int refreshTokenValidity;

    private String additionalInformation;

    private String autoApprove;
}
