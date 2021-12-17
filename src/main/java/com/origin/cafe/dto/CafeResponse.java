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

  private CafeStatus status;  //自定義狀態 例如200,500

  private Object data; //回傳的資料

  private String message; //自定義錯誤訊息

  public static CafeResponse body(CafeStatus status, Object data, String message) {
    CafeResponse cafeResponseDTO = new CafeResponse();
    cafeResponseDTO.setStatus(status);
    cafeResponseDTO.setData(data);
    cafeResponseDTO.setMessage(message);
    return cafeResponseDTO;
  }
}