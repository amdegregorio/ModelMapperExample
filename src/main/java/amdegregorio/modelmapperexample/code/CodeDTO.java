package amdegregorio.modelmapperexample.code;

public class CodeDTO {
   private Long id;
   private String codeType = "";
   private String codeValue = "";
   private String shortDescription = "";
   private String longDescription = "";
   
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
    * Gets codeType.
    * @return the codeType
    */
   public String getCodeType() {
      return codeType;
   }
   
   /**
    * Sets codeType.
    * @param codeType the codeType to set
    */
   public void setCodeType(String codeType) {
      this.codeType = codeType;
   }
   
   /**
    * Gets codeValue.
    * @return the codeValue
    */
   public String getCodeValue() {
      return codeValue;
   }
   
   /**
    * Sets codeValue.
    * @param codeValue the codeValue to set
    */
   public void setCodeValue(String codeValue) {
      this.codeValue = codeValue;
   }
   
   /**
    * Gets shortDescription.
    * @return the shortDescription
    */
   public String getShortDescription() {
      return shortDescription;
   }
   
   /**
    * Sets shortDescription.
    * @param shortDescription the shortDescription to set
    */
   public void setShortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
   }
   
   /**
    * Gets longDescription.
    * @return the longDescription
    */
   public String getLongDescription() {
      return longDescription;
   }
   
   /**
    * Sets longDescription.
    * @param longDescription the longDescription to set
    */
   public void setLongDescription(String longDescription) {
      this.longDescription = longDescription;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "CodeDTO{codeType=" + codeType + 
         ", codeValue='" + codeValue + '\'' +
         ", shortDescription='" + shortDescription + '\'' +
         ", longDescription='" + longDescription + '\'' +
         "}";
   }
   
   
}
