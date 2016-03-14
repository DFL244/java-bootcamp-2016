package com.topic6ex3;

public class User {
	
    private int id;
    private String name;
    private String nickname;
    
    public User() {
    	
    }
    
    public User(int id, String name, String nickname) {           
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }
    
    
    public int getId() {
        return id;
    }
    
    
    public String getName() {         
    	return name;
    }
    
    public String getNickName() {         
    	return nickname;
    }
}