import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class ElevatorMenuParentClass {
	// Scanner
	Scanner sc = new Scanner(System.in);
	
	private final Random rand = new Random(); // ifall man skulle börja på olika -roulette(kan vara roligt att ha kvar)
	// våningar
	

	// variable
	private int floor;
	private int actualFloor = 0;
	private int counter = 0;
	private int nextFloor;
	private int checkLevels;
	private String elevatorName;
	private final static int maxFloor = 26;
	private final static int minFloor = 1;
	private final static String goDown = null;
	private final static String goUP = null;

	// //constructor
	public ElevatorMenuParentClass(int nextFloor,int actualFloor,String elevatorName) {
		this.setStart_floor(nextFloor);
		this.setActualFloor(actualFloor);
		this.setElevatorName(elevatorName);

	} // Below this point is methods and setters,getters,tostring(override)

	public String getElevatorName() {
		return elevatorName;
	}

	public void setElevatorName(String elevatorName) {
		this.elevatorName = elevatorName;
	}

	ElevatorMainClass miskMain = new ElevatorMainClass();

	public ElevatorMainClass getMiskElevator() {
		return miskMain;
	}

	public ElevatorMainClass getMiskMain() {
		return miskMain;
	}

	public void setMiskMain(ElevatorMainClass miskMain) {
		this.miskMain = miskMain;
	}

	public void setMiskElevator(ElevatorMainClass miskElevator) {
		this.miskMain = miskElevator;
	}
	
	// helpmenu method
	void helpmenu() {
		System.out.println("|=================================|\r\n" + "|----------| HELP MENU |----------|\r\n"
				+ "|=================================|\r\n" + "\r\n"
				+ "[1]-Help menu and info about your system \" You are here now!, you can read about the elevator\r\n"
				+ "[2]-GO DOWN: between 1-26, Exit the elevator by pressing 0\r\n"
				+ "[3]-GO DOWN: between 1-26, Exit the elevator by pressing 0\\r\\n "
				+ "[4]-Hit this number to Call on the elevator,wherever you are \r\n"
				+ "[5]-Change elevator name\r\n"
				+ "[6]-Elevator roulette- you dare to let destiny make your choice? \n" 
				+ "[7]-Check Max floor - you will se the number of max floor " 
				+ "[8]-Check Min floor -  you will se the number of min floor " 
				+ "[9]-Fire alarm: if fire in building press here, the elevator will be out of order after you pressed the alarm\r\n"
				+ "[0]-{ Open The door\\nExit the elevator }: open the door and step out to the beautiful world and have a nice day!\r\n"
				+ "\r\n" + "|============================================================|\r\n"
				+ "|------------------------------------------------------------|\r\n"
				+ "|  Press the Fire alarm and help is coming by pressing num 6 |\r\n"
				+ "|------------------------ WARNING ---------------------------|\r\n"
				+ "|------------ elevator will be out of service ---------------|\r\n"
				+ "|============================================================|\r\n" 
				+ "\r\n" + "Good to know:\r\n"
				+ "This Elevator has 26 floor \r\n" 
				+ "Floor: 1-26.\r\n" 
				+ "Lobby is on nr: 1.\n" 
				+ "Rooftop is on nr: 26." 
				+ "\r\n"
				+ "|====================== INFO ABOUT Elevator projekt ========================|\r\n");
		System.out.println("Current elevator name:");
		System.out.println(getElevatorName());
		System.out.println("info about elevator class: ");
		System.out.println(miskMain.toString());
		// System.out.println(ElevatorMainClass.getMiskElevator());
		System.out.println();
		System.out.println("|====================== INFO ABOUT YOUR SYSTEM ========================|\r\n");
		System.out.printf("%-5s %5s %5s%n", "|====== Computer Name is: ",(System.getProperty("user.name")), "======|");
		Properties p = System.getProperties();
		Enumeration<Object> keys = p.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = (String) p.get(key);
			System.out.println(key + ": " + value);
		}

	}
	
	// elevator Roulette elevatorRoulette
	void elevatorRoulette() {
		final Random rand = new Random();
		int floor = rand.nextInt(26) + 1;
		int x = 0;

		do {
			System.out.println("Elevator Roulette does it magic...");
			try {
				nextFloor =floor;
				Thread.sleep(1000);
				System.out.println("Your final destination will soon be shown.");
				setActualFloor(nextFloor);
				Thread.sleep(1000);// 2000ms = 2s
				System.out.println("… Elevator Roulette in progress.....");
				Thread.sleep(1000);// 2000ms = 2s
				System.out.println("… Elevator Roulette in progress.....");
				Thread.sleep(2000);// 2000ms = 2s
				System.out.println("Elevator Roulette are finished.....");
				Thread.sleep(1000);
				System.out.println("pling … at floor: " + actualFloor);

				Thread.sleep(1000);
				System.out.println();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		} while (x == floor);

		elevatorMenu();
	}

	// setter,getters
	public int getFloor() {
		return floor;
	}

	public int setFloor(int floor) {
		return this.floor = floor;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	// goUPmethod
	String goUP() {
		while (true) {
			try {

				System.out.println("Wich floor you wanna go to(UP?) to?: ");

				if (sc.hasNextInt()) {
					nextFloor = sc.nextInt();

					if (getActualFloor() == nextFloor) {
						System.out.println("You are alreday on this floor");
						goUP();
					}

					if (getActualFloor() < 0 || nextFloor > 26) {
						System.out.println("This elevator only contains floors beetween 1-26");
						goUP();
					} else if (nextFloor <= 26 && nextFloor > 0) {
						System.out.println("The elevator is on it's way up...");
						Thread.sleep(1000);// 2000ms = 2s

						for (counter = nextFloor; nextFloor >= actualFloor; actualFloor++)

							try {

								System.out.println("pling … at floor: " + actualFloor);
								Thread.sleep(1000);// 2000ms = 2s
							} catch (InterruptedException e) {
								System.out.println(e);
							}

						setActualFloor(nextFloor);
						Thread.sleep(1000);// 2000ms = 2s
						System.out.println("You Have Reached Your final Destination!");
					}
					elevatorMenu();
				}

			} catch (Exception e) {
				System.out.println("Invalid input try again\nMust be a Integer!");

			}
		}
	}

	@Override
	public String toString() {
		return "ElevatorMenuParentClass [sc=" + sc + ", rand=" + rand + ", floor=" + floor + ", actualFloor="
				+ actualFloor + ", counter=" + counter + ", nextFloor=" + nextFloor + ", checkLevels=" + checkLevels
				+ ", elevatorName=" + elevatorName + ", miskMain=" + miskMain + ", getElevatorName()="
				+ getElevatorName() + ", getMiskElevator()=" + getMiskElevator() + ", getMiskMain()=" + getMiskMain()
				+ ", getFloor()=" + getFloor() + ", getCounter()=" + getCounter() + ", goUP()=" + goUP() + ", getSc()="
				+ getSc() + ", getNextFloor()=" + getNextFloor() + ", getActualFloor()=" + getActualFloor()
				+ ", getStart_floor()=" + getStart_floor() + ", getRand()=" + getRand() + ", getCheckLevels()="
				+ getCheckLevels() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	/// downmethod
	void goDown() {
		while (true) {
			try {

				System.out.println("Wich floor you wanna go to(DOWN?) to?: ");

				if (sc.hasNextInt()) {
					nextFloor = sc.nextInt();

					if (getActualFloor() == nextFloor) {

						System.out.println("You are alreday on this floor");
						goDown();
					}

					if (getActualFloor() < 0 || nextFloor > 26) {
						System.out.println("This elevator only contains floors beetween 1-26");
						goDown();
					} else if (nextFloor <= 26 && nextFloor > 0) {
						System.out.println("The elevator is on it's way down...");
						Thread.sleep(100);// 2000ms = 2s

						for (counter = nextFloor + 1; nextFloor <= actualFloor; actualFloor--)
							try {

								System.out.println("pling … at floor: " + (actualFloor));
								Thread.sleep(1000);// 2000ms = 2s
							} catch (InterruptedException ex) {
							}

						setActualFloor(nextFloor);
						Thread.sleep(1000);// 2000ms = 2s
						System.out.println("You Have Reached Your final Destination!");
					}
					elevatorMenu();
				}

			} catch (Exception e) {
				System.out.println("Invalid input try again\nMust be a Integer!");

			}
		}
	}

// get setters
	public int getNextFloor() {
		return nextFloor;
	}

	public void setNextFloor(int nextFloor) {
		this.nextFloor = nextFloor;
	}

	// METHOD   
	void elevatorMenu() {
		while (true) {
			try {
				Thread.sleep(50);// 2000ms = 2s
				System.out.println();
	System.out.printf("%-5s %5s %5s%n", "|====== WELCOME ",(System.getProperty("user.name")), "======|");
	System.out.printf("%-5s %5s %5s%n", "|= Elevator name: ",getElevatorName(),  " =|");
	System.out.println(   "|=============================|"
	                    + "\n|------  Elevator Menu -------|"
						+ "\n|=============================|" 
				        + "\n[1]-Help menu and info about your system "
						+ "\n[2]-GO UP: "
						+ "\n[3]-GO DOWN: " 
						+ "\n[4]-Call on the elevator " 
						+ "\n[5]-Change elevator name\\ "
						+ "\n[6]-Elevator roulette " 
						+ "\n[7]-Check Max floor " 
						+ "\n[8]-Check Min floor " 
						+ "\n[9]-Fire alarm "
						+ "\n[0]-{Open The door} Exit the elevator } " 
						+ "\n|===================================|"
						+ "\n|-----------------------------------|" 
						+ "\n|FireAlarm will diable the elevator!|"
						+ "\n|---- Emergency Use Only!! ---------|" 
						+ "\n|===================================|");
				System.out.println();
				Thread.sleep(1000);// 2000ms = 2s
				System.out.println("Your current floor is:  " + nextFloor);

				int elevatorMenu;
				System.out.println("What you wanna do: ");

				System.out.print("-");
				Thread.sleep(50);
				System.out.print("-");
				Thread.sleep(50);
				System.out.print(">");
				Thread.sleep(50);
				System.out.print(">");
				Thread.sleep(50);
				System.out.print("-");
				Thread.sleep(50);
				System.out.print(">");
				Thread.sleep(50);
				System.out.print(">");
				System.out.print("-");
				Thread.sleep(50);
				System.out.print("-");
				Thread.sleep(50);
				System.out.print(">");
				Thread.sleep(50);
				System.out.print(">\t");

				// Valen i menu
				elevatorMenu = Integer.parseInt(sc.next());

				switch (elevatorMenu) {

				case 1:
					helpmenu();
					break;
				case 2:

					goUP();
					break;
				case 3:
					goDown();
					break;
				case 4:
					// Call on the elevator
					start();
					break;
				case 5:
					// change elevator name
					changeElevatorName();
					break;
				case 6:
					// elevator roulette
					elevatorRoulette();
					break;
				case 7:
					// check maxfloor
					checkMaxFloor();
					break;
				case 8:
					// check minfloor
					checkMinFloor();
					break;

				case 9:
					// fire alarm
					fireAlarm();
					break;
				case 0:
					System.out.println("Doors open....\nExit the elevator");
					System.out.println("Have a nice day!");
					Thread.sleep(50);
					System.out.println("\tBye....");
					Thread.sleep(50);
					System.out.println("\t\tBye....");
					System.exit(0);
					break;
				default:
					System.out.println("No such option in menu");
					System.out.println("\t try again........");
					break;

				}
			} catch (Exception e) {
				System.out.println("Invalid input try again\nMust be a Integer!");

			}
		}

	}

	void fireAlarm() throws InterruptedException {
		System.out.print("D");
		Thread.sleep(50);
		System.out.print("A");
		Thread.sleep(50);
		System.out.print("N");
		Thread.sleep(50);
		System.out.print("G");
		Thread.sleep(50);
		System.out.print("E");
		Thread.sleep(50);
		System.out.print("R");
		Thread.sleep(50);
		System.out.print(" ");
		Thread.sleep(50);
		System.out.print("D");
		Thread.sleep(50);
		System.out.print("A");
		Thread.sleep(50);
		System.out.print("N");
		Thread.sleep(50);
		System.out.print("G");
		Thread.sleep(50);
		System.out.print("E");
		Thread.sleep(50);
		System.out.print("R\n");
		Thread.sleep(50);  
		System.out.println("You must exit the building now!");
		Thread.sleep(50);
		System.out.println("Doors open\nExit the elevator");
		Thread.sleep(100);
		System.out.print("D");
		Thread.sleep(50);
		System.out.print("A");
		Thread.sleep(50);
		System.out.print("N");
		Thread.sleep(50);
		System.out.print("G");
		Thread.sleep(50);
		System.out.print("E");
		Thread.sleep(50);
		System.out.print("R\n");
		Thread.sleep(50);
		System.out.println("You must exit the building now!");
		Thread.sleep(50);
		System.out.println("Leave the elevator and take the stairs");
		Thread.sleep(300);
		System.out
				.println
				("|----------------- WARNING --------------|\n"
		       + "|--- elevator will be out of service ----|\n"
		        +"|----------------- WARNING --------------|");
		System.exit(0);

	}
	void changeElevatorName() throws InterruptedException{
		while (true) {
			try {
				 System.out.print ("Name the elevator: ");
				 setElevatorName(sc.next());
					System.out.println("The elevators name is now:");
					Thread.sleep(200);// 2000ms = 2s
					System.out.println(getElevatorName());
					Thread.sleep(100);// 2000ms = 2s
			}
					 catch (Exception e) {
							System.out.println("Invalid input try again\nMust be a Integer!");
						}
						elevatorMenu();
					}
			
			
	}

//Start Method    elevatorName
	void start() {

		while (true) {
			try {
				System.out.printf("%-5s %5s %5s%n", "|====== WELCOME",(System.getProperty("user.name")), "======|");
				 System.out.print ("For continue without given elevator name press[RETURN]\n");
				 System.out.print ("Name your elevator: ");
				 setElevatorName(sc.nextLine());
					System.out.println("The elevators name is now:");
					Thread.sleep(200);// 2000ms = 2s
					System.out.println(getElevatorName());
					Thread.sleep(1000);// 2000ms = 2s
					System.out.println("This can be changed whenever you wanna in Elevator Menu settings.\n");
					Thread.sleep(1000);// 2000ms = 2s
					
				System.out.println("Press floor number your at to get the elevator to you.\nPress [0] to get the elevator menu.");
				if (sc.hasNextInt()) {
					nextFloor = sc.nextInt();
					Thread.sleep(100);// 2000ms = 2s
					
					if (nextFloor < 0 || nextFloor > 26) {
						System.out.println("This elevator only contains floors beetween 1-26");
						start();
					} else if (nextFloor <= 26 && nextFloor > 0) {
						Thread.sleep(100);
						System.out.print("The elevator will arrive soon...\n");
						Thread.sleep(1000);// 2000ms = 2s
						setActualFloor(nextFloor);
						System.out.print("P");
						Thread.sleep(100);
						System.out.print("l");
						Thread.sleep(100);
						System.out.print("e");
						Thread.sleep(100);
						System.out.print("a");
						Thread.sleep(100);
						System.out.print("s");
						Thread.sleep(100);
						System.out.print(" ");
						Thread.sleep(100);
						System.out.print("w");
						Thread.sleep(100);
						System.out.print("a");
						Thread.sleep(100);
						System.out.print("i");
						Thread.sleep(100);
						System.out.print("t\n");
						Thread.sleep(100);
						Thread.sleep(100);
						System.out.print("\tP");
						Thread.sleep(100);
						System.out.print("l");
						Thread.sleep(100);
						System.out.print("e");
						Thread.sleep(100);
						System.out.print("a");
						System.out.print("s");
						System.out.print(" ");
						Thread.sleep(100);
						System.out.print("w");
						Thread.sleep(100);
						System.out.print("a");
						Thread.sleep(100);
						System.out.print("i");
						Thread.sleep(100);
						System.out.print("t\n");
						Thread.sleep(100);
						System.out.println("\nPling! The elevator has arrived\nfloor: " + (getActualFloor()));
						Thread.sleep(100);// 2000ms = 2s
						System.out.println();
						}

				}
			} catch (Exception e) {
				System.out.println("Invalid input try again\nMust be a Integer!");
			}
			elevatorMenu();
		}
						
	}

// Ternary  operator - conditional  expression
	void checkMaxFloor() throws InterruptedException {
		getMaxfloor();
		getMinfloor();

		checkLevels = getMaxfloor() > getMinfloor() ? getMaxfloor() : getMinfloor();
		Thread.sleep(50);
		System.out.println("This elevator has: " + checkLevels + " as max floor\nFloor no: 26 is the rooftopp");
		Thread.sleep(50);
		elevatorMenu();

	}

	void checkMinFloor() throws InterruptedException {
		getMaxfloor();
		getMinfloor();

		checkLevels = getMaxfloor() < getMinfloor() ? getMaxfloor() : getMinfloor();
		Thread.sleep(50);
		System.out.println("This elevator has: " + checkLevels + " as min floor\nFloor no:1 is the Lobby");
		Thread.sleep(50);
		elevatorMenu();

	}

	public static String getGodown() {
		return goDown;
	}

	public static String getGoup() {
		return goUP;
	}

	public int getActualFloor() {
		return actualFloor;
	}

	public void setActualFloor(int actualFloor) {
		this.actualFloor = actualFloor;
	}

	public int getStart_floor() {
		return nextFloor;
	}

	public void setStart_floor(int start_floor) {
		this.nextFloor = start_floor;
	}

	public Random getRand() {
		return rand;
	}

	public int getCheckLevels() {
		return checkLevels;
	}

	public void setCheckLevels(int checkLevels) {
		this.checkLevels = checkLevels;
	}

	public static int getMaxfloor() {
		return maxFloor;
	}

	public static int getMinfloor() {
		return minFloor;
	}

	/// END below this point is the class declarations closing Braces

}
