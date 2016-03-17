package com.proyecto01.pacakge;

public class User {
	
    private String username;
    private String pass;
    private String name;
    private String namelist;
    private int listsize;
    
    public User() {
    	
    }

	public User(String username, String pass, String name, String namelist, int listsize) {
		this.username = username;
		this.pass = pass;
		this.name = name;
		this.namelist = namelist;
		this.listsize = listsize;
	}
	

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamelist() {
		return namelist;
	}

	public void setNamelist(String namelist) {
		this.namelist = namelist;
	}
    
    
	public String toString(){
		return username + pass  + name  + namelist;
		}
    
}
    
   