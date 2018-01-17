package amdegregorio.modelmapperexample.item;


public class ItemDTO {
   private Long id;
   private String itemName = "";
   private String itemDescription = "";
   private String itemType = "";
   private String location = "";
   
   /**
    * Gets id.
    * @return the id
    */
   public Long getId() {
      return id;
   }
   
   /**
    * Sets id.
    * @param id the id to set
    */
   public void setId(Long id) {
      this.id = id;
   }
   
   /**
    * Gets itemName.
    * @return the itemName
    */
   public String getItemName() {
      return itemName;
   }
   
   /**
    * Sets itemName.
    * @param itemName the itemName to set
    */
   public void setItemName(String itemName) {
      this.itemName = itemName;
   }
   
   /**
    * Gets itemDescription.
    * @return the itemDescription
    */
   public String getItemDescription() {
      return itemDescription;
   }
   
   /**
    * Sets itemDescription.
    * @param itemDescription the itemDescription to set
    */
   public void setItemDescription(String itemDescription) {
      this.itemDescription = itemDescription;
   }
   
   /**
    * Gets itemType.
    * @return the itemType
    */
   public String getItemType() {
      return itemType;
   }
   
   /**
    * Sets itemType.
    * @param itemType the itemType to set
    */
   public void setItemType(String itemType) {
      this.itemType = itemType;
   }
   
   /**
    * Gets location.
    * @return the location
    */
   public String getLocation() {
      return location;
   }
   
   /**
    * Sets location.
    * @param location the location to set
    */
   public void setLocation(String location) {
      this.location = location;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "ItemDto{itemName=" + itemName + 
         ", itemDescription='" + itemDescription + '\'' +
         ", itemType='" + itemType + '\'' +
         ", location='" + location + '\'' +
         "}";
   }
}
