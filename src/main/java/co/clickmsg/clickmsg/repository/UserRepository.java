/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.clickmsg.clickmsg.repository;

import co.clickmsg.clickmsg.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tomide
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    public User findByEmail(String email);
    
}
