package com.catchmycode.ezstep.data.dao;

import com.catchmycode.ezstep.data.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface TesterRepo extends JpaRepository<Tester, Long> {
}
