package com.proyecto01.pacakge;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@ApiModel(value = "User registration Paths",description="Controller for User Shopping Cart")
public class ShoppingCardController {
	
	String URL ="jdbc:mysql://localhost:3306/proyecto";
	String User="root";
	String Pass="root1234";
	DBcrudImp db=DBcrudImp.connect(URL, User, Pass);
	ShoppingListImp shopObj; 
	Map<Integer,Product> shopL;
	Map<Integer,Product> cls;
	Buyer bu;
	StringBuilder query = new StringBuilder();
	String ltname;
	User objU2;
	int sts;
	final int MAX=10;
	ResponseEntity resp;
	
	
		
	@RequestMapping(value="/reguser/login",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Allows logIn Operation", notes = "Returns Http status OK if operation is successful")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully LogIN.", response=String.class),@ApiResponse(code = 404, message = "User not Found.", response=String.class)})	
	public ResponseEntity logInUser(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2){
		
		
		System.out.println("objet "+objU2);
		query.setLength(0);
		query.append("Select * from userTable where username ='");
		query.append(pasQuery1);
		query.append("' and pass=");
		db.read(db.queryStringMaker(query, pasQuery2));
		
		objU2=db.formaterUser();
		System.out.println("objet "+objU2);
		
		if(objU2==null){ // user doesn't exist
			
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
			
		}else if(objU2.getNamelist()==null){ // user exist but no list
				
				resp = new ResponseEntity<>("User Found not list Created",HttpStatus.NOT_FOUND);
				return resp;
				
			}else{ 
				System.out.println("namelist"+objU2.getNamelist());
				query.setLength(0);
				query.append("Select * from ");
				query.append(objU2.getNamelist());			
				db.read(query.toString());		
				
				shopL=db.formaterRetiveShopList();
				System.out.println("shopL: "+shopL);
				shopObj = new ShoppingListImp(objU2.getListsize());
				resp = new ResponseEntity<>("User Found list retrived",HttpStatus.OK);
				return resp;
			}	
			
	}	
	
	
	@RequestMapping(value="/reguser",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Creates a user into the database", notes = "Returns Created if operation is succesful")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully Created.", response=String.class),@ApiResponse(code = 404, message = "User not Found.", response=String.class)})
	public ResponseEntity<String> insertUser(@RequestParam(value="uName") String pasQuery1,@RequestParam(value="pass") String pasQuery2,@RequestParam(value="name") String pasQuery3){
		
		query.setLength(0);
		sts=0;
				
		query.append("insert into userTable (username,pass,name,namelist,listsize) values ('");
		query.append(pasQuery1);
		query.append("','");
		query.append(pasQuery2);
		query.append("','");
		query.append(pasQuery3);
		query.append("',default,default)");
		sts=db.Create(query.toString());
		if(sts==0){
			resp = new ResponseEntity<>("User not added",HttpStatus.INTERNAL_SERVER_ERROR);
			return resp;
		}else{
			resp = new ResponseEntity<>("User Added",HttpStatus.CREATED);
			return resp;
		}
		
		
		}
	
	
		
	
	@RequestMapping(value="/reguser/updn",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Updates User Name", notes = "Updates User name (Requires User username and password)")
	@ApiResponses({@ApiResponse(code = 200, message = "User name succesfully Update.", response=String.class),@ApiResponse(code = 201, message = "User Updated.", response=String.class)})
	public ResponseEntity<String>  updateUserName(@RequestParam(value="uName") String pasQuery1,@RequestParam(value="pass") String pasQuery2,@RequestParam(value="Nname") String pasQuery3){
		
		if(objU2==null){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
		}
		
		if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){ // user doesn't exist or Need to logIN
			
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;	
		}
		
		query.setLength(0);
		sts=0;
		
		query.append("UPDATE userTable SET name ='");
		query.append(pasQuery3);
		query.append("' WHERE username ='");
		query.append(pasQuery1);
		query.append("' and pass=");
		sts=db.update(db.queryStringMaker(query, pasQuery2));
		if(sts==0){
			resp = new ResponseEntity<>("Update not Done",HttpStatus.INTERNAL_SERVER_ERROR);
			return resp;
		}else{
			resp = new ResponseEntity<>("Update Done",HttpStatus.CREATED);
			return resp;
		}
		
		
		}
	
	
	
	@RequestMapping(value="/reguser/updpass",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Updates User password", notes = "Updates User password (Requires User username and password)")
	@ApiResponses({@ApiResponse(code = 200, message = "User password succesfully Update.", response=String.class),@ApiResponse(code = 201, message = "password Updated.", response=String.class)})
	public ResponseEntity<String>  updateUserPass(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2,@RequestParam(value="Npass") String pasQuery3){
		
		if(objU2==null){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
		}
		query.setLength(0);
		query.append("Select * from userTable where username ='");
		query.append(pasQuery1);
		query.append("' and pass=");
		db.read(db.queryStringMaker(query, pasQuery2));		
		objU2=db.formaterUser();
		System.out.println("objet "+objU2);
		if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
			
		}else{
			
			if(objU2.getPass().equals(pasQuery3)){
				
				resp = new ResponseEntity<>("New pass must be different from old pass",HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;				
			}else{
				
				query.setLength(0);
				sts=0;
				
				query.append("UPDATE userTable SET pass ='");
				query.append(pasQuery3);
				query.append("' WHERE username ='");
				query.append(pasQuery1);
				query.append("' and pass=");
				sts=db.update(db.queryStringMaker(query, pasQuery2));
				if(sts==0){
					resp = new ResponseEntity<>("Update not Done",HttpStatus.INTERNAL_SERVER_ERROR);
					return resp;
				}else{
					resp = new ResponseEntity<>("Update Done",HttpStatus.CREATED);
					return resp;
				}
				
			}
		}
		
				
		}	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Creates a new Shopplist", notes = "Creates a new Shopplist of specific size")
	@ApiResponses({@ApiResponse(code = 200, message = "List succesfully Create.", response=String.class),@ApiResponse(code = 201, message = "List Created.", response=String.class)})	
	@RequestMapping(value="/crelist",method=RequestMethod.POST)
	public ResponseEntity createList(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2,@RequestParam(value="s") int size){
		
		sts=0;
		
		
		
		if(objU2==null){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
		}
		
		if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){ // user doesn't exist or Need to logIN
			
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
			
		} else if(objU2.getNamelist()==null){		
			
			if(size<=MAX){
				shopObj = new ShoppingListImp(size);
				System.out.println("shopObj: "+shopObj);
			}else{
				resp = new ResponseEntity<>("List size exceeded",HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
			}
			
			shopL=new LinkedHashMap<Integer, Product>();
			ltname="table"+objU2.getUsername(); 
			System.out.println("shopL: "+shopL);
			System.out.println("ltname: "+ltname);
			
			query.setLength(0);
			query.append("create table if not exists ");
			query.append(ltname);
			query.append(" ( id int(10) not null auto_increment, pname char(20) not null, qty int(10) not null, category char(20) not null, uprice int(20) not null, tprice int(20) not null, primary key (id))");
			System.out.println(""+query);
			sts=db.Create(query.toString());
			System.out.println("sts: "+sts);
			if(sts==1){
				resp = new ResponseEntity<>("List not created",HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
			}else{
							
			///*************************
			query.setLength(0);
			sts=0;
			query.append("UPDATE userTable SET namelist ='");
			query.append(ltname);
			query.append("' WHERE username ='");
			
			query.append(objU2.getUsername());
			query.append("' and pass=");
			sts=db.update(db.queryStringMaker(query, objU2.getPass()));
			if(sts==0){
				resp = new ResponseEntity<>("Update namelist not Done",HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
			}else{
				objU2.setNamelist(ltname);
				objU2.setListsize(size);
				db.update("UPDATE userTable SET listsize ='"+size+"' where username='"+objU2.getUsername()+"'");
				System.out.println("objU2: "+objU2);
				resp = new ResponseEntity<>("List created ,update namelist and size.  Done",HttpStatus.CREATED);
				return resp;
			}
			
			
			}
		}else{
			
			resp = new ResponseEntity<>("List already created" ,HttpStatus.INTERNAL_SERVER_ERROR);
			return resp;
		}		
	}	

	
	@RequestMapping(value="/slist",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Shows the shopping list", notes = "Shows the current products in the shopping list (Id, name,qty,category,price)")
	@ApiResponses({@ApiResponse(code = 200, message = "Shopping list succesfully Retrived.", response=String.class)})
	public Map<Integer,Product> showlist(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2){
		
		if(objU2==null){
			cls= new LinkedHashMap<Integer, Product>();
			return cls;
		}
		
		if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){//System.out.println("objet inside IF"+objU2);} // user doesn't exist
			
			
			cls= new LinkedHashMap<Integer, Product>();
			return cls;
			
		}else if(objU2.getNamelist()==null){ // user exist but no list
			
			
			cls= new LinkedHashMap<Integer, Product>();
			return cls;
		}else{ 
			System.out.println("namelist"+objU2.getNamelist());			
			return shopL;
		}
		
	}
	
		
	
	@RequestMapping(value="catalog/n",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Shows the current catalog of products selected by name", notes = "Shows the current products in the catalog  (Id, name,qty,category,price)")
	@ApiResponses({@ApiResponse(code = 200, message = "Catalog lists succesfully Retrived.", response=String.class)})
	public List<Product> getCatalogByName(@RequestParam(value="name") String pasQuery ){
			
			query.setLength(0);
			query.append("Select * from catalog where pname =");
			db.read(db.queryStringMaker(query, pasQuery));		
			return	db.formaterCatalog();	
			}
		
		
		
	@RequestMapping(value="catalog/c",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Shows the current catalog of products selected by category", notes = "Shows the current products in the catalog  (Id, name,qty,category,price)")
	@ApiResponses({@ApiResponse(code = 200, message = "Catalog lists succesfully Retrived.", response=String.class)})
	public List<Product> getCatalogByCategory(@RequestParam(value="ctgy") String pasQuery ){
			
			query.setLength(0);
			query.append("Select * from catalog where category =");
			db.read(db.queryStringMaker(query, pasQuery));		
			return	db.formaterCatalog();		
		}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Insert a new Product to the Shopping list", notes = "Insert a new Product to the Shopping list")
	@ApiResponses({@ApiResponse(code = 200, message = "Addition succesful.", response=String.class)})
	@RequestMapping(value="/instprod",method=RequestMethod.POST)
	public ResponseEntity addProducttoShoppingList(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2,@RequestParam(value="id") String pasQuery,@RequestParam(value="qty") int qty){
		
		if(objU2==null){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
			
		}else if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
		}else{
			
			query.setLength(0);
			query.append("Select * from catalog where id =");
			db.read(db.queryStringMaker(query, pasQuery));
			
			//
			System.out.println("formater product "+db.formaterProduct());
			System.out.println("name list "+objU2.getNamelist());
			System.out.println("qty"+qty);
			System.out.println("shop list"+shopL);
			
			boolean obj_add=shopObj.addtoShopList(qty, db.formaterProduct(), shopL,objU2.getNamelist(),db);	
			
			if(obj_add){
				resp = new ResponseEntity<>("Product added ",HttpStatus.OK);
				return resp;
			}else{
				resp = new ResponseEntity<>("Product NOT  added ",HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
			}
			
		}
		
		
	}  
	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Delete a product from Shopping list", notes = "Delete a product from Shopping list")
	@ApiResponses({@ApiResponse(code = 200, message = "Product succesfully Delete.", response=String.class)})
	@RequestMapping(value="/delp",method=RequestMethod.DELETE)
	public ResponseEntity deleteProductformShoppingList(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2,@RequestParam(value="id") int pasQuery){
		
		if(objU2==null){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
			
		}else if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
		}else{
		
			boolean obj_del=shopObj.delProdfromShopList(pasQuery,shopL,objU2.getNamelist(),db);
			
			if(obj_del){
				resp = new ResponseEntity<>("Product deleted ",HttpStatus.OK);
				return resp;
			}else{
				resp = new ResponseEntity<>("Product NOT  deleted ",HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
			}
						
		//
			}
		}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Reduce de quantity of a product in the Shopping list", notes = "If the quantity is greater than equal to the original value the product is delete from the shopping list")
	@ApiResponses({@ApiResponse(code = 200, message = "Quantity succesfully reduce.", response=String.class)})
	@RequestMapping(value="/decqty",method=RequestMethod.PUT)
	public ResponseEntity reduceQtyProductformShoppingList(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2,@RequestParam(value="id") int pasQuery,@RequestParam(value="qty") int qty){
		
		if(objU2==null){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
			
		}else if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
		}else{
			
			boolean obj_newqty=shopObj.delQtyProduct(qty, pasQuery,shopL,objU2.getNamelist(),db);
			
			if(obj_newqty){
				resp = new ResponseEntity<>("Qty reduce ",HttpStatus.OK);
				return resp;
			}else{
				resp = new ResponseEntity<>("Qty NOT  reduce ",HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
			}
		}	
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Deletes all products from the shopping list", notes = "The shopping list gets empty")
	@ApiResponses({@ApiResponse(code = 200, message = "Shopping list clear succesfully.", response=String.class)})
	@RequestMapping(value="/clslist",method=RequestMethod.DELETE)
	public ResponseEntity clsShoppingList(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2){
		
		if(objU2==null){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
			
		}else if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){
			resp = new ResponseEntity<>("User not Found",HttpStatus.NOT_FOUND);
			return resp;
		}else{
			
			boolean clsList=shopObj.clearShoppingList(shopL,objU2.getNamelist(),db);
			if(clsList){
				resp = new ResponseEntity<>("List Clear",HttpStatus.OK);
				return resp;
			}else{
				resp = new ResponseEntity<>("List NOT Clear ",HttpStatus.INTERNAL_SERVER_ERROR);
				return resp;
			}
		}
		
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Returns a Buy object", notes = "Returns a Buy object that contains the shopping list the username,name and the total amount of the sale")
	@ApiResponses({@ApiResponse(code = 200, message = "User succesfully Retrived.", response=String.class),@ApiResponse(code = 404, message = "User not Found.", response=String.class)})
	@RequestMapping(value="/buylist",method=RequestMethod.GET)
	public Buyer buy(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2){
		
		if(objU2==null){
			bu =new Buyer();
			return bu;
		
			
		}else if(!objU2.getUsername().equals(pasQuery1) || !objU2.getPass().equals(pasQuery2)){
			bu =new Buyer();
			return bu;
			
		}else{
			
			String querytprice="SELECT sum(tprice) FROM "+objU2.getNamelist();
			db.read(querytprice);		
			int totalprice=db.formaterbuy();
			
			 bu =new Buyer(shopL,objU2.getUsername(),objU2.getName(),totalprice);
			
			 return bu;
			
		}
		
		
	}
	
	
	@RequestMapping(value="/reguser/logout",method=RequestMethod.GET)
	public ResponseEntity userlogout(@RequestParam(value="uName") String pasQuery1, @RequestParam(value="pass") String pasQuery2){
		
		if(!objU2.getUsername().equals(pasQuery1)  || !objU2.getPass().equals(pasQuery2)){
			resp = new ResponseEntity<>("User still logIN",HttpStatus.NOT_FOUND);
			return resp;
		}else{
			
			objU2=null;
			resp = new ResponseEntity<>("User logout",HttpStatus.OK);
			return resp;
			
		}
		
	}
	
	
	
}
