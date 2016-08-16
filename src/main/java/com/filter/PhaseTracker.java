package com.filter;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseTracker implements PhaseListener {
	
	private static final long serialVersionUID = 1L;

	public void beforePhase(PhaseEvent event) {
		if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {
			System.out.println("*PhaseTracker1: Before Phase: "
					+ event.getPhaseId()
					+ ". <--- "
					+ event.getFacesContext().getExternalContext()
							.getRequestServletPath());
		} else {
			System.out.println("*PhaseTracker1: Before Phase: "
					+ event.getPhaseId());
		}
	}

	public void afterPhase(PhaseEvent event) {
		if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
			System.out.println("*PhaseTracker1: After Phase: "
					+ event.getPhaseId() + "--->"
					+ event.getFacesContext().getViewRoot().getViewId());
			System.out
					.println("-------------------------------------------------------------");
		} else {
			System.out.println("*PhaseTracker1: After Phase: "
					+ event.getPhaseId());
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}