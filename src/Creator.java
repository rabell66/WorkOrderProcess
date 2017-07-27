import java.util.Scanner;

public class Creator {

        public void createWorkOrders() {
            Scanner tanner = new Scanner;
            System.out.println("Description of Work Order");
            String workOrderDescription = tanner.nextLine();
            System.out.println("Sender Name");

            System.out.println("Status");

        }

        public static void main(String args[]) {
            Creator creator = new Creator();
            creator.createWorkOrders();
        }
    }


    int id;
    String descripton;
    String senderName;
    Status status;