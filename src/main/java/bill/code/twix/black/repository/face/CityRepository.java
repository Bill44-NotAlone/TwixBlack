package bill.code.twix.black.repository.face;

import bill.code.twix.black.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

    List<City> findAll();
}
