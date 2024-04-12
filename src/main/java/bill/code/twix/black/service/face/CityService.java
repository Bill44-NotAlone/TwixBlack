package bill.code.twix.black.service.face;

import bill.code.twix.black.entity.City;
import bill.code.twix.black.modles.CityModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {

    public List<CityModel> getAll();

    public boolean addCity(CityModel city);

    public boolean deleteCityById(Integer id);

    public boolean deleteCity(CityModel city);
}
