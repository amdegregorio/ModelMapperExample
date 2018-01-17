package amdegregorio.modelmapperexample.code;

public class Code {
   private Long id;
   private String codeType;
   private String codeValue;
   private String shortDescription;
   private String longDescription;
   
   public Long getId() {
      return id;
   }
   
   public void setId(Long id) {
      this.id = id;
   }
   
   public String getCodeType() {
      return codeType;
   }

   public void setCodeType(String codeType) {
      this.codeType = codeType;
   }

   public String getCodeValue() {
      return codeValue;
   }
   
   public void setCodeValue(String codeValue) {
      this.codeValue = codeValue;
   }
   
   public String getShortDescription() {
      return shortDescription;
   }
   
   public void setShortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
   }
   
   public String getLongDescription() {
      return longDescription;
   }
   
   public void setLongDescription(String longDescription) {
      this.longDescription = longDescription;
   }
}
