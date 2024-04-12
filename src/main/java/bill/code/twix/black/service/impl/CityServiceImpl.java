package bill.code.twix.black.service.impl;

import bill.code.twix.black.entity.City;
import bill.code.twix.black.modles.CityModel;
import bill.code.twix.black.repository.face.CityRepository;
import bill.code.twix.black.service.face.CityService;
import bill.code.twix.black.util.MapperUtil;
import com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final ModelMapper mapper;

    public CityServiceImpl(CityRepository cityRepository, ModelMapper mapper) {
        this.cityRepository = cityRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CityModel> getAll() {
        List<City> cities = cityRepository.findAll();
        return MapperUtil.mapList(cities, CityModel.class, mapper);
    }

    @Override
    public boolean addCity(CityModel city) {
        City addedCity = mapper.map(city, City.class);
        cityRepository.save(addedCity);
        return true;
    }

    @Override
    public boolean deleteCityById(Integer id) {
        cityRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteCity(CityModel city) {
        City deletedCity = mapper.map(city, City.class);
        cityRepository.delete(deletedCity);
        return true;
    }
}
