package com.abeldevelop.architecture.services.common.dto;

public enum ApplicationSort {

    NAME_DESC("NAME_DESC");
    
    private String value;
    
    private ApplicationSort(String value) {
        this.value = value;
    }
    
    public String getSort() {
        return value;
    }
    
}
