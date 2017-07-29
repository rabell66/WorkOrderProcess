public class WorkOrder {
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getDescripton() {
      return descripton;
   }

   public void setDescripton(String descripton) {
      this.descripton = descripton;
   }

   public String getSenderName() {
      return senderName;
   }

   public void setSenderName(String senderName) {
      this.senderName = senderName;
   }

   public Status getStatus() {
      return status;
   }

   public void setStatus(Status status) {
      this.status = status;
   }

   String id;
   String descripton;
   String senderName;
   Status status;

   @Override
   public String toString() {
      return "Sender:\t" + this.senderName+"\n Description:\t" + this.descripton +"\n Reference #:\t" + this.id +
              "\n Status:\t" + this.status;
   }
}
