package com.vdotnode.performanceproduct.lead.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vdotnode.performanceproduct.lead.domain.Lead;


public interface LeadRepository extends JpaRepository<Lead, Long> {

}
