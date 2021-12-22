package com.origin.cafe.utils;


import com.origin.cafe.config.CafeUserDetails;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUserUtils {


	public static String getUserName() {
		return getUserDetails().getUsername();
	}

	public static CafeUserDetails getUserDetails(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CafeUserDetails cafeUserDetails =(CafeUserDetails)authentication.getPrincipal();
		return cafeUserDetails;
	}

	public static Set<String> getAuthorities() {
		return getUserDetails().getUserAuthorities();
	}
}
