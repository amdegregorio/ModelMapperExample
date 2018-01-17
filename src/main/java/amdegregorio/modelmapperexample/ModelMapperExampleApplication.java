package amdegregorio.modelmapperexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import amdegregorio.modelmapperexample.code.Code;
import amdegregorio.modelmapperexample.item.Item;

@SpringBootApplication
public class ModelMapperExampleApplication {
   public static List<Code> storedCodes;
   public static List<Code> typeCodes;
   public static List<Code> locationCodes;
   public static Map<Long, Item> storedItems;
   public static final String ITEM_TYPE_CODE = "ITEM_TYPE";
   public static final String LOCATION_CODE = "LOCATION";

	public static void main(String[] args) {
	   storedCodes = new ArrayList<Code>();
	   typeCodes = new ArrayList<Code>();
	   locationCodes = new ArrayList<Code>();
	   storedItems = new HashMap<Long, Item>();
	   loadInitialValues();
		SpringApplication.run(ModelMapperExampleApplication.class, args);
	}
	
	public static void loadInitialValues() {
	   Code code = new Code();
	   code.setId(1l);
	   code.setCodeType(ITEM_TYPE_CODE);
	   code.setCodeValue("EQUIPMENT");
	   code.setShortDescription("Equipment");
	   code.setLongDescription("Equipment - Durable");
	   storedCodes.add(code);
	   typeCodes.add(code);
	   Code code2 = new Code();
	   code2.setId(2l);
	   code2.setCodeType(ITEM_TYPE_CODE);
	   code2.setCodeValue("SUPPLY");
	   code2.setShortDescription("Supplies");
	   code2.setLongDescription("Supplies - Consumable");
      storedCodes.add(code2);
      typeCodes.add(code2);
      Code code3 = new Code();
      code3.setId(3l);
      code3.setCodeType(LOCATION_CODE);
      code3.setCodeValue("WH1");
      code3.setShortDescription("Warehouse 1");
      code3.setLongDescription("Warehouse 1");
      storedCodes.add(code3);
      locationCodes.add(code3);
      Code code4 = new Code();
      code4.setId(4l);
      code4.setCodeType(LOCATION_CODE);
      code4.setCodeValue("WH2");
      code4.setShortDescription("Warehouse 2");
      code4.setLongDescription("Warehouse 2");
      storedCodes.add(code4);
      locationCodes.add(code4);
      Item item1 = new Item();
      item1.setId(1l);
      item1.setItemName("Lawn Mower");
      item1.setItemDescription("Self-Propelled Walk Behind Mower");
      item1.setItemTypeCode(code);
      item1.setLocationCode(code3);
      storedItems.put(Long.valueOf(item1.getId()), item1);
	}
}
