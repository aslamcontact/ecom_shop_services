package com.aslam.mycontact.ventors.daolayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentorRepository extends JpaRepository<Ventor,Integer> {
}
