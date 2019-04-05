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
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken {


    @Column(name = "token")
    private Long token;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "authentication")
    private Long authentication;

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

    public OauthRefreshToken() {
    }

    public OauthRefreshToken(OauthRefreshToken refreshToken) {
        this.token = refreshToken.getToken();
        this.tokenId = refreshToken.getTokenId();
        this.authentication = refreshToken.getAuthentication();
    }

    @Override
    public String toString() {
        return "OauthRefreshToken{" +
                "refresh_token_id='" + tokenId + '\'' +
                ", refresh_token=" + token + '\'' +
                ", authentication=" + authentication + '\'' +
                ", createdAt=" + createdAt + '\'' +
                ", updatedAt=" + updatedAt + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}