package com.github.awvalenti.zssn.service;

import java.util.HashSet;
import java.util.Set;

import com.github.awvalenti.zssn.model.ContaminationFlag;
import com.github.awvalenti.zssn.model.Survivor;
import com.github.awvalenti.zssn.repository.ContaminationFlagRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class ContaminationFlagService {

	private ContaminationFlagRepository flagRepo;
	private SurvivorRepository survivorRepo;

	public ContaminationFlagService(ContaminationFlagRepository flagRepo,
			SurvivorRepository survivorRepo) {
		this.flagRepo = flagRepo;
		this.survivorRepo = survivorRepo;
	}

	public void add(long reporterId, long flaggedId) {
		if (reporterId == flaggedId) return;

		flagRepo.add(new ContaminationFlag(survivorRepo.getOne(reporterId), survivorRepo
				.getOne(flaggedId)));

		if (flagsCount(flaggedId) >= 3) {
			survivorRepo.getOne(flaggedId).setZombie(true);
		}
	}

	private int flagsCount(long flaggedId) {
		Set<Survivor> reporters = new HashSet<>();

		for (ContaminationFlag flag : flagRepo.getAll()) {
			if (flag.getFlagged().getId() == flaggedId) {
				reporters.add(flag.getReporter());
			}
		}

		return reporters.size();
	}

}
