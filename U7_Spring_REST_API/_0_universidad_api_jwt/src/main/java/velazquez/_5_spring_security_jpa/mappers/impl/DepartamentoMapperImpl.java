package velazquez._5_spring_security_jpa.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import velazquez._5_spring_security_jpa.mappers.Mapper;
import velazquez._5_spring_security_jpa.model.Departamento;

@Component
public class DepartamentoMapperImpl implements Mapper<Departamento, velazquez._5_spring_security_jpa.api.dto.DepartamentoDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public velazquez._5_spring_security_jpa.api.dto.DepartamentoDTO mapTo(Departamento departamento) {
        return modelMapper.map(departamento, velazquez._5_spring_security_jpa.api.dto.DepartamentoDTO.class);
    }

    @Override
    public Departamento mapFrom(velazquez._5_spring_security_jpa.api.dto.DepartamentoDTO departamentoDTO) {
        return modelMapper.map(departamentoDTO, Departamento.class);
    }
}
