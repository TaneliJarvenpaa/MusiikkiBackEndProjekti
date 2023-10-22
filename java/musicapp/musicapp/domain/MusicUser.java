package musicapp.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name= "musicuser")

public class MusicUser { 
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
private Long id;

@Column(name = "username", nullable = false, unique = true)
private String username;

@Column(name = "password_hash", nullable = false)
private String password_hash;

@Column(name="email",nullable=false)
private String email;


@Column(name = "role", nullable = false)
private String role;



public MusicUser() {

}

public MusicUser(String username, String passwordHash,String email, String role) {
	super();
	this.username = username;
	this.password_hash = passwordHash;
	this.role = role;
	this.email=email;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPasswordHash() {
	return password_hash;
}

public void setPasswordHash(String passwordHash) {
	this.password_hash = passwordHash;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

@Override
public String toString() {
	return "AppUser [id=" + id + ", username=" + username + ", passwordHash=" + password_hash + ", role=" + role + "]";
}


}

