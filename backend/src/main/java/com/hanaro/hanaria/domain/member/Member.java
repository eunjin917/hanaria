package com.hanaro.hanaria.domain.member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "member_created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "member_username")
    String username;
    @Column(name = "member_password")
    String password;
    @Column(name = "member_nickname")
    String nickname;
    @Column(name = "member_role")
    @Builder.Default
    MemberRole role = MemberRole.USER;
    @Column(name = "member_point")
    @Builder.Default
    Integer point = 0;
    @Column(name = "member_tel")
    String tel;
}
