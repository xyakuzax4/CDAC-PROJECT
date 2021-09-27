package com.text.doc.repositories;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.text.doc.constants.SqlQueries;
import com.text.doc.model.Docs;


@Repository
public interface DocsRepository extends JpaRepository<Docs, String> {
	
	@Query(SqlQueries.showteacherbook)
	public List<Docs> getfileList(@Param("teacher_id") long teacherId);
}
	

	

