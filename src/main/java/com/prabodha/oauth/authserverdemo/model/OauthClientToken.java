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
@Table(name = "oauth_client_token")
public class OauthClientToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "authentication_id")
    private String authenticationId;

    @Column(name = "token", length = 1000)
    private String token;

    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "user_name")
    private String username;

    @Column(name = "client_id")
    private String clientId;

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

    public OauthClientToken() {
    }

    public OauthClientToken(OauthAccessToken accessToken) {
        this.authenticationId = accessToken.getAuthenticationId();
        this.token = accessToken.getToken();
        this.tokenId = accessToken.getTokenId();
        this.username = accessToken.getUsername();
        this.clientId = accessToken.getClientId();

    }

    @Override
    public String toString() {
        return "OauthClientToken{" +
                "authentication_id='" + authenticationId + '\'' +
                ", client_token_id=" + tokenId + '\'' +
                ", client_token=" + token + '\'' +
                ", username='" + username + '\'' +
                ", client_id='" + clientId + '\'' +
                ", createdAt=" + createdAt + '\'' +
                ", updatedAt=" + updatedAt + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
