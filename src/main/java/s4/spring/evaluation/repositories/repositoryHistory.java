  
package s4.spring.evaluation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.evaluation.models.History;

import java.util.List;

public interface repositoryHistory extends JpaRepository<History, Integer>
{
    List<History> findAll();
    History findById(int id);
    List<History> findByDate(String date);
    List<History> findByContent(String content);
    List<History> findByComment(String comment);
}