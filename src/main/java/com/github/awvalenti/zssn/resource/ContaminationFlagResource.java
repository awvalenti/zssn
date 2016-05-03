package com.github.awvalenti.zssn.resource;

import com.github.awvalenti.zssn.repository.ContaminationFlagRepository;

public class ContaminationFlagResource {

	private final ContaminationFlagRepository flagRepo;

	public ContaminationFlagResource(ContaminationFlagRepository flagRepo) {
		this.flagRepo = flagRepo;
	}

	public void post(long reporterId, long flaggedId) {
		flagRepo.add(reporterId, flaggedId);
	}

}
