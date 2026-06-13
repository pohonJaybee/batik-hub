package com.ecommerce.web.jpa.e_commerce_web_jpa.Controller.Member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.web.jpa.e_commerce_web_jpa.Entities.Member;
import com.ecommerce.web.jpa.e_commerce_web_jpa.Entities.Embed.Alamat;
import com.ecommerce.web.jpa.e_commerce_web_jpa.Service.Member.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EditProfileController {

    private final MemberService memberService;

    private Map<String, Object> unpackedDetail(Member member) {

        Alamat alamatMemeber = member.getAlamat();

        Map<String, Object> memberDetail = new HashMap<>();
        memberDetail.put("nama", member.getName());
        memberDetail.put("email", member.getEmail());
        memberDetail.put("jalan", alamatMemeber.getJalan());
        memberDetail.put("kota", alamatMemeber.getKota());
        memberDetail.put("provinsi", alamatMemeber.getProvinsi());

        return memberDetail;
    }

    @GetMapping(path = "/editprofile")
    public ModelAndView getMethodName(@CookieValue(value = "id") String idCookie) {

        Member memberId = memberService.findById(idCookie);

        Map<String, Object> unpackedDetail = unpackedDetail(memberId);

        return new ModelAndView("visitor/editProfilePage", Map.of(
                "member", unpackedDetail));
    }

}
