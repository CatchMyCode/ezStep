package com.catchmycode.ezstep.data.dao;

import com.catchmycode.ezstep.data.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StepRepo extends JpaRepository<Step, Long> {
}
