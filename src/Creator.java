import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class Creator {

    public void createWorkOrders() {

        WorkOrder workOrder = new WorkOrder();
           String senderName = workOrder.senderName;
           String orderDescription =workOrder.descripton;
           String orderNumber = workOrder.id;
           String status = String.valueOf(workOrder.status);
        Scanner tanner = new Scanner(System.in);
        System.out.println("Sender Name");
        senderName=tanner.nextLine();


        boolean moreOrders =true;
        int newId = 0;
        while (moreOrders) {
            orderNumber =  senderName+ 1;
            System.out.println("Description of Work Order");
            workOrderDescription(workOrder, newId, tanner, orderDescription, orderNumber);
            System.out.println("Is there another order Y/N");
            moreOrders = isThereAnotherOrder(tanner);
            jsonMapper(workOrder);


            System.out.printf("Order #: %s \nSender Name:  %s\n\t Work order:  %s\n\t Work order ID:  %s\n\t Work order Status:  %s\n\n",
                   orderNumber ,senderName, orderDescription, orderNumber, status);
        }
        System.out.println("it worked");

    }

    private boolean isThereAnotherOrder(Scanner tanner) {
        char answer = (tanner.next().toLowerCase().charAt(0));
        return   answer == 'y' ? true:false;

    }

    private void workOrderDescription(WorkOrder workOrder, int newId, Scanner tanner,String orderDescription,
                                      String orderNumber) {
        newId ++;
        orderDescription = tanner.nextLine();
        orderNumber = workOrder.senderName + Integer.toString(newId);

    }

    private void jsonMapper(WorkOrder workOrder) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(workOrder.id);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Creator creator = new Creator();
        creator.createWorkOrders();
    }




}