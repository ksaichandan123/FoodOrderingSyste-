package com.fos.dao;

import java.util.List;

import com.fos.beans.FoodItems;



public interface FoodItemsDAO 
{
	public void addFoodItems();
	public FoodItems viewFoodItems(int fid);
	public List<FoodItems> viewAllFoodItems();
	public void updateFoodItems(int fid);
	public void deleteFoodItems(int fid);
	public void order();
	public void cancelOrder();
	public void back();


}
