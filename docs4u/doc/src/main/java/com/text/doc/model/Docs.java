package com.text.doc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class Docs {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String fileId;
  
  private String name;

  private String type;

  @Lob
  private byte[] data;

  @ManyToMany(cascade =
      {
              CascadeType.DETACH,
              CascadeType.MERGE,
              CascadeType.REFRESH,
              CascadeType.PERSIST
      },fetch = FetchType.LAZY)
	@JoinTable(
				name="teacherfile",
				joinColumns = {@JoinColumn(name="fileId")},
				inverseJoinColumns = {@JoinColumn(name="teacherId")}
			)
	List<Admin> teacherList;
  
  
  public List<Admin> getTeacherList() {
	return teacherList;
}

public void setTeacherList(List<Admin> teacherList) {
	this.teacherList = teacherList;
}

public void setId(String fileId) {
	this.fileId = fileId;
}

public Docs() {
  }

  public Docs(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }

  public String getId() {
    return fileId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

}