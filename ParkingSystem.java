// package parking;

import java.util.*;
import java.util.Map.Entry;

public class ParkingSystem {
	
	static Map<Integer,LinkedList<String>> parkVehicle(String command,int slot,Map<Integer,LinkedList<String>> systemInfo) {
		StringTokenizer token = new StringTokenizer(command," ");
		String inst=token.nextToken();
		if (inst.equals("park")) {
			while(token.hasMoreTokens()) {
				if (!(systemInfo.containsKey(slot))) {
					Integer slotInteger = new Integer(slot);
					systemInfo.put(slotInteger,new LinkedList<String>());
				}
				systemInfo.get(slot).add(token.nextToken());
			}
			System.out.println("-----------------------------------");
			System.out.println("Allocated slot number "+slot);
			System.out.println("-----------------------------------");
		}
		return systemInfo;
	}
	
	static void Parking() {
		String command="",instruction;
		String choice;
		int totalSlots=-1,slotNo,finalSlotGiven=-1;
		Map<Integer,LinkedList<String>> systemData = new TreeMap<Integer,LinkedList<String>>();
		TreeSet<Integer> slotsAvailable = new TreeSet<Integer>();
		System.out.println("Welcome to Parking System");
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		slotNo = 0;
		do {
			System.out.println("Please enter the command for parking system ");
			do{
				command = scanner.nextLine();
			} while(command.equals(""));
			
			StringTokenizer token = new StringTokenizer(command," ");
			instruction = token.nextToken();
			if(instruction.equals("create_parking_lot")) {
				totalSlots = Integer.parseInt((token.nextToken()));
				System.out.println("-----------------------------------");
				System.out.println("Created a parking lot with "+ totalSlots +" slots");
				System.out.println("-----------------------------------");
			} else if(instruction.equals("park")) {
				if(!(slotsAvailable.isEmpty()) ) {
					finalSlotGiven = slotsAvailable.pollFirst();
					systemData = parkVehicle(command,finalSlotGiven,systemData);
				} else if(slotNo != totalSlots) {
					slotNo++;
					finalSlotGiven = slotNo;
					systemData = parkVehicle(command,finalSlotGiven,systemData);
				} else {
					System.out.println("-----------------------------------");
					System.out.println("Sorry, parking lot is full");
					System.out.println("-----------------------------------");
				}
				
				
			} else if(instruction.equals("leave")) {
				int slotFree = Integer.parseInt(token.nextToken());
				systemData.remove(slotFree);
				System.out.println("-----------------------------------");
				System.out.println("Slot number "+slotFree+" is free");
				System.out.println("-----------------------------------");
				slotsAvailable.add(slotFree);
				
			} else if(instruction.equals("status")) {
				System.out.println("-----------------------------------");
				System.out.println("Slot No.\t Registration No \t Color");
				for(Entry<Integer,LinkedList<String>> sysData: systemData.entrySet()) {
					System.out.print(sysData.getKey());
					for(String details: sysData.getValue()) {
						System.out.print("\t\t"+details);
					}
					System.out.println();
				}
				
				System.out.println("-----------------------------------");
				
			} else if(instruction.equals("registration_numbers_for_cars_with_colour")) {
				String colour = token.nextToken();
				boolean found = false;
				System.out.println("-----------------------------------");
				for(Entry<Integer,LinkedList<String>> sysData: systemData.entrySet()) {
					List<String> details= new ArrayList<String>();
					details = sysData.getValue();
					if(details.get(1).equals(colour)) {
						System.out.println(details.get(0)+", ");
						found = true;
					}
				}
				System.out.println("-----------------------------------");
				if(found == false) {
					System.out.println("-----------------------------------");
					System.out.println("Not found");
					System.out.println("-----------------------------------");
				}
				
			} else if(instruction.equals("slot_numbers_for_cars_with_colour")) {
				String colour = token.nextToken();
				boolean found = false;
				System.out.println("-----------------------------------");
				for(Entry<Integer,LinkedList<String>> sysData: systemData.entrySet()) {
					List<String> details= new ArrayList<String>();
					details = sysData.getValue();
					if(details.get(1).equals(colour)) {
						System.out.println(sysData.getKey()+", ");
						found = true;
					}
				}
				System.out.println("-----------------------------------");
				if(found == false) {
					System.out.println("-----------------------------------");
					System.out.println("Not found");
					System.out.println("-----------------------------------");
				}
				
			} else if(instruction.equals("slot_number_for_registration_number")) {
				String regNumber = token.nextToken();
				boolean found = false;
				System.out.println("-----------------------------------");
				for(Entry<Integer,LinkedList<String>> sysData: systemData.entrySet()) {
					List<String> details= new ArrayList<String>();
					details = sysData.getValue();
					if(details.get(0).equals(regNumber)) {
						System.out.println(sysData.getKey());
						found = true;
					}
				}
				System.out.println("-----------------------------------");
				if(found == false) {
					System.out.println("-----------------------------------");
					System.out.println("Not found");
					System.out.println("-----------------------------------");
				}
				
			} else {
				System.out.println("Please Enter the valid command");
			}
			
			System.out.println("Do you want to enter more commands(y/n)?");
			choice = scanner.next();
		}while(choice.equalsIgnoreCase("y"));
	}

	

	public static void main(String[] args) {
		Parking();
}
}

/*
 * create_parking_lot 6
 * park KA-01-HH-1234 white
 * park KA-01-HH-9999 white
 * park KA-01-BB-0001 black
 * park KA-01-HH-7777 red
 * park KA-01-HH-2701 blue
 * park KA-01-HH-3141 black
 * leave 4
 * status
 * park KA-01-p-333 white
 * park DL-12-AA-9999 white
 * registration_numbers_for_cars_with_colour white
 * slot_numbers_for_cars_with_colour white
 * slot_number_for_registration_number KA-01-HH-3141
 * slot_number_for_registration_number MH-04-AY-1111
 * */
