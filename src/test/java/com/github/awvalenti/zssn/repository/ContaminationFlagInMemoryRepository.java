package com.github.awvalenti.zssn.repository;

import java.util.ArrayList;
import java.util.List;

import com.github.awvalenti.zssn.model.ContaminationFlag;
import com.github.awvalenti.zssn.repository.ContaminationFlagRepository;

public class ContaminationFlagInMemoryRepository implements ContaminationFlagRepository {

	private List<ContaminationFlag> data = new ArrayList<>();

	@Override
	public void add(ContaminationFlag contaminationFlag) {
		data.add(contaminationFlag);
	}

	@Override
	public List<ContaminationFlag> getAll() {
		return new ArrayList<>(data);
	}

}
