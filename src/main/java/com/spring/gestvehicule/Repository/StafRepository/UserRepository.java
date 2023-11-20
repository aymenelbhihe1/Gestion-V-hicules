package com.spring.gestvehicule.Repository.StafRepository;
import com.spring.gestvehicule.Model.Staf.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
