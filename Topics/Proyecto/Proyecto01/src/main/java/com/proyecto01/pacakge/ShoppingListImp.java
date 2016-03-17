package com.proyecto01.pacakge;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShoppingListImp implements ShoppingList {
	
	
	int mLsize;
	int qPList=0;
	
	
	
	
	public ShoppingListImp(int mLsize){
		this.mLsize=mLsize;
		
	}
	
	
	
	@Override
	public boolean addtoShopList(int qty,Product retPrd,Map<Integer,Product> shopL, String namelist,DBcrudImp db) {
	
		qPList=0;
		
		if(qty<=0){
			System.out.println(" insisde shoppin metod qty:  "+qty);
			return false;			
		}		
		
		int id=retPrd.getId();
		
		if(shopL.containsKey(id)){ // if the product is on the shopping list			
			qPList=shopL.get(id).getQty();			
			
			if(qty>=1){
				
				qPList=qPList+qty;				
				db.update("UPDATE "+namelist+" SET qty ='"+qPList+"' where id='"+id+"'");
				shopL.get(id).setQty(qPList);
				db.update("UPDATE "+namelist+" SET tprice ='"+shopL.get(id).getTprice()+"' where id='"+id+"'");
				
				
			}		
			
		}else { // if product is not in the shopping list
			
			if(shopL.size()==mLsize){
				//
				return false;
				
			}else{
				qPList=qPList+qty;
				db.Create("insert into "+namelist+" (id,pname,qty,category,uprice,tprice) values ("+retPrd.getId()+",'"+retPrd.getPname()+"',"+retPrd.getQty()+",'"+retPrd.getCategory()+"',"+retPrd.getUprice()+","+retPrd.getTprice()+")");
				
				shopL.put(id,retPrd);
				
				db.update("UPDATE "+namelist+" SET qty ='"+qPList+"' where id='"+id+"'");
				shopL.get(id).setQty(qPList);
				db.update("UPDATE "+namelist+" SET tprice ='"+shopL.get(id).getTprice()+"' where id='"+id+"'");
				
				
			}			
						
		}			
		
		return true;
	}
	
	
	public boolean delQtyProduct(int qty, int id,Map<Integer,Product> shopL,String namelist,DBcrudImp db){
		qPList=0;
		if(qty<=0){
			
			return false;
			
		}else if(shopL.containsKey(id) && qty>=1){
			qPList=shopL.get(id).getQty();
			qPList=qPList-qty;
			
			if(qPList<=0){
				shopL.remove(id);
				db.delete("delete from "+namelist+" where id="+id);				
				return true;
				
			}else{
				db.update("UPDATE "+namelist+" SET qty ='"+qPList+"' where id='"+id+"'");
				shopL.get(id).setQty(qPList);
				db.update("UPDATE "+namelist+" SET tprice ='"+shopL.get(id).getTprice()+"' where id='"+id+"'");
				return true;
			}			
			
		}else{
			
			return false;
		}	
	}
	
	
	
	
	public boolean delProdfromShopList(int id,Map<Integer,Product> shopL,String namelist,DBcrudImp db){
		
		if(shopL.containsKey(id)){
			shopL.remove(id);
			db.delete("delete from "+namelist+" where id="+id);			
			return true;
			
		}else{
			return false;
		}	
		
	}
	
	
		
	public boolean clearShoppingList(Map<Integer,Product> shopL,String namelist,DBcrudImp db){
		
		shopL.clear();
		db.delete("delete from "+namelist);		
		 if (shopL.isEmpty()){
			 return true;
		 }else {			 
			return false; 
		 }
		
	}
	
	
	
		

}
