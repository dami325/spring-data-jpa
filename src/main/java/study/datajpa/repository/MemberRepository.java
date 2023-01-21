package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    @Query(name = "Member.findByUsername") /**생략 해도 Member.findByUsername 쿼리 네임을 먼저 찾는다. 이후 없으면 메소드 이름으로 생성 */
    List<Member> findByUsername(@Param("username") String username);
}
