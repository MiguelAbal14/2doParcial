package com.example.libreriaparcial.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Localidad extends Base{

    @Column(name="denominacion")
    private String denominacion;
}
