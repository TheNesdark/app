package Utilidades;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/GenomaMapper.class */
public class GenomaMapper {
    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private GenomaMapper() {
    }

    public static <D, T> D map(T t, Class<D> cls) {
        return (D) modelMapper.map(t, cls);
    }

    public static <D, T> List<D> mapAll(Collection<T> listaEntidad, Class<D> dto) {
        return (List) listaEntidad.stream().map(entity -> {
            return map(entity, dto);
        }).collect(Collectors.toList());
    }

    public static <S, D> D map(S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}
