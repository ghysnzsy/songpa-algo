package com.songpa.songpaalgo.board.repository;

import com.songpa.songpaalgo.board.domain.User;
import com.songpa.songpaalgo.board.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;
    
    public void save(User user) {
        em.persist(user);//persist가 commit
    }
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }
    public User findOne(Long id) {
        return em.find(User.class, id);//PK
    }
    public User findByUserId(String userid) {
        return em.createQuery("select u from User u where u.userid = :userid",User.class)
                 .setParameter("userid", userid)
                 .getSingleResult();
    }
}
