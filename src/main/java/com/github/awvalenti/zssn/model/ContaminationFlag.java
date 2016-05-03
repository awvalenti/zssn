package com.github.awvalenti.zssn.model;

public class ContaminationFlag {

	private final Survivor reporter;
	private final Survivor flagged;

	public ContaminationFlag(Survivor reporter, Survivor flagged) {
		this.reporter = reporter;
		this.flagged = flagged;
	}

	public Survivor getFlagged() {
		return flagged;
	}

	public Survivor getReporter() {
		return reporter;
	}

}
