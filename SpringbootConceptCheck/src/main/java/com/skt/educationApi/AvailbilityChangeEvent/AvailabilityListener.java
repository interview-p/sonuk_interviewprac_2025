package com.skt.educationApi.AvailbilityChangeEvent;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityListener {
	
	@EventListener
    public void onStateChange(AvailabilityChangeEvent<?> event) {
        if (event.getState() instanceof ReadinessState readiness) {
            System.out.println("Readiness changed to: " + readiness);
        }

        if (event.getState() instanceof LivenessState liveness) {
            System.out.println("Liveness changed to: " + liveness);
        }
    }
}
