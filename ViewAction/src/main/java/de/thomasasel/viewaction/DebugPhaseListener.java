package de.thomasasel.viewaction;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Thomas Asel
 */
public class DebugPhaseListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
        System.out.println("After Phase " + pe.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        System.out.println("Before Phase " + pe.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
