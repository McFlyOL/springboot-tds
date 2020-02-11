package s4.spring.td2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.td2.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Integer> {
    List<Groupe> findByName(String name);
    Groupe findById(int id);
    List<Groupe> findByAliases(String aliases);
    List<Groupe> findByEmail(String email);

}