package com.origin.cafe.repository;

import com.origin.cafe.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUsernameAndEnabled(String username, Byte enabled);

	Optional<User> findByMemberMemNo(int memno);
}
