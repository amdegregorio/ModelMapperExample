package amdegregorio.modelmapperexample.item;

import amdegregorio.modelmapperexample.code.Code;

public class Item {
   private Long id;
   private String itemName;
   private String itemDescription;
   private Code itemTypeCode;
   private Code locationCode;
   
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
    * Gets itemTypeCode.
    * @return the itemTypeCode
    */
   public Code getItemTypeCode() {
      return itemTypeCode;
   }
   
   /**
    * Sets itemTypeCode.
    * @param itemTypeCode the itemTypeCode to set
    */
   public void setItemTypeCode(Code itemTypeCode) {
      this.itemTypeCode = itemTypeCode;
   }
   
   /**
    * Gets locationCode.
    * @return the locationCode
    */
   public Code getLocationCode() {
      return locationCode;
   }
   
   /**
    * Sets locationCode.
    * @param locationCode the locationCode to set
    */
   public void setLocationCode(Code locationCode) {
      this.locationCode = locationCode;
   }

}
