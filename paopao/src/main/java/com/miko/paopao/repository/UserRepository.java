package com.miko.paopao.repository;

import com.miko.paopao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

}
