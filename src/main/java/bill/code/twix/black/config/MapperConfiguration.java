package bill.code.twix.black.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setCollectionsMergeEnabled(true)
                .setSkipNullEnabled(true);

        return mapper;
    }
}
