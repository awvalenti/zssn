package com.github.awvalenti.zssn.repository;

import java.util.List;

import com.github.awvalenti.zssn.model.ContaminationFlag;

public interface ContaminationFlagRepository {

	void add(ContaminationFlag contaminationFlag);

	List<ContaminationFlag> getAll();

}