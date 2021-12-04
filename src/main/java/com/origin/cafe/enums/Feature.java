package com.origin.cafe.enums;


public enum Feature {
  MENU(1),
  ORDEDR(2),
  MEMBER(3),
  ADMINISTRATOR(4);

  private Integer featureNo;

  Feature(Integer featureNo) {
    this.featureNo = featureNo;
  }

  public Integer getFeatureNo() {
    return this.featureNo;
  }
}
