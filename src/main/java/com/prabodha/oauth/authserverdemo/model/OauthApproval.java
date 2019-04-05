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
@Table(name = "oauth_approvals")
public class OauthApproval {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oauth_approvals_id")
    private int oauthApprovalsId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "scope")
    private String scope;

    @Column(name = "status")
    private String status;

    @Column(name = "clientId")
    private String clientId;

    @Column(name = "expires_at")
    private Date expiresAt;

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


    public OauthApproval() {
    }

    public OauthApproval(OauthApproval oauthApproval) {
        this.userId = oauthApproval.getUserId();
        this.scope = oauthApproval.getScope();
        this.status = oauthApproval.getStatus();
        this.clientId = oauthApproval.getClientId();
        this.expiresAt = oauthApproval.getExpiresAt();

    }

    @Override
    public String toString() {
        return "OauthApproval{" +
                "oauth_approvals_id=" + oauthApprovalsId + '\'' +
                ", user_id=" + userId + '\'' +
                ", scope=" + scope + '\'' +
                ", status='" + status + '\'' +
                ", client_id='" + clientId + '\'' +
                ", expires_at'" + expiresAt + '\'' +
                ", createdAt=" + createdAt + '\'' +
                ", updatedAt=" + updatedAt + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
