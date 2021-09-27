package com.text.doc.docResponse;

public class Response{
  private String file_id;
  private String name;
  private String url;
  private String type;
  private long size;

  public Response(String file_id, String name, String url, String type, long size) {
    
	this.file_id = file_id;
	this.name = name;
    this.url = url;
    this.type = type;
    this.size=size;

  }
  

  public String getFile_id() {
	return file_id;
}


public void setFile_id(String file_id) {
	this.file_id = file_id;
}


public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }
  
  
  @Override
  public String toString() {
      return "Response{" +
              "name=" + name +
              ", url='" + url + '\'' +
              ", type='" + type + '\'' +
              ", size='" + size + '\'' +            
              '}';
  }
}