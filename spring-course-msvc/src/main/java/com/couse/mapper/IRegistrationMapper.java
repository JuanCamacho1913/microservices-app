package com.couse.mapper;

import com.common.registration.RegistrationResponse;
import com.couse.persistence.entity.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IRegistrationMapper {

    IRegistrationMapper INSTANCE = Mappers.getMapper(IRegistrationMapper.class);

    RegistrationResponse toRegistationResponse(Registration registration);
    List<RegistrationResponse> toRegistrationResponseList(List<Registration> registrations);
}
