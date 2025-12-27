package com.examly.springapp.repository;

import com.examly.springapp.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {

    List<Profile> findByFirstName(String firstName);

    List<Profile> findByFirstNameAndAddress(String firstName, String address);
}
