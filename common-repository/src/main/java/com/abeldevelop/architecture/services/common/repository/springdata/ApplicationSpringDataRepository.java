package com.abeldevelop.architecture.services.common.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.abeldevelop.architecture.services.common.model.ApplicationEntity;

public interface ApplicationSpringDataRepository extends JpaRepository<ApplicationEntity, String>, JpaSpecificationExecutor<ApplicationEntity> {

}
