package com.couse.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String school;
    @Column(nullable = false)
    private String city;
}
