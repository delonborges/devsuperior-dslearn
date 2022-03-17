package com.delonborges.dslearn.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthCustomError implements Serializable {

    private static final long serialVersionUID = 1L;

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;
}
