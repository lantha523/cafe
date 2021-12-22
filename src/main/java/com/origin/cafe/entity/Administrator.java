package com.origin.cafe.entity;

import com.origin.cafe.enums.Level;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "administrator")
public class Administrator {

  // 定義fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "adm_no")
  private int admNo;

  @Column(name = "adm_name")
  private String admName;

  @Column(name = "adm_address")
  private String admAddress;

  @Column(name = "adm_phone")
  private String admPhone;

  @Column(name = "adm_level")
  @Enumerated(EnumType.STRING)
  private Level admLevel;

  @Column(name = "adm_status")
  private byte admStatus;

  @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AdmAuthority> admAuthoritys;

}
