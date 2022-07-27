package vn.amela.DATABIDING_VALIDATION.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import vn.amela.DATABIDING_VALIDATION.Model.Information;

import javax.validation.Valid;
import java.util.Comparator;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("getForm")
    public String getForm(Model model){
        model.addAttribute("information", new Information());
        return "form";
    }

    @PostMapping("submit")
    public String submit(@Valid Information information, BindingResult bindingResult){
        System.out.println(information);
        if (bindingResult.hasErrors()) {
            var errorStream = bindingResult.getAllErrors().stream();
            errorStream.sorted(Comparator.comparing(ObjectError::getDefaultMessage));
            return "form";
        }
        return "info";
    }
}
