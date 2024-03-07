package velazquez._5_spring_security_jpa.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import velazquez._5_spring_security_jpa.api.dto.ProfesorDTO;
import velazquez._5_spring_security_jpa.mappers.Mapper;
import velazquez._5_spring_security_jpa.model.Profesor;

@Component
public class ProfesorMapperImpl implements Mapper<Profesor, ProfesorDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProfesorDTO mapTo(Profesor profesor) {
        return modelMapper.map(profesor, ProfesorDTO.class);
    }

    @Override
    public Profesor mapFrom(ProfesorDTO profesorDTO) {
        return modelMapper.map(profesorDTO, Profesor.class);
    }
}
