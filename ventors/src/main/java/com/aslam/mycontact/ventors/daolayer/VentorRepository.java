package com.aslam.mycontact.ventors.daolayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentorRepository extends JpaRepository<Ventor,Integer> {

    public Optional<Ventor> findByemail(String email);
}
