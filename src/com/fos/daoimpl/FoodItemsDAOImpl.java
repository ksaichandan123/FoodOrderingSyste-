package com.fos.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.fos.beans.FoodItems;
import com.fos.dao.FoodItemsDAO;
import com.fos.main.FoodOrderingSystem;

class FoodAvailabilityException extends RuntimeException{
	public FoodAvailabilityException(String msg) {
		super(msg);
	}
}


public class FoodItemsDAOImpl implements FoodItemsDAO
{
	Scanner sc = new Scanner(System.in);
	static List<FoodItems> fooditems = new ArrayList<FoodItems>();
	static List<FoodItems> tempList = new ArrayList<FoodItems>();
	FoodItems fooditem = null;
	

	@Override
	public void addFoodItems() {
		int i=1;
		while(i==1)
		{
			fooditem = new FoodItems();
			System.out.println("Enter Fooditem Number ?");
			fooditem.setFid(sc.nextInt());
			System.out.println("Enter Fooditem Name ?");
			fooditem.setFname(sc.next());
			System.out.println("Enter Fooditem Type(Veg/Nonveg) ?");
			fooditem.setType(sc.next());
			System.out.println("Enter Fooditem Qty ?");
			fooditem.setQty(sc.nextInt());
			System.out.println("Enter Fooditem Price ?");
			fooditem.setPrice(sc.nextDouble());
			fooditems.add(fooditem);
			System.out.println("Do you want to add more fooditems press 1 else any number?");
			i = sc.nextInt();
			
		}
		System.out.println("Successfully fooditems added...");
		
		
	}

	@Override
	public FoodItems viewFoodItems(int fid) {
		FoodItems f = new FoodItems();
		for(FoodItems f1:fooditems)
		{
			if(f1.getFid()==fid)
			{
				f=f1;
				break;
			}
			
		}
		return f;
		
	}

	@Override
	public List<FoodItems> viewAllFoodItems() {
		// TODO Auto-generated method stub
		return fooditems;
	}

	@Override
	public void updateFoodItems(int fid) {
		tempList = new ArrayList<FoodItems>();
		for(FoodItems f2:fooditems)
		{
			if(f2.getFid()==fid)
			{
				System.out.println("Select Your Choice 1.ItemName 2.Type 3.Qty  4.Price");
				int choice = sc.nextInt();
				switch(choice)
				{
				case 1:System.out.println("Enter Updated FoodItem Name ?");
				       f2.setFname(sc.next());
				       break;
				case 2:System.out.println("Enter Updated FoodItem Type ?");
				f2.setType(sc.next());
				       break;
				case 3:System.out.println("Enter Updated FoodItem Qty ?");
			       f2.setQty(sc.nextInt());
			       break;   
				case 4:System.out.println("Enter Updated FoodItem Price ?");
				       f2.setPrice(sc.nextDouble());
				       break;
				default:System.out.println("Please select your choice range 1-3 only");       
				}
				tempList.add(f2);
				System.out.println("Successfully FoodItems are  Updated....");
				System.out.println();
			}
			
			else{
				throw new FoodAvailabilityException ("FoodItems not Available with that ID please try with available ID");
			}
				
	}
		fooditems= new ArrayList<FoodItems>();
		for(FoodItems f3:tempList)
		{
			fooditems.add(f3);
		}
		System.out.println();
		
		
		
		
	}

	@Override
	public void deleteFoodItems(int fid) {
		tempList = new ArrayList<FoodItems>();
		for(FoodItems f2:fooditems)
		{
			if(f2.getFid()==fid)
			{
				
			}else{
				throw new FoodAvailabilityException ("FoodItems not Available with that ID please try with available ID");
			}
		}
		fooditems = new ArrayList<FoodItems>();
		for(FoodItems f3:tempList)
		{
			fooditems.add(f3);
		}
		System.out.println("Successfully FoodItems Deleted...");
		
		
		
	}

	@Override
	public void order() {
		tempList = new ArrayList<FoodItems>();
		FoodItems fooditem = new FoodItems();
		for(FoodItems f4:fooditems)
		{
			System.out.println(f4);
		}
		
		System.out.println("Enter Select FoodItem id ?");
		fooditem.setFid(sc.nextInt());
		System.out.println("Enter FoodItem Qty ?");
		fooditem.setQty(sc.nextInt());
		
		
			for(FoodItems f5:fooditems)
			{
				if(f5.getFid()==fooditem.getFid())
				{
					f5.setQty(f5.getQty()-fooditem.getQty());
					tempList.add(f5);
					System.out.println("------------------------------");
					System.out.println("|          YOUR ORDER        |");
					System.out.println("------------------------------");
					System.out.println("FoodItem Id    :   "+fooditem.getFid());
					System.out.println("FoodItem Name  :   "+f5.getFname());
					System.out.println("FoodItem Type  :   "+fooditem.getType());
					System.out.println("FoodItem Qty   :   "+fooditem.getQty());
					System.out.println("FoodItem Price :   "+f5.getPrice());
					System.out.println("-------------------------------");
					System.out.println("Total         :   "+(fooditem.getQty()*f5.getPrice()));
					System.out.println("-------------------------------");
					
				}else {
					throw new FoodAvailabilityException ("FoodItems not Available with that ID please try with available ID");
				}
		}
		
		
		
		fooditems= new ArrayList<FoodItems>();
		for(FoodItems f6:tempList)
		{
			fooditems.add(f6);
		}
		System.out.println("Your food is ordered" +"\n" +"thank you" +"\n"+ "Visit Once again....");
		
		
		}

	

	@Override
	public void cancelOrder()
	{
		tempList = new ArrayList<FoodItems>();
		FoodItems fooditem = new FoodItems();
		for(FoodItems f7:fooditems)
		{
			System.out.println(f7);
		}
		
		System.out.println("Enter Select FoodItem id ?");
		fooditem.setFid(sc.nextInt());
		System.out.println("Enter FoodItem Qty ?");
		fooditem.setQty(sc.nextInt());
		
		for(FoodItems f8:fooditems)
		{
			if(f8.getFid()==fooditem.getFid())
			{
				f8.setQty(f8.getQty()+fooditem.getQty());
				tempList.add(f8);
				
			}else{
				throw new FoodAvailabilityException ("FoodItems not Available with that ID please try with available ID");
			}
		}
		fooditems= new ArrayList<FoodItems>();
		for(FoodItems f9:tempList)
		{
			fooditems.add(f9);
		}
		System.out.println("Your food order is cancelled" +"\n"+ "thank you"+"\n"+" Visit Once again....");
		
		
		
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		FoodOrderingSystem.main(null);
		
		
	}

}
