package com.example.distance.repository;

import com.example.distance.model.Distance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistanceRepository extends JpaRepository<Distance, Integer> {
}
