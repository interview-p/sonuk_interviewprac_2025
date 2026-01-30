package com.skt.educationApi.TransactionIsolationCheckAndLock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

	        @Query(
		        value = "SELECT COUNT(*) FROM orders WHERE status = :status",
		        nativeQuery = true
		    )
		    long countByStatusNative(@Param("status") String status);

}
