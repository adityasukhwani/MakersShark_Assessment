package com.example.MakersSharkAssesment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String location;
    private String natureOfBusiness;
    private String manufacturingProcesses;

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "location='" + location + '\'' +
                ", natureOfBusiness='" + natureOfBusiness + '\'' +
                ", manufacturingProcesses='" + manufacturingProcesses + '\'' +
                '}';
    }
}
