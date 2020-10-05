package com.bridgelabz.addressbook;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ContactPerson {
	public static ContactPerson obj = new ContactPerson();
	
	public static Scanner sc = new Scanner(System.in);
	public static Map<String , ArrayList<AddressBook> > map = new HashMap< String, ArrayList<AddressBook>> ();
	
	public static void main(String[] args) {
		System.out.println("Hey Annie");
		String ans = " ";
		while(!(ans.equals("no"))) {
			System.out.println("Give a name for the address book");
			String nameBook = sc.nextLine();
			map.put(nameBook, obj.book());
			System.out.println("Do you want to create an Address Book ? (yes/no) :");
			ans = sc.nextLine();
		}
		obj.displayMap();
	}
	
	
	public ArrayList book () {
		ArrayList<AddressBook> listOfPerson = new ArrayList<AddressBook>();
		System.out.println("Do you want to add person ? (yes/no) :");
		String ansAdd = sc.nextLine();
		if(ansAdd.equals("yes")) 
			listOfPerson = obj.addPerson();
		if(listOfPerson==null)
			return null;
		System.out.println("Do you want to edit any details of any person ? (yes/no) : ");
		String ansEdit = sc.nextLine();
		if(ansEdit.equals("yes"))
			obj.editContact(listOfPerson);
		System.out.println("Do you want to delete a person ? (yes/no) : ");
		String ansDel = sc.nextLine();
		if(ansDel.equals("yes"))
			obj.deleteContact(listOfPerson);
		obj.displayList(listOfPerson);
		return listOfPerson;
	}
	
	public ArrayList addPerson() {
		ArrayList<AddressBook> list = new ArrayList<AddressBook>();
		String answer = " "; 
		while(!(answer.equals("no"))) {
			
			System.out.println("Enter the first name of a person");
			String f_name = sc.nextLine();
			System.out.println("Enter the last name of a person");
			String l_name = sc.nextLine();
			System.out.println("Enter the address");
			String address = sc.nextLine();
			System.out.println("Enter the city");
			String city = sc.nextLine();
			System.out.println("Enter the state");
			String state = sc.nextLine();
			System.out.println("Enter the zip code");
			int zip = sc.nextInt();
			System.out.println("Enter the phone number");
			long ph = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter the email");
			String email = sc.nextLine();
			
			AddressBook book = new AddressBook(f_name,l_name,address,city,state,zip,ph,email);
			list.add(book);
			System.out.println("Do you want to enter more person? (yes/no) : ");
			answer = sc.nextLine();
		}
		return list;
		
	}
	public void editContact(ArrayList<AddressBook> editList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name to edit");
		String name = sc.nextLine();
		
		System.out.println("Enter the field you want to edit");
		String field = sc.nextLine();
		System.out.println("Enter the new value");
		String new_value = sc.nextLine();
		for(AddressBook b : editList) {
			if(name.equalsIgnoreCase(b.getFirst_name())) {
				if(field.equalsIgnoreCase("address")) {
					b.setAddress(new_value);
				}
				else if(field.equalsIgnoreCase("city")) {
					b.setCity(new_value);
				}
				else if(field.equalsIgnoreCase("state")) {
					b.setState(new_value);
				}
				else if(field.equalsIgnoreCase("zip")) {
					int val = Integer.parseInt(new_value);
					b.setZip(val);
				}
				else if(field.equalsIgnoreCase("phone")) {
					long ph = Long.parseLong(new_value);
					b.setPhone(ph);
				}
				else if(field.equalsIgnoreCase("email")) {
					b.setEmail(new_value);
				}
				else
					System.out.println("The name of the field is not correct");
			}
			
		}
	}
	
	public void deleteContact(ArrayList<AddressBook> delList) {
		Scanner sc = new Scanner(System.in);
		Iterator<AddressBook> itr = delList.iterator();
		System.out.println("Enter name of the person to be deleted");
		String del_person = sc.nextLine();
		while(itr.hasNext()) {
			AddressBook book= itr.next();
			if(book.getFirst_name().equalsIgnoreCase(del_person)) {
				itr.remove();
			}
		}
	}
	
	public void displayMap() {
		for(Map.Entry<String, ArrayList<AddressBook>> m : map.entrySet()) {
			System.out.println(m.getKey() );
			for(AddressBook p : m.getValue()){
	            System.out.print(p.getFirst_name()+" "+ p.getLast_name()+" " + p.getAddress()+" "+ p.getCity()+" "+ p.getState()+" "+ p.getZip()+" "+ p.getPhone()+ " " +p.getEmail() + "\n");

	        }
		}
	}
	
	public void displayList(ArrayList<AddressBook> list) {
		for(AddressBook p : list) {
			System.out.println(p.getFirst_name()+" "+ p.getLast_name()+" " + p.getAddress()+" "+ p.getCity()+" "+ p.getState()+" "+ p.getZip()+" "+ p.getPhone()+ " " +p.getEmail());

		}
	}
	
}
