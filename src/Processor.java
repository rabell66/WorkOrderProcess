import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Processor {

    public static void main(String args[]) {
        Processor processor = new Processor();
        processor.processWorkOrders();
    }

    public void processWorkOrders() {
        boolean processOrderLoop = true;

        while (processOrderLoop) {

            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        moveIt(readIt(getFile()));


    }

    private File getFile() {
        File currentDirectory = new File(".");
        File files[] = currentDirectory.listFiles();
        for (File f : files) {
            if (f.getName().endsWith(".json")) {
                File file = new File(f.getName());
                return file;

            }
        }
        return currentDirectory;
    }
    private WorkOrder readIt(File file) {
        // read the json files into WorkOrders and put in map
        ObjectMapper mapper = new ObjectMapper();
        WorkOrder workOrder = null;
        try (Scanner scanner = new Scanner(file)) {
            String workOrderJson = scanner.nextLine();
            System.out.println("Work Order\n\n"+mapper.readValue(workOrderJson, WorkOrder.class)+"\n\n");
            file.delete();
            return mapper.readValue(workOrderJson, WorkOrder.class);
        } catch (JsonParseException e) {
            System.out.println("Caught JsonParseException " + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Caught JsonMappingException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException " + e.getMessage());
        }
        return workOrder;
    }



    private void moveIt(WorkOrder workOrder) {
        // move work orders in map from one state to another
        Set<WorkOrder> workOrders = new HashSet<>();
        workOrders.add(workOrder);
        switch (workOrder.status){
            case INITIAL:
                workOrder.setStatus(Status.ASSIGNED);
            case ASSIGNED:
                workOrder.setStatus(Status.IN_PROGRESS);
            case IN_PROGRESS:
                workOrder.setStatus(Status.DONE);
            case DONE:
        }

    }







}
