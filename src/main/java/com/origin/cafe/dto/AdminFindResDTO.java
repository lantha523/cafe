package com.origin.cafe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class AdminFindResDTO {

  private Integer admNo;

  private String name;

  private String address;

  private String phone;

  private String level;

  private String status;

}