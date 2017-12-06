package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TABLE")
public class User implements Serializable {
	
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	  private Long id;
	 private String userId;
    private String password;
    
    public User() {
    }
    
    public User(String userID, String password){
    	this.userId=userID;
    	this.password=password;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    

}
