package com.topic6ex3;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value="/user")
@ApiModel(value = "User registration Paths",description="Controller for User Registration")
public class RegisterUsersController {
	
	String URL ="jdbc:mysql://localhost:3306/regusers";
	String User="root";
	String Pass="root1234";
	RegisterUsersImp db=RegisterUsersImp.connect(URL, User, Pass);
	StringBuilder query = new StringBuilder();
	int sts;	
	//List<User> retrv =new LinkedList<User>();
	ResponseEntity resp;
	
	
	

	
	@RequestMapping(value="/usr",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Returns a User, search by Name", notes = "Returns User Id, name, nickname base on search by name")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully Retrived.", response=String.class),@ApiResponse(code = 404, message = "User not Found.", response=String.class)})	
	public List<User> readByName(@RequestParam(value="name") String pasQuery ){
		
		query.setLength(0);
		query.append("Select id, name, nickname from registeruser where name =");
		db.read(db.queryStringMaker(query, pasQuery));		
		return	db.formater();	
		}
		
				
	
	
	@RequestMapping(value="/nk",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Returns a User, search by Nickname", notes = "Returns User Id, name, nickname base on search by Nickname")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully Retrived.", response=String.class),@ApiResponse(code = 404, message = "User not Found.", response=String.class)})
	public List<User> readByNickName(@RequestParam(value="nkname") String pasQuery ){
		
		query.setLength(0);
		query.append("Select id, name, nickname from registeruser where nickname =");
		db.read(db.queryStringMaker(query, pasQuery));		
		return db.formater();
								
		}
	
	
	@RequestMapping(value="/id",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Returns a User, search by id", notes = "Returns User Id, name, nickname base on search by id")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully Retrived.", response=String.class),@ApiResponse(code = 404, message = "User not Found.", response=String.class)})
	public List<User> readByID(@RequestParam(value="id") String pasQuery ){
		
		query.setLength(0);
		query.append("Select id, name, nickname from registeruser where id =");
		db.read(db.queryStringMaker(query, pasQuery));		
		return db.formater();
								
		}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Updates User Name", notes = "Updates User name (Requires User Id)")
	@ApiResponses({@ApiResponse(code = 200, message = "User name succesfully Update.", response=String.class),@ApiResponse(code = 201, message = "User Updated.", response=String.class)})
	@RequestMapping(value="/updName",method=RequestMethod.PUT)
	public void updateUserName(@RequestParam(value="id") String id,@RequestParam(value="name") String pasQuery){
		
		query.setLength(0);
		sts=0;
		//query.append("UPDATE registeruser SET name = 'nickname5' WHERE id = 4;");
		query.append("UPDATE registeruser SET name ='");
		query.append(pasQuery);
		query.append("' WHERE id =");		
		sts=db.update(db.queryStringMaker(query, id));
		
		//System.out.println("Update Complete ? "+sts);
		
		}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Updates User Nickname", notes = "Updates User Nickname (Requires User Id)")
	@ApiResponses({@ApiResponse(code = 200, message = "User name succesfully Update.", response=String.class),@ApiResponse(code = 201, message = "User Updated.", response=String.class)})
	@RequestMapping(value="/updNk",method=RequestMethod.PUT)
	public void updateUserNickName(@RequestParam(value="id") String id,@RequestParam(value="nkname") String pasQuery){
		
		query.setLength(0);
		sts=0;
		//query.append("UPDATE registeruser SET name = 'nickname5' WHERE id = 4;");
		query.append("UPDATE registeruser SET nickname ='");
		query.append(pasQuery);
		query.append("' WHERE id =");		
		sts=db.update(db.queryStringMaker(query, id));
		
		//System.out.println("Update Complete ? "+sts);
		
		}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Insert a new User", notes = "Insert a new User (Requires User Id, name, nickname)")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully Create.", response=String.class),@ApiResponse(code = 201, message = "User Created.", response=String.class)})
	@RequestMapping(value="/inst",method=RequestMethod.POST)
	public ResponseEntity<String> insertUser(@RequestParam(value="name") String pasQuery1,@RequestParam(value="nkname") String pasQuery2){
		
		query.setLength(0);
		sts=0;
		//insert into registeruser values (default,"Name1","Nickname1"),		
		query.append("insert into registeruser (id,name,nickname) values (default,'");
		query.append(pasQuery1);
		query.append("','");
		query.append(pasQuery2);
		query.append("')");
		sts=db.Create(query.toString());
		if(sts==0){
			resp = new ResponseEntity<>("User not added",HttpStatus.INTERNAL_SERVER_ERROR);
			return resp;
		}else{
			resp = new ResponseEntity<>("User Added",HttpStatus.CREATED);
			return resp;
		}
		//System.out.println("Insert Complete ? "+sts);
		
		}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Delete a User", notes = "Delete a User by Id (Requires User Id)")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully Delete.", response=String.class)})
	@RequestMapping(value="/id",method=RequestMethod.DELETE)
	public void delete(@RequestParam(value="id") String pasQuery){
		
		query.setLength(0);
		sts=0;
		//delete from registeruser where id = 5;
		query.append("delete from registeruser where id =");
		sts=db.delete(db.queryStringMaker(query, pasQuery));		
				
		//System.out.println("delete Complete ? "+sts);
		
		}
	
	
	@RequestMapping(value="/a",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Returns all Register Users", notes = "Returns all Register Users and they respective information (id, name, nickname)")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully Retrived.", response=String.class)})	
	public List<User> returnAll(){
		
		db.read("SELECT * FROM regusers.registeruser");		
		return db.formater();
								
		}
	
	}


