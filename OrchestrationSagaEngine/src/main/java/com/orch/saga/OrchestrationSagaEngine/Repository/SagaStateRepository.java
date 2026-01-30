package com.orch.saga.OrchestrationSagaEngine.Repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orch.saga.OrchestrationSagaEngine.Entity.SagaState;

@Repository
public interface SagaStateRepository extends JpaRepository<SagaState, String>{

	List<SagaState> findByCurrentStep(String string);

	@Query(
		    value = "SELECT * FROM saga_state " +
		            "WHERE current_step = :currentStep " +
		            "AND status = :status " +
		            "AND payment_requested_at < :cutoffTime",
		    nativeQuery = true
		)
	List<SagaState> findPaymentPendingOlderThan(@Param("currentStep") String currentStep,@Param("status") String status,@Param("cutoffTime") Instant  cutoffTime
	);

}
