package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("select t from Token t inner join User u on t.user.id=u.id where u.id = :id and (t.expired = false or t.revoked = false)")
    List<Token> findAllValidTokenByUserId(Long id);

    Optional<Token> findByToken(String token);
}