package com.abeldevelop.architecture.services.common.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ApplicationEntity.class)
public class ApplicationEntity_ {

    public static volatile SingularAttribute<ApplicationEntity, String> code;
    public static volatile SingularAttribute<ApplicationEntity, String> name;
    public static volatile SingularAttribute<ApplicationEntity, String> description;
    
}
