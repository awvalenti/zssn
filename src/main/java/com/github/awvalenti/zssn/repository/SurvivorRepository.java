package com.github.awvalenti.zssn.repository;

import java.util.ArrayList;
import java.util.List;

import com.github.awvalenti.zssn.model.Survivor;

public class SurvivorRepository {

	private final List<Survivor> data;

	public SurvivorRepository() {
		this(new ArrayList<Survivor>());
	}

	public SurvivorRepository(List<Survivor> survivors) {
		data = survivors;
	}

	public void add(Survivor survivor) {
		data.add(survivor);
		survivor.setId((long) data.size());
	}

	public Survivor getOne(long id) {
		return data.get((int) id - 1);
	}

}
