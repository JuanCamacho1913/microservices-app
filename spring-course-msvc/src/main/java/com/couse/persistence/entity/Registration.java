package com.couse.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

    @Id
    @Column(name = "id_registration", unique = true, nullable = false)
    private UUID idRegistration;

    @Column(name = "student_id", unique = true, nullable = false)
    private UUID studentId;

    @Column(name = "course_id", unique = true, nullable = false)
    private UUID courseId;

    @PrePersist
    public void prePersist(){
        if (idRegistration == null){
            this.idRegistration = UUID.randomUUID();
        }
    }
}
