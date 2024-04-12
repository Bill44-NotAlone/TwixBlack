package bill.code.twix.black.controller.rpc;

import bill.code.twix.black.modles.CityModel;
import bill.code.twix.black.service.face.CityService;
import bill.code.twix.controller.rpc.proto.city.City;
import bill.code.twix.controller.rpc.proto.city.CityControllerGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.modelmapper.ModelMapper;

import java.util.List;

@GRpcService
public class CityGrpcController extends CityControllerGrpc.CityControllerImplBase {

    private final CityService cityService;
    private final ModelMapper mapper;

    public CityGrpcController(CityService cityService, ModelMapper mapper) {
        this.cityService = cityService;
        this.mapper = mapper;
    }

    @Override
    public void getAllCity(Empty request, StreamObserver<City.CitiesResponse> responseObserver) {
        List<City.CityModelGdto> cities = cityService.getAll().stream()
          .map(cm -> City.CityModelGdto.newBuilder()
            .setId(cm.getId())
            .setName(cm.getName())
            .build())
          .toList();
        City.CitiesResponse cityGdto = City.CitiesResponse.newBuilder().addAllCityList(cities).build();
        responseObserver.onNext(cityGdto);
        responseObserver.onCompleted();
    }

    @Override
    public void addCity(City.CityModelGdto request, StreamObserver<City.Bool> responseObserver) {
        CityModel city = mapper.map(request, CityModel.class);
        boolean result = cityService.addCity(city);
        City.Bool bool = City.Bool.newBuilder().setResult(result).build();
        responseObserver.onNext(bool);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCity(City.CityModelGdto request, StreamObserver<City.Bool> responseObserver) {
        CityModel city = mapper.map(request, CityModel.class);
        boolean result = cityService.deleteCity(city);
        City.Bool bool = City.Bool.newBuilder().setResult(result).build();
        responseObserver.onNext(bool);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCityById(City.Int request, StreamObserver<City.Bool> responseObserver) {
        int value = request.getValue();
        boolean result = cityService.deleteCityById(value);
        City.Bool bool = City.Bool.newBuilder().setResult(result).build();
        responseObserver.onNext(bool);
        responseObserver.onCompleted();
    }
}