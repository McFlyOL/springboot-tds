package s4.spring.td2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.td2.entities.*;

public interface OrgaRepository extends JpaRepository<Organization, Integer> {

    Organization findById(int id);
    List<Organization> findByName(String name);
}