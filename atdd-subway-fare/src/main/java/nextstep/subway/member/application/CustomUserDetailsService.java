package nextstep.subway.member.application;

import nextstep.subway.auth.userdetails.UserDetails;
import nextstep.subway.auth.userdetails.UserDetailsService;
import nextstep.subway.member.domain.EmptyMember;
import nextstep.subway.member.domain.LoginMember;
import nextstep.subway.member.domain.Member;
import nextstep.subway.member.domain.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public LoginMember loadUserByUsername(String email) {
        Member member = memberRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        return LoginMember.of(member);
    }

    @Override
    public UserDetails getEmptyUser() {
        return EmptyMember.getInstance();
    }
}
