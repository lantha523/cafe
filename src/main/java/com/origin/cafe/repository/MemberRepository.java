package com.origin.cafe.repository;

import com.origin.cafe.entity.Administrator;
import com.origin.cafe.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import com.origin.cafe.entity.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer>{

    List<Member> findByMemStatusOrderByMemNoAsc(byte memStatus);

    @Query(value = "select m.mem_no,m.cr_date,m.mem_name,m.mem_birth,m.mem_phone,m.mem_email,m.mem_address,u.username,m.md_date,m.mem_img,m.mem_status from member m LEFT JOIN users u on m.mem_no=u.mem_no where u.username like %:keyWord% order by m.mem_no asc", nativeQuery = true)
    List<Member> findByKeyword(@Param("keyWord") String keyWord);

    @Query(value = "select m.mem_no,m.cr_date,m.mem_name,m.mem_birth,m.mem_phone,m.mem_email,m.mem_address,u.username,m.md_date,m.mem_img,m.mem_status from member m LEFT JOIN users u on m.mem_no=u.mem_no where ( u.username like %:keyWord% ) and m.mem_status=:memStatus order by m.mem_no asc", nativeQuery = true)
    List<Member> findByKeywordAndMemStatus(@Param("memStatus") byte memStatus, @Param("keyWord") String keyWord);


}
