
package com.text.doc.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin")
@SequenceGenerator(name="id", initialValue=1, allocationSize=1)
@EntityListeners(AuditingEntityListener.class)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long teacherId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "pass_word", nullable = false)
    private String password;

    @Column(name = "email_address", nullable = false)
    private String email;
    
    @Column(name = "role", nullable = false)
    private int role;
    
    @ManyToMany(cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        },fetch = FetchType.LAZY)
	@JoinTable(
				name="teacherfile",
				joinColumns = {@JoinColumn(name="teacherId")},
				inverseJoinColumns = {@JoinColumn(name="fileId")}
			)
	List<Docs> filelist;
    
    
    
  public List<Docs> getFilelist() {
		return filelist;
	}


	public void setFilelist(List<Docs> filelist) {
		this.filelist = filelist;
	}


public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


public long getId() {
        return teacherId;
    }


  public void setId(long teacherId) {
        this.teacherId = teacherId;
    }

  public String getFirstName() {
        return firstName;
    }


  public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

 
  public String getLastName() {
        return lastName;
    }

 
  public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  public String getPassword() {
      return password;
  }


public void setPassword(String password) {
      this.password = password;
  }

  public String getEmail() {
        return email;
    }

  public void setEmail(String email) {
        this.email = email;
    }

  

    @Override
	public String toString() {
		return "Admin [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", role=" + role + "]";
	}


}
