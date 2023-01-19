package com.fos.menu;

import java.util.List;
import java.util.Scanner;

import com.fos.beans.FoodItems;
import com.fos.daoimpl.FoodItemsDAOImpl;



public class FoodDetails {
	static Scanner sc = new Scanner(System.in);
	static FoodItemsDAOImpl fooditemDAO = new FoodItemsDAOImpl();

	public static void adminMenu() {
		System.out.println("-----------------------");
		System.out.println("|   ADMIN MAIN MENU   |");
		System.out.println("-----------------------");
		System.out.println("| 1.ADD  FOODITEMS    |");
		System.out.println("| 2.VIEW FOODITEMS    |");
		System.out.println("| 3.VIEW ALL FOODITEMS|");
		System.out.println("| 4.UPDATE FOODITEMS  |");
		System.out.println("| 5.DELETE FOODITEMS  |");
		System.out.println("| 6.BACK              |");
		System.out.println("-----------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			fooditemDAO.addFoodItems();
			adminMenu();
			break;
		case 2:
			System.out.println("Enter Your Search fooditem Id ?");
			FoodItems fooditems = fooditemDAO.viewFoodItems(sc.nextInt());
			System.out.println("FID" + "\t" + "FNAME" + "\t" +"TYPE"+"\t"+ "QTY" + "\t" + "PRICE");
			System.out.println("----------------------------------------------------------------");
			System.out.println(fooditems);
			adminMenu();
			break;
		case 3:
			List<FoodItems> fooditem = fooditemDAO.viewAllFoodItems();
			System.out.println("FID" + "\t" + "FNAME" +"\t"+ "TYPE"+ "\t" + "QTY" + "\t" + "PRICE");
			System.out.println("-----------------------------------------------------------------");
			for (FoodItems f : fooditem) {
				System.out.println(f);
			}
			adminMenu();
			break;
		case 4:
			System.out.println("Enter Updating FoodItem Id ?");
			fooditemDAO.updateFoodItems(sc.nextInt());
			adminMenu();
			break;
		case 5:
			System.out.println("Enter Deleting FoodItem Id ?");
			fooditemDAO.deleteFoodItems(sc.nextInt());
			adminMenu();
			break;
		case 6:
			fooditemDAO.back();
			break;
		default:
			System.out.println("Please select your choice range 1-6 only");

		}
	}

	public static void customerMenu() {
		System.out.println("--------------------------");
		System.out.println("|  CUSTOMER MAIN MENU    |");
		System.out.println("--------------------------");
		System.out.println("| 1.VIEW FOOD ITEMS      |");
		System.out.println("| 2.VIEW ALL FOOD ITEMS  |");
		System.out.println("| 3.PLACE ORDER          |");
		System.out.println("| 4.CANCEL ORDER         |");
		System.out.println("| 5.BACK                 |");
		System.out.println("--------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			System.out.println("Enter Your Search FoodItem Id ?");
              FoodItems  fooditem =  fooditemDAO.viewFoodItems(sc.nextInt());
			System.out.println("FID" + "\t" + "FNAME" +"\t"+"Type" +"\t"+ "QTY" + "\t" + "PRICE");
			System.out.println("---------------------------------------------------------------");
			System.out.println( fooditem);
			customerMenu();
			break;
		case 2:
			List<FoodItems>  fooditems =  fooditemDAO.viewAllFoodItems();
			System.out.println("FID" + "\t" + "FNAME" +"\t"+ "Type" +"\t"+"QTY" + "\t" + "PRICE");
			System.out.println("---------------------------------------------------------------");
			for ( FoodItems f :  fooditems) {
				System.out.println(f);
			}
			customerMenu();
			break;
		case 3:
			 fooditemDAO.order();
			customerMenu();
			break;
		case 4:
			 fooditemDAO.cancelOrder();
				customerMenu();
			
		case 5:
			 fooditemDAO.back();
			break;
		default:
			System.out.println("Please select your choice range 1-5 only");

		}
	}

}
