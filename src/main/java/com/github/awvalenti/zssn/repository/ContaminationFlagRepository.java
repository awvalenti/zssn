package com.github.awvalenti.zssn.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.awvalenti.zssn.model.ContaminationFlag;
import com.github.awvalenti.zssn.model.Survivor;

public class ContaminationFlagRepository {

	private final List<ContaminationFlag> data = new ArrayList<>();

	private final SurvivorRepository survivorRepo;

	public ContaminationFlagRepository(SurvivorRepository survivorRepo) {
		this.survivorRepo = survivorRepo;
	}

	public void add(long reporterId, long flaggedId) {
		if (reporterId == flaggedId) return;

		data.add(new ContaminationFlag(survivorRepo.getOne(reporterId), survivorRepo
				.getOne(flaggedId)));

		if (flagsCount(flaggedId) >= 3) {
			survivorRepo.getOne(flaggedId).setZombie(true);
		}
	}

	private int flagsCount(long flaggedId) {
		Set<Survivor> reporters = new HashSet<>();

		for (ContaminationFlag flag : data) {
			if (flag.getFlagged().getId() == flaggedId) reporters.add(flag.getReporter());
		}

		return reporters.size();
	}

}
