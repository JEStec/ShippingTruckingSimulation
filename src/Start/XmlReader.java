// @author Jessika Stec

// this file is a mess --> rework later?

package Start;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import Distances.Network;
import Distances.NetworkData;
import Facilities.Data;
import Facilities.Facility;
import Facilities.Item;
import FacilityManager.FacilityMgr;
import FacilityManager.MgrData;
import ItemManager.ItemMgr;
import ItemManager.ItemMgrData;
import OrderManager.OrderMgr;
import OrderManager.OrderMgrData;
import Orders.Order;
import Orders.OrderData;
import Orders.OrderItem;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlReader {
	
	/**
	 * 
	 */
	public XmlReader() { }
	
	/**
	 * @return
	 */
	public FacilityMgr parseFacility() { 
   	 	FacilityMgr mgr = MgrData.newFacilityMgr();

	      try {
	    	 Facility tempFacility = null;
	    	 String linkName = null;
	    	 int linkDist;
	    	 
	         File file = new File("Facilities.xml");
	         
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder db = dbf.newDocumentBuilder();
	         Document doc = db.parse(file);
	         
	         doc.getDocumentElement().normalize();
	         NodeList nodeList = doc.getElementsByTagName("record");
	         
	         for (int i = 0; i < nodeList.getLength(); i++) {
	        	 
	            Node currentNode = nodeList.item(i);
	                     
	            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element currentElement = (Element) currentNode;
	                        
	               String fName = currentElement.getElementsByTagName("Facility").item(0).getTextContent();	               
	               int fNodeVal = Integer.parseInt(currentElement.getElementsByTagName("Node").item(0).getTextContent());
	               int fRate = Integer.parseInt(currentElement.getElementsByTagName("Rate").item(0).getTextContent());
	               int fCost = Integer.parseInt(currentElement.getElementsByTagName("Cost").item(0).getTextContent());
	               
	               
	           	   tempFacility = Data.newFacility(fName, fNodeVal, fRate, fCost); 
	           	   tempFacility.addManyDaysToSchedule(21);
	            }
	            
	            mgr.addFacility(tempFacility);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	   }
	      
	   return mgr;	
    }

	/**
	 * @return
	 */
	public ItemMgr parseItem() { 
   	 	ItemMgr mgr = ItemMgrData.newItemMgr();

	      try {
	    	 File file = new File("Items.xml");
	         
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder db = dbf.newDocumentBuilder();
	         Document doc = db.parse(file);
	         
	         doc.getDocumentElement().normalize();
	         NodeList nodeList = doc.getElementsByTagName("record");
	         
	         for (int i = 0; i < nodeList.getLength(); i++) {
	        	 
	            Node currentNode = nodeList.item(i);
	                     
	            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element currentElement = (Element) currentNode;
	                        
	               String itemId = currentElement.getElementsByTagName("ItemName").item(0).getTextContent();	               
	               int itemCost = Integer.parseInt(currentElement.getElementsByTagName("Price").item(0).getTextContent());
	               
	           	   mgr.addItem(Data.newItem(itemId, itemCost)); 	            
	            }
	         } 
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	   }
	      
	   return mgr;	
	}
		
	/**
	 * @param facilityMgr
	 * @param itemMgr
	 */
	public void parseInventory(FacilityMgr facilityMgr, ItemMgr itemMgr) { 
   	 	FacilityMgr fMgr = facilityMgr;
   	 	int fMgrSize = fMgr.getSize();
   	 	
   	 	ItemMgr iMgr = itemMgr;
   	 	int iMgrSize = iMgr.getSize();
		
	      try {
	    	 Facility tempFacility = null;
	    	 Item tempItem = null;
		     String itemName = null;
		     int itemQuan;
		     
	         File file = new File("FacilityInventory.xml");
	         
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder db = dbf.newDocumentBuilder();
	         Document doc = db.parse(file);
	         
	         doc.getDocumentElement().normalize();
	         NodeList nodeList = doc.getElementsByTagName("record");
	         
	         for (int i = 0; i < nodeList.getLength(); i++) {
	        	 
	            Node currentNode = nodeList.item(i);
	                     
	            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element currentElement = (Element) currentNode;
	                        
	               String fName = currentElement.getElementsByTagName("FacilityInv").item(0).getTextContent();	               

	               for (int ind = 0; ind < fMgrSize; ind++) { 
	            	   Facility f = fMgr.getFacility(ind);
	            	   
	            	   if (f.getFacName().equals(fName)) { 
	            		   tempFacility = f;
	            	   }
	            	   
	               }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item1").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity1").item(0).getTextContent());
	            	   
	            	   for (int ind = 0; ind < iMgrSize; ind++) { 
	            		   Item it = iMgr.getItem(ind);
	            		   
	            		   if (it.getID().equals(itemName)) { 
	            			   tempItem = it; 
	            		   }
	            	   }
	            	   
	            	   tempFacility.addToInventory(tempItem, itemQuan);	               
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item2").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity2").item(0).getTextContent());
	            	   
	            	   for (int ind = 0; ind < iMgrSize; ind++) { 
	            		   Item it = iMgr.getItem(ind);
	            		   
	            		   if (it.getID().equals(itemName)) { 
	            			   tempItem = it; 
	            		   }
	            	   }
	            	   
	            	   tempFacility.addToInventory(tempItem, itemQuan);	               
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item3").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity3").item(0).getTextContent());
	            	   
	            	   for (int ind = 0; ind < iMgrSize; ind++) { 
	            		   Item it = iMgr.getItem(ind);
	            		   
	            		   if (it.getID().equals(itemName)) { 
	            			   tempItem = it; 
	            		   }
	            	   }
	            	   
	            	   tempFacility.addToInventory(tempItem, itemQuan);	               
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item4").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity4").item(0).getTextContent());
	            	   
	            	   for (int ind = 0; ind < iMgrSize; ind++) { 
	            		   Item it = iMgr.getItem(ind);
	            		   
	            		   if (it.getID().equals(itemName)) { 
	            			   tempItem = it; 
	            		   }
	            	   }
	            	   
	            	   tempFacility.addToInventory(tempItem, itemQuan);	               
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item5").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity5").item(0).getTextContent());
	            	   
	            	   for (int ind = 0; ind < iMgrSize; ind++) { 
	            		   Item it = iMgr.getItem(ind);
	            		   
	            		   if (it.getID().equals(itemName)) { 
	            			   tempItem = it; 
	            		   }
	            	   }
	            	   
	            	   tempFacility.addToInventory(tempItem, itemQuan);	               
	               }
	               catch(NullPointerException e){ }
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }		
		}

	/**
	 * @param facilityMgr
	 * @return
	 */
	public Network parseNetwork(FacilityMgr facilityMgr) { 
		FacilityMgr fMgr = facilityMgr;
		int fMgrSize = fMgr.getSize();
		//System.out.println(fMgrSize);
		Network network = NetworkData.newNetwork(fMgrSize);
		
		try {
	    	 Facility tempFacility = null;
	    	 int tempNodeVal = 0;
	    	 String linkName = null;
	    	 int linkDist = 0;
	    	 int linkNodeVal = 0;
	    	 
	         File file = new File("Network.xml");
	         
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder db = dbf.newDocumentBuilder();
	         Document doc = db.parse(file);
	         
	         doc.getDocumentElement().normalize();
	         NodeList nodeList = doc.getElementsByTagName("record");
	         
	         for (int i = 0; i < nodeList.getLength(); i++) {
	        	 
	            Node currentNode = nodeList.item(i);
	                     
	            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element currentElement = (Element) currentNode;
	                        
	               String fName = currentElement.getElementsByTagName("Facility").item(0).getTextContent();	   
	               
	               for (int ind = 0; ind < fMgrSize; ind++) { 
	            	   Facility f = fMgr.getFacility(ind);
	            	   
	            	   if (f.getFacName().equals(fName)) { 
	            		   tempFacility = f;
	            		   tempNodeVal = f.getNodeVal();
	            	   }	            	   
	               }
	               
	               try{
	            	   linkName = currentElement.getElementsByTagName("LinkName1").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkDist = Integer.parseInt(currentElement.getElementsByTagName("LinkDist1").item(0).getTextContent());
	            	   tempFacility.addToLinks(linkName, linkDist);
	            	   
	            	   for (int ind = 0; ind < fMgrSize; ind++) { 
	            		   Facility link = fMgr.getFacility(ind);
	            		   
	            		   if (link.getFacName().equals(linkName)) { 
	            			   linkNodeVal = link.getNodeVal();
	            		   }
	            	   }
	            	   
	            	   network.updateVal(tempNodeVal, linkNodeVal, linkDist);
	            	   network.updateParentVals(tempNodeVal, linkNodeVal);
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkName = currentElement.getElementsByTagName("LinkName2").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkDist = Integer.parseInt(currentElement.getElementsByTagName("LinkDist2").item(0).getTextContent());
	            	   tempFacility.addToLinks(linkName, linkDist);
	            	   
	            	   for (int ind = 0; ind < fMgrSize; ind++) { 
	            		   Facility link = fMgr.getFacility(ind);
	            		   
	            		   if (link.getFacName().equals(linkName)) { 
	            			   linkNodeVal = link.getNodeVal();
	            		   }
	            	   }
	            	   
	            	   network.updateVal(tempNodeVal, linkNodeVal, linkDist);
	            	   network.updateParentVals(tempNodeVal, linkNodeVal);	            	   
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkName = currentElement.getElementsByTagName("LinkName3").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkDist = Integer.parseInt(currentElement.getElementsByTagName("LinkDist3").item(0).getTextContent());
	            	   tempFacility.addToLinks(linkName, linkDist);
	            	   
	            	   for (int ind = 0; ind < fMgrSize; ind++) { 
	            		   Facility link = fMgr.getFacility(ind);
	            		   
	            		   if (link.getFacName().equals(linkName)) { 
	            			   linkNodeVal = link.getNodeVal();
	            		   }
	            	   }
	            	   
	            	   network.updateVal(tempNodeVal, linkNodeVal, linkDist);
	            	   network.updateParentVals(tempNodeVal, linkNodeVal);
	            	   
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkName = currentElement.getElementsByTagName("LinkName4").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkDist = Integer.parseInt(currentElement.getElementsByTagName("LinkDist4").item(0).getTextContent());
	            	   tempFacility.addToLinks(linkName, linkDist);
	            	   
	            	   for (int ind = 0; ind < fMgrSize; ind++) { 
	            		   Facility link = fMgr.getFacility(ind);
	            		   
	            		   if (link.getFacName().equals(linkName)) { 
	            			   linkNodeVal = link.getNodeVal();
	            		   }
	            	   }
	            	   
	            	   network.updateVal(tempNodeVal, linkNodeVal, linkDist);
	            	   network.updateParentVals(tempNodeVal, linkNodeVal);
	            	   
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkName = currentElement.getElementsByTagName("LinkName5").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   linkDist = Integer.parseInt(currentElement.getElementsByTagName("LinkDist5").item(0).getTextContent());
	            	   tempFacility.addToLinks(linkName, linkDist);
	            	   
	            	   for (int ind = 0; ind < fMgrSize; ind++) { 
	            		   Facility link = fMgr.getFacility(ind);
	            		   
	            		   if (link.getFacName().equals(linkName)) { 
	            			   linkNodeVal = link.getNodeVal();
	            		   }
	            	   }
	            	   
	            	   network.updateVal(tempNodeVal, linkNodeVal, linkDist);
	            	   network.updateParentVals(tempNodeVal, linkNodeVal);
	            	   
	               }
	               catch(NullPointerException e){ }
	            }
	            	          }
	      } catch (Exception e) {
	         e.printStackTrace();
	   }
		return network;
	}
	
	/**
	 * @return
	 */
	public OrderMgr parseOrder() { 
   	 	OrderMgr mgr = OrderMgrData.newOrderMgr();

	      try {
	    	 OrderItem tempOrderItem = null;
	    	 Order tempOrder = null;
		     String itemName = null;
		     int itemQuan;
		     
	         File file = new File("Orders.xml");
	         
	         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	         DocumentBuilder db = dbf.newDocumentBuilder();
	         Document doc = db.parse(file);
	         
	         doc.getDocumentElement().normalize();
	         NodeList nodeList = doc.getElementsByTagName("record");
	         
	         for (int i = 0; i < nodeList.getLength(); i++) {
	        	 
	            Node currentNode = nodeList.item(i);
	                     
	            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element currentElement = (Element) currentNode;
	                        
	               String orderNum = currentElement.getElementsByTagName("OrderNum").item(0).getTextContent();	               
	               int startDate = Integer.parseInt(currentElement.getElementsByTagName("Time").item(0).getTextContent());
	               String dest = currentElement.getElementsByTagName("Destination").item(0).getTextContent();
	               String priority = currentElement.getElementsByTagName("Priority").item(0).getTextContent();
	               
	               tempOrder = OrderData.newOrder(orderNum, startDate, dest, priority);
	               
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item1").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity1").item(0).getTextContent());
	            	   tempOrderItem = OrderData.newOrderItem(itemName, itemQuan);
	            	   tempOrder.addOrderItem(tempOrderItem);              
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item2").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity2").item(0).getTextContent());
	            	   tempOrderItem = OrderData.newOrderItem(itemName, itemQuan);
	            	   tempOrder.addOrderItem(tempOrderItem);  
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item3").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity3").item(0).getTextContent());
	            	   tempOrderItem = OrderData.newOrderItem(itemName, itemQuan);
	            	   tempOrder.addOrderItem(tempOrderItem);  
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item4").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity4").item(0).getTextContent());
	            	   tempOrderItem = OrderData.newOrderItem(itemName, itemQuan);
	            	   tempOrder.addOrderItem(tempOrderItem);  
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemName = currentElement.getElementsByTagName("Item5").item(0).getTextContent();
	               }
	               catch(NullPointerException e){ }
	               try{
	            	   itemQuan = Integer.parseInt(currentElement.getElementsByTagName("Quantity5").item(0).getTextContent());
	            	   tempOrderItem = OrderData.newOrderItem(itemName, itemQuan);
	            	   tempOrder.addOrderItem(tempOrderItem);  
	               }
	               catch(NullPointerException e){ }
	            }
	            mgr.addOrder(tempOrder);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }	
	      
	      return mgr;
		}
}
