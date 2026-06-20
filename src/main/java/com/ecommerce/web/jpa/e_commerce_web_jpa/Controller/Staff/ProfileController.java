package com.ecommerce.web.jpa.e_commerce_web_jpa.Controller.Staff;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.web.jpa.e_commerce_web_jpa.Entities.Staff;
import com.ecommerce.web.jpa.e_commerce_web_jpa.Entities.Enum.Role;
import com.ecommerce.web.jpa.e_commerce_web_jpa.Service.Staff.StaffService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final StaffService staffService;

    @GetMapping(path = "/profileemployee")
    public ModelAndView getPageProfile(@CookieValue String id) {

        Staff byId = staffService.findById(id);

        if (!byId.getRole().equals(Role.STAFF)) {

            return new ModelAndView("staff/Hr/profilePage", Map.of(
                    "staff", byId));
        } else {
            return new ModelAndView("staff/profilePage", Map.of(
                    "staff", byId));
        }

    }

}
