package com.miko.paopao.repository;

import com.miko.paopao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author miko
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    /**
     * 更新数据状态
     * @param status
     * @param id
     */
    @Modifying
    @Query("update User u set u.status=?1 where  u.id=?2")
    void updateStatusById(int status, Long id);

    /**
     * 更新数据状态
     * @param status
     * @param ids
     */
    @Modifying
    @Query("update User u set u.status=?1 where  u.id in ?2")
    void batchUpdateStatusById(int status, List<Long> ids);

    /**
     *
     * @param name
     * @param admin
     * @param pageable
     * @return
     */
    @Query(value = "SELECT u  FROM User u WHERE u.name like %:name% AND u.admin=:admin AND u.status<>3")
    Page<User> findPageByName(@Param("name") String name,@Param("admin") boolean admin,Pageable pageable);

}
