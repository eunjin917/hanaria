package com.hanaro.hanaria.domain.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsernameAndPassword(String s, String s1);

    boolean existsByUsername(String username);

    Optional<Member> findByNicknameAndTel(String nickname, String tel);

    Optional<Member> findByNicknameAndTelAndUsername(String nickname, String tel, String Username);

    Page<Member> findAllByUsernameContaining(Pageable pageable, String searchValue);

    Page<Member> findAllByNicknameContaining(Pageable pageable, String searchValue);

    Page<Member> findAllByTelContaining(Pageable pageable, String searchValue);
}
