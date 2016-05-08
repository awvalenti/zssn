package com.github.awvalenti.zssn.resource;

import com.github.awvalenti.zssn.service.ContaminationFlagService;

public class ContaminationFlagResource {

	private final ContaminationFlagService flagRepo;

	public ContaminationFlagResource(ContaminationFlagService flagRepo) {
		this.flagRepo = flagRepo;
	}

	public void post(long reporterId, long flaggedId) {
		flagRepo.add(reporterId, flaggedId);
	}

}
