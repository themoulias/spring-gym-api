package com.themis.membership;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipRepository extends CrudRepository<Membership, Long> {
    Optional<Membership> findMembershipById(Long id);
}
