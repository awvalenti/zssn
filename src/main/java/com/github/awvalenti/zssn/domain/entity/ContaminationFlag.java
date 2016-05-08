package com.github.awvalenti.zssn.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContaminationFlag {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	private Survivor reporter;

	@ManyToOne(optional = false)
	private Survivor flagged;

	public ContaminationFlag(Survivor reporter, Survivor flagged) {
		this.reporter = reporter;
		this.flagged = flagged;
	}

	ContaminationFlag() {
	}

	public Survivor getFlagged() {
		return flagged;
	}

	public Survivor getReporter() {
		return reporter;
	}

}
