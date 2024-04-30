package com.hanaro.hanaria.domain.member;

import com.hanaro.hanaria.dto.member.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public boolean join(MemberJoinRequestDto dto) {
        Long idx = memberRepository.save(dto.toEntity()).getId();
        return memberRepository.existsById(idx);
    }

    @Transactional
    public boolean create(MemberCreateRequestDto dto) {
        Long idx = memberRepository.save(dto.toEntity()).getId();
        return memberRepository.existsById(idx);
    }

    @Transactional(readOnly = true)
    public Page<MemberFindAllResponseDto> findPage(int page, int limit, String searchType,
                                                   String searchValue, String sortType) {
        Pageable pageable = switch (sortType) {
            case "usernameAsc" -> PageRequest.of(page, limit, Sort.by("username").ascending());
            case "usernameDesc" -> PageRequest.of(page, limit, Sort.by("username").descending());
            case "createdAtAsc" -> PageRequest.of(page, limit, Sort.by("createdAt").ascending());
            case "createdAtDesc" -> PageRequest.of(page, limit, Sort.by("createdAt").descending());
            default -> PageRequest.of(page, limit);
        };
        Page<Member> memberPage = switch (searchType) {
            case "username" -> memberRepository.findAllByUsernameContaining(pageable, searchValue);
            case "nickname" -> memberRepository.findAllByNicknameContaining(pageable, searchValue);
            case "tel" -> memberRepository.findAllByTelContaining(pageable, searchValue);
            default -> memberRepository.findAll(pageable);
        };
        return memberPage.map(MemberFindAllResponseDto::new);
    }

    @Transactional
    public boolean update(MemberUpdateRequestDto dto) {
        Optional<Member> optional = memberRepository.findById(dto.memberId());
        if (optional.isEmpty()) return false;
        memberRepository.save(dto.toApplied(optional.get()));
        return true;
    }

    @Transactional
    public boolean deleteById(Long id) {
        memberRepository.deleteById(id);
        return !memberRepository.existsById(id);
    }

    public MemberFindByIdResponseDto findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        return new MemberFindByIdResponseDto(member);
    }
}
