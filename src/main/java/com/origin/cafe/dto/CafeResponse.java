package com.origin.cafe.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.origin.cafe.enums.CafeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CafeResponse {

  private CafeStatus status;

  private Object data;

  private String message;

  public static CafeResponse body(CafeStatus status, Object data, String message) {
    CafeResponse cafeResponseDTO = new CafeResponse();
    cafeResponseDTO.setStatus(status);
    cafeResponseDTO.setData(data);
    cafeResponseDTO.setMessage(message);
    return cafeResponseDTO;
  }
}