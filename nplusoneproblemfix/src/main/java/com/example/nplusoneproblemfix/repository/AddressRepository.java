package com.example.nplusoneproblemfix.repository;

import com.example.nplusoneproblemfix.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {}

