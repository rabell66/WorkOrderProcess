import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Creator {
    public static void main(String args[]) {
        Creator creator = new Creator();
        creator.createWorkOrders();
    }



    public void createWorkOrders() {
        boolean waitingForNewUser = true;
        WorkOrder workOrder = new WorkOrder();
        String status = String.valueOf(workOrder.status);
        Scanner tanner = new Scanner(System.in);
        Scanner scanner = new Scanner((System.in));
        while (waitingForNewUser) {
            System.out.println("Sender Name");

            workOrder.setSenderName(tanner.nextLine());
            boolean moreOrders = true;
            int newId = 0;
            while (moreOrders) {
                newId++;
                System.out.println("Description of Work Order");
                workOrder.setDescripton(tanner.nextLine());
                workOrder.setId(workOrder.senderName + Integer.toString(newId));
                System.out.printf("Order #: %s \nSender Name:  %s\n\t Work order:  %s\n\t Work order ID:  %s\n\t Work order Status:  %s\n\n",
                        newId, workOrder.senderName, workOrder.descripton, workOrder.id, workOrder.status);
                jsonMapper(workOrder);
                System.out.println("Is there another order Y/N");
                moreOrders = isThereAnotherOrder(scanner);


            }

        }
    }

    private boolean isThereAnotherOrder(Scanner scanner) {
        char answer = (scanner.next().toLowerCase().charAt(0));
        return   answer == 'y' ? true:false;

    }

    private void jsonMapper(WorkOrder workOrder) {
        String json = "";
        String fileName = workOrder.id + ".json";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(workOrder);
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        try {
            File file = new File(fileName);

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}