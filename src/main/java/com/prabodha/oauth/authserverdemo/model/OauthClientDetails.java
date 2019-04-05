package com.prabodha.oauth.authserverdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value ={"createdAt","updatedAt","createdBy","updatedBy"},allowGetters = true)
@Table(name = "oauth_client_details")
public class OauthClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;

    @Column(name = "scope")
    private String scope;

    @Column(name = "access_token_validity")
    private int accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private int refreshTokenValidity;

    @Column(name = "resource_ids")
    private String resourceIds;

    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "autoapprove")
    private String autoApprove;

    @Column(name = "created_at",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    public OauthClientDetails() {
    }

    public OauthClientDetails(OauthClientDetails clientDetails) {
        this.clientId = clientDetails.getClientId();
        this.clientSecret = clientDetails.getClientSecret();
        this.webServerRedirectUri = clientDetails.getWebServerRedirectUri();
        this.scope = clientDetails.getScope();
        this.accessTokenValidity = clientDetails.getAccessTokenValidity();
        this.refreshTokenValidity = clientDetails.getRefreshTokenValidity();
        this.resourceIds = clientDetails.getResourceIds();
        this.authorizedGrantTypes = clientDetails.getAuthorizedGrantTypes();
        this.authorities = clientDetails.getAuthorities();
        this.additionalInformation = clientDetails.getAdditionalInformation();
        this.autoApprove = clientDetails.getAutoApprove();

    }

    @Override
    public String toString() {
        return "OauthClientDetails{" +
                "client_id='" + clientId + '\'' +
                ", client_secret=" + clientSecret + '\'' +
                ", web_server_redirect_uri=" + webServerRedirectUri + '\'' +
                ", scope='" + scope + '\'' +
                ", access_token_validity='" + accessTokenValidity + '\'' +
                ", refresh_token_validity'" + refreshTokenValidity + '\'' +
                ", resource_ids=" + resourceIds + '\'' +
                ", authorized_grant_types='" + authorizedGrantTypes + '\'' +
                ", authorities='" + authorities + '\'' +
                ", additional_information'" + additionalInformation + '\'' +
                ", autoapprove'" + autoApprove + '\'' +
                ", createdAt=" + createdAt + '\'' +
                ", updatedAt=" + updatedAt + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
