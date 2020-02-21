package com.example.demo.Repository;



import com.example.demo.Model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.List;

@Repository
public interface SeriesJpaRepository extends JpaRepository<Series, Long> {
    //public void updateSeries(Long id, String name, Integer numberOS, double rate, String description);
}
