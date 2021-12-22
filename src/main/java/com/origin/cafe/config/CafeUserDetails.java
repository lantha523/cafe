package com.origin.cafe.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CafeUserDetails extends User {

  private String password;
  private String username;
  private Set<String> authorities;
  private List<Integer> featureNos;


  public CafeUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, List<Integer> featureNos) {
    super(username, password, authorities);
    this.password = password;
    this.username = username;
    this.authorities = AuthorityUtils.authorityListToSet(authorities);
    this.featureNos = featureNos;
  }

  public CafeUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
      boolean accountNonLocked,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public Set<String> getUserAuthorities() {
    return authorities;
  }

  public List<Integer> getFeatureNos() {
    return featureNos;
  }
}
