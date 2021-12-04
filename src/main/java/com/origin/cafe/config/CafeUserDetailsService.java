package com.origin.cafe.config;

import com.origin.cafe.entity.AdmAuthority;
import com.origin.cafe.repository.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CafeUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CafeUserDetailsService.class);

    private static final List<GrantedAuthority> SURPERMANAGER_ROLES = AuthorityUtils.createAuthorityList("ROLE_SURPERMANAGER", "ROLE_MANAGER", "ROLE_MEMBER");
    private static final List<GrantedAuthority> MANAGER_ROLES = AuthorityUtils.createAuthorityList("ROLE_MANAGER", "ROLE_MEMBER");

    // 利用Spring提供的AuthorityUtils中createAuthorityList將該群組加入相關roles
    // 以便用一個List變數就儲存所有roles
    private static final List<GrantedAuthority> MEMBER_ROLES = AuthorityUtils.createAuthorityList("ROLE_MEMBER");

    private static final String SUPER_MANAGER_USERNAME = "king";

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException{

        Optional<com.origin.cafe.entity.User> optUser = userRepository.findByUsernameAndEnabled(username, (byte)1);
        if(optUser.isPresent()){

            com.origin.cafe.entity.User user = optUser.get();
            //用集合及一個helper class來取得user的擁有的role
            Collection<? extends GrantedAuthority> authorities = null;
            List<Integer> featureNos = new ArrayList<>();
            if(user.getAdministrator() != null){
                if(SUPER_MANAGER_USERNAME.equals(user.getUsername())){
                    authorities = SURPERMANAGER_ROLES;
                }else{
                    authorities = MANAGER_ROLES;
                }
                for (AdmAuthority ad : user.getAdministrator().getAdmAuthoritys()) {
                    Integer functionNo = ad.getAdmFunction().getFunctionNo();
                    featureNos.add(functionNo);
                }
            }else if(user.getMember() != null){
                authorities = MEMBER_ROLES;
            }

            log.info("user login success, username:{}, password:{}, authorities:{}", user.getUsername(), user.getPassword(), authorities.toArray());

            return new CafeUserDetails(user.getUsername(), user.getPassword(), authorities, featureNos);
            //這邊的User是指org.springframework.security.core.userdetails.User
            //是UserDetails介面的實作，儲存使用者名稱、密碼及擁有權限
        }else{
            throw new UsernameNotFoundException("Invalid username/password");
        }

    }
}
