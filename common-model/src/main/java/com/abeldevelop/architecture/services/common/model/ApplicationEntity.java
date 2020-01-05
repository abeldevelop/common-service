package com.abeldevelop.architecture.services.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "applications", schema = "commons_db")
public class ApplicationEntity {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Column(name = "description", nullable = false)
    private String description;
    
}
