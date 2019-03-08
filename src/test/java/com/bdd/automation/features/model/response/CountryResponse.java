package com.bdd.automation.features.model.response;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("RestResponse")
public class CountryResponse {
    private CountryResult result;

    public CountryResult getResult() {
        return result;
    }

    public void setResult(CountryResult result) {
        this.result = result;
    }
}
