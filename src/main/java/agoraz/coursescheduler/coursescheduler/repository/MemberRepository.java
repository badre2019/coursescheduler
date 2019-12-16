package agoraz.coursescheduler.coursescheduler.repository;

import agoraz.coursescheduler.coursescheduler.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
