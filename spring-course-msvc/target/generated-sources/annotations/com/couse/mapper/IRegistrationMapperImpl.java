package com.couse.mapper;

import com.common.registration.RegistrationResponse;
import com.couse.persistence.entity.Registration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T18:28:07-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class IRegistrationMapperImpl implements IRegistrationMapper {

    @Override
    public RegistrationResponse toRegistationResponse(Registration registration) {
        if ( registration == null ) {
            return null;
        }

        UUID idRegistration = null;
        UUID studentId = null;
        UUID courseId = null;

        idRegistration = registration.getIdRegistration();
        studentId = registration.getStudentId();
        courseId = registration.getCourseId();

        RegistrationResponse registrationResponse = new RegistrationResponse( idRegistration, studentId, courseId );

        return registrationResponse;
    }

    @Override
    public List<RegistrationResponse> toRegistrationResponseList(List<Registration> registrations) {
        if ( registrations == null ) {
            return null;
        }

        List<RegistrationResponse> list = new ArrayList<RegistrationResponse>( registrations.size() );
        for ( Registration registration : registrations ) {
            list.add( toRegistationResponse( registration ) );
        }

        return list;
    }
}
