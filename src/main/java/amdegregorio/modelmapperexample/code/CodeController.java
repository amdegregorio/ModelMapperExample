package amdegregorio.modelmapperexample.code;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import amdegregorio.modelmapperexample.ModelMapperExampleApplication;

@Controller
public class CodeController {
   
   @RequestMapping("displayCodes")
   public String displayCodes(Model model) {
      List<Code> codes = ModelMapperExampleApplication.storedCodes;
      model.addAttribute("codes", codes);
      return "code/listCodes";
   }
}
