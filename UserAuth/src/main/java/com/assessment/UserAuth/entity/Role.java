package com.assessment.UserAuth.entity;
import static com.assessment.UserAuth.entity.Permission.DELETE;
import static com.assessment.UserAuth.entity.Permission.READ;
import static com.assessment.UserAuth.entity.Permission.WRITE;
import java.util.Set;

public enum Role {

	USER(Set.of(READ)),
	ADMIN(Set.of(READ,WRITE,DELETE));
	
	private final Set<Permission> permissions;
	
	Role(Set<Permission> permissions){
		this.permissions = permissions;
	}
	
	public Set<Permission> getPermission(){
		return this.permissions;
	}
}
