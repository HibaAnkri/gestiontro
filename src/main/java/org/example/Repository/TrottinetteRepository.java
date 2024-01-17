package org.example.Repository;

import org.example.Entity.Trottinette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrottinetteRepository extends JpaRepository<Trottinette,Long> {

}
