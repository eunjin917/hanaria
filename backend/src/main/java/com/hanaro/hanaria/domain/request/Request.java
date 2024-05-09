package com.hanaro.hanaria.domain.request;

import com.hanaro.hanaria.domain.group.Group;
import com.hanaro.hanaria.domain.group.GroupCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@Table(name = "request")
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long request_id;
    @Column(name = "request_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "request_body")
    String body;
    @ManyToOne
    @Column(name = "group_id")
    Group groupId;
    @Column(name = "group_category")
    GroupCategory groupCategory;
    @Column(name = "request_bit")
    Long bit;
}
