package amdegregorio.modelmapperexample.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amdegregorio.modelmapperexample.ModelMapperExampleApplication;
import amdegregorio.modelmapperexample.code.Code;

@Controller
public class ItemController {
   
   private Map<String, String> typeOptions;
   private Map<String, String> locationOptions;
   private ModelMapper modelMapper;
   
   @Autowired
   public ItemController(ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
      this.modelMapper.addMappings(itemMap);
      this.modelMapper.addMappings(itemDtoMap);
   }
   
   
   @RequestMapping("/")
   public String displayItem(Model model) {
      List<Item> items = new ArrayList<Item>(ModelMapperExampleApplication.storedItems.values());
      List<ItemDTO> itemDtos = items.stream().map(item -> modelMapper.map(item, ItemDTO.class)).collect(Collectors.toList());
      model.addAttribute("items", itemDtos);
      return "item/listItems";
   }
   
   @RequestMapping(value="/addItem", method=RequestMethod.GET)
   public String addItem(ItemDTO itemDto, Model model) {
      model.addAttribute("action", "addItem");
      return "item/itemEntry";
   }
   
   @RequestMapping(value="/addItem", params={"save"}, method=RequestMethod.POST)
   public String saveItem(@Valid ItemDTO itemDto, BindingResult bindingResult,
         Model model) {
      System.out.println(itemDto.toString());
      if (bindingResult.hasErrors()) {
         return "item/itemEntry";
      }
      Item item = modelMapper.map(itemDto, Item.class);
      item.setId(new Double(Math.random() * 100).longValue());
      while (ModelMapperExampleApplication.storedItems.containsKey(Long.valueOf(item.getId()))) {
         item.setId(new Double(Math.random() * 100).longValue());
      }
      ModelMapperExampleApplication.storedItems.put(Long.valueOf(item.getId()), item);
      return "redirect:/";
   }
   
   @RequestMapping(value="/addItem", params={"cancel"}, method=RequestMethod.POST)
   public String cancelItem() {
      return "redirect:/";
   }

   /**
    * Gets typeOptions.
    * @return the typeOptions
    */
   @ModelAttribute("itemTypeOptions")
   public Map<String, String> getTypeOptions() {
      if (typeOptions == null) {
         typeOptions = new HashMap<String, String>();
         for (Code code : ModelMapperExampleApplication.typeCodes) {
            typeOptions.put(code.getCodeValue(), code.getShortDescription());
         }
      }
      return typeOptions;
   }
   
   /**
    * Gets locationOptions.
    * @return the locationOptions
    */
   @ModelAttribute("locationOptions")
   public Map<String, String> getLocationOptions() {
      if (locationOptions == null) {
         locationOptions = new HashMap<String, String>();
         for (Code code :ModelMapperExampleApplication.locationCodes) {
            locationOptions.put(code.getCodeValue(), code.getShortDescription());
         }
      }
      return locationOptions;
   }
   
   //Add model mapper configurations here
   /**
    * Converter for converting a string CodeValue on the DTO into a Code object with type SIZE_UNIT
    */
   Converter<String, Code> itemTypeCodeConverter = new Converter<String, Code>() {
      public Code convert(MappingContext<String, Code> context) {
         Code itemTypeCode = null;
         for (Code code : ModelMapperExampleApplication.storedCodes) {
            if (code.getCodeType().equals(ModelMapperExampleApplication.ITEM_TYPE_CODE) 
                     && code.getCodeValue().equals(context.getSource())) {
               itemTypeCode = code;
               break;
            }
         }
         return itemTypeCode;
      }
   };
   
   /**
    * Converter for converting a string CodeValue on the DTO into a Code object with type PRODUCT_DATE_TYPE
    */
   Converter<String, Code> locationCodeConverter = new Converter<String, Code>() {
      public Code convert(MappingContext<String, Code> context) {
         Code locationCode = null;
         for (Code code : ModelMapperExampleApplication.storedCodes) {
            if (code.getCodeType().equals(ModelMapperExampleApplication.LOCATION_CODE) 
                     && code.getCodeValue().equals(context.getSource())) {
               locationCode = code;
               break;
            }
         }
         return locationCode;
      }
   };
   
   /**
    * Mapping for converting String Code Keys from ItemDTO to Code objects.
    * To use:
    * modelMapper.addMappings(itemMap);
    * 
    */
   PropertyMap<ItemDTO, Item> itemMap = new PropertyMap<ItemDTO, Item>() {
      protected void configure() {
         using(itemTypeCodeConverter).map(source.getItemType()).setItemTypeCode(null);
         using(locationCodeConverter).map(source.getLocation()).setLocationCode(null);
      }
   };
   
   /**
    * Converter for converting a into a String CodeKey on the DTO
    */
   Converter<Code, String> codeToStringConverter = new Converter<Code, String>() {
      public String convert(MappingContext<Code, String> context) {
         return (context.getSource()!= null? context.getSource().getCodeValue():"");
      }
   };
   
   /**
    * Converter for converting a into a String Short Description on the DTO
    */
   Converter<Code, String> codeToStringDescConverter = new Converter<Code, String>() {
      public String convert(MappingContext<Code, String> context) {
         return (context.getSource()!= null? context.getSource().getShortDescription():"");
      }
   };
   
   /**
    * Mapping for converting Code objects into String Code Keys on ItemDto.
    * To use:
    * modelMapper.addMappings(itemDtoMap);
    * 
    */
   PropertyMap<Item, ItemDTO> itemDtoMap = new PropertyMap<Item, ItemDTO>() {
      protected void configure() {
         using(codeToStringDescConverter).map(source.getItemTypeCode()).setItemType(null);
         using(codeToStringDescConverter).map(source.getLocationCode()).setLocation(null);
      }
   };
   
}
