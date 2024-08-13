package najah.edu.acceptance;



	

	import java.util.Scanner;

	public class SweetManagementSystem {
	    

	private static void manageUserAccounts(Scanner scanner) {
	    System.out.println("Managing User Accounts...");
	    // Implementation for managing user accounts
	}

	private static void monitoringAndReporting(Scanner scanner) {
	    System.out.println("Monitoring Profits and Generating Reports...");
	    // Implementation for monitoring and reporting
	}

	private static void contentManagement(Scanner scanner) {
	    System.out.println("Managing Content...");
	    // Implementation for content management
	}

	private static void manageProducts(Scanner scanner) {
	    System.out.println("Managing Products...");
	    // Implementation for product management
	}

	private static void communicationAndNotification(Scanner scanner) {
	    System.out.println("Communicating and Handling Notifications...");
	    // Implementation for communication and notifications
	}

	private static void manageAccount(Scanner scanner) {
	    System.out.println("Managing Account Details...");
	    // Implementation for account management
	}

	private static void orderManagement(Scanner scanner) {
	    System.out.println("Managing Orders...");
	    // Implementation for order management
	}

	private static void manageUserAccount(Scanner scanner) {
	    System.out.println("Managing Personal User Account...");
	    // Implementation for user account management
	}

	private static void explorationAndPurchase(Scanner scanner) {
	    System.out.println("Exploring and Purchasing...");
	    // Implementation for exploration and purchase
	}

	private static void communicationAndFeedback(Scanner scanner) {
	    System.out.println("Communicating and Providing Feedback...");
	    // Implementation for communication and feedback

	}

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to the Sweet Management System!");
	        
	        while (true) {
	            System.out.println("\nSelect your role:");
	            System.out.println("1. Admin");
	            System.out.println("2. Store Owner");
	            System.out.println("3. Raw Material Supplier");
	            System.out.println("4. Beneficiary User");
	            System.out.println("5. Exit");
	            
	            System.out.print("Enter the number corresponding to your role: ");
	            String roleChoice = scanner.nextLine();
	            
	            switch (roleChoice) {
	                case "1":
	                    adminDashboard(scanner);
	                    break;
	                case "2":
	                    storeOwnerDashboard(scanner);
	                    break;
	                case "3":
	                    supplierDashboard(scanner);
	                    break;
	                case "4":
	                    beneficiaryUserDashboard(scanner);
	                    break;
	                case "5":
	                    System.out.println("Exiting the system. Goodbye!");
	                    scanner.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	    
	    private static void adminDashboard(Scanner scanner) {
	        System.out.println("\n--- Admin Dashboard ---");
	        while (true) {
	            System.out.println("1. Manage User Accounts");
	            System.out.println("2. Monitoring and Reporting");
	            System.out.println("3. Content Management");
	            System.out.println("4. Logout");
	            
	            System.out.print("Enter your choice: ");
	            String adminChoice = scanner.nextLine();
	            
	            switch (adminChoice) {
	                case "1":
	                    // Call method to manage user accounts
	                    manageUserAccounts(scanner);
	                    break;
	                case "2":
	                    // Call method to monitor profits and generate reports
	                    monitoringAndReporting(scanner);
	                    break;
	                case "3":
	                    // Call method to manage content
	                    contentManagement(scanner);
	                    break;
	                case "4":
	                    System.out.println("Logging out of Admin Dashboard...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void storeOwnerDashboard(Scanner scanner) {
	        System.out.println("\n--- Store Owner Dashboard ---");
	        while (true) {
	            System.out.println("1. Product Management");
	            System.out.println("2. Communication and Notification");
	            System.out.println("3. Account Management");
	            System.out.println("4. Order Management");
	            System.out.println("5. Logout");
	            
	            System.out.print("Enter your choice: ");
	            String ownerChoice = scanner.nextLine();
	            
	            switch (ownerChoice) {
	                case "1":
	                    // Call method to manage products
	                    manageProducts(scanner);
	                    break;
	                case "2":
	                    // Call method for communication and notifications
	                    communicationAndNotification(scanner);
	                    break;
	                case "3":
	                    // Call method to manage account details
	                    manageAccount(scanner);
	                    break;
	                case "4":
	                    // Call method to manage orders
	                    orderManagement(scanner);
	                    break;
	                case "5":
	                    System.out.println("Logging out of Store Owner Dashboard...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void supplierDashboard(Scanner scanner) {
	        System.out.println("\n--- Raw Material Supplier Dashboard ---");
	        while (true) {
	            System.out.println("1. Product Management");
	            System.out.println("2. Communication and Notification");
	            System.out.println("3. Account Management");
	            System.out.println("4. Order Management");
	            System.out.println("5. Logout");
	            
	            System.out.print("Enter your choice: ");
	            String supplierChoice = scanner.nextLine();
	            
	            switch (supplierChoice) {
	                case "1":
	                    // Call method to manage products
	                    manageProducts(scanner);
	                    break;
	                case "2":
	                    // Call method for communication and notifications
	                    communicationAndNotification(scanner);
	                    break;
	                case "3":
	                    // Call method to manage account details
	                    manageAccount(scanner);
	                    break;
	                case "4":
	                    // Call method to manage orders
	                    orderManagement(scanner);
	                    break;
	                case "5":
	                    System.out.println("Logging out of Raw Material Supplier Dashboard...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void beneficiaryUserDashboard(Scanner scanner) {
	        System.out.println("\n--- Beneficiary User Dashboard ---");
	        while (true) {
	            System.out.println("1. Manage User Account");
	            System.out.println("2. Exploration and Purchase");
	            System.out.println("3. Communication and Feedback");
	            System.out.println("4. Logout");
	            
	            System.out.print("Enter your choice: ");
	            String userChoice = scanner.nextLine();
	            
	            switch (userChoice) {
	                case "1":
	                    // Call method to manage user account
	                    manageUserAccount(scanner);
	                    break;
	                case "2":
	                    // Call method for exploration and purchase
	                    explorationAndPurchase(scanner);
	                    break;
	                case "3":
	                    // Call method for communication and feedback
	                    communicationAndFeedback(scanner);
	                    break;
	                case "4":
	                    System.out.println("Logging out of Beneficiary User Dashboard...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	}

