package bill.code.twix.black.util;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MapperUtil {

    public static <T, R> List<T> mapList(List<R> list, Class<T> target, ModelMapper mapper) {
        return list.stream().map(o -> mapper.map(o, target)).toList();
    }
}
