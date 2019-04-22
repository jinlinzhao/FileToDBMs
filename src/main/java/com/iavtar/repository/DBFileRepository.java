package com.iavtar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iavtar.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, Long>{

	DBFile findById(String fileId);

}
