package com.text.doc.constants;

public class SqlQueries {

//	select * from files 
//	Join teacherfile
//	on(teacherfile.file_id=files.file_id)
//	Join admin 
//	on(teacherfile.teacher_id=admin.teacher_id)
//	where admin.teacher_id=1
	public static final String showteacherbook = "SELECT d FROM Docs d join d.teacherList tList where tList.teacherId= :teacher_id";

}
