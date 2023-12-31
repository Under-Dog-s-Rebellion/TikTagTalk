package A109.TikTagTalk.domain.user.repository;

import A109.TikTagTalk.domain.user.entity.Member;
import A109.TikTagTalk.domain.user.entity.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserId(String userId);

    Optional<Member> findByRefreshToken(String refreshToken);

    /*
    * 소셜 타입과 소셜의 식별값으로 회원 찾는 메소드
    * 정보 제공을 동의한 순간 DB에 저장해야 하지만, 아직 추가 정보(userId,name, introduction)를 입력받지 않았으므로
    * 우저 객체는 DB에 있지만, 추가 정보가 빠진 상태이다.
    * 따라서 추가 정보를 입력받아 회원 가입을 진행할 때 소셜 타입, 식별자로 해당 회원을 찾기 위한 메소드
    */
    Optional<Member> findBySocialTypeAndSocialId(SocialType socialType, String socialId);

    @Query("SELECT m FROM Member m " +
            "WHERE m.userId LIKE :userId%")
    List<Member> findBySubUserId(@Param("userId") String userId);

    @Transactional
    @Modifying
    @Query("update Member m set m.point = :balancePoint where m.id = :id")
    void updateBalancePoint(@Param("id") Long id, @Param("balancePoint") int balancePoint);
}
