package com.Furkann.UserAdminn.Controller;

import com.Furkann.UserAdminn.DTO.RegisterDto;
import com.Furkann.UserAdminn.Model.entity.AccountEntity;
import com.Furkann.UserAdminn.Service.impl.AccountUserServiceImpl;
import jakarta.validation.Valid;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountUserController {
    @Lazy
    private final AccountUserServiceImpl service;
    @Autowired
    public AccountUserController(AccountUserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String regis(Model model){
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("register",registerDto);
        return "from/register";
    }
    @PostMapping("/register/user")
    public String saveUser(@Valid @ModelAttribute("register")
                           RegisterDto registerDto, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("register",registerDto);
            return "from/register";
        }
        AccountEntity existingUser = service.findByEmail(registerDto.getEmail());
        if (existingUser != null){
            bindingResult.rejectValue("email",null,"User already use!!" + existingUser);
        }
        service.save(registerDto);
        return "redirect:/login";
    }
}