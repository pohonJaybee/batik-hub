package com.ecommerce.web.jpa.e_commerce_web_jpa.Controller.Member;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.web.jpa.e_commerce_web_jpa.Entities.Produk;
import com.ecommerce.web.jpa.e_commerce_web_jpa.Service.Produk.ProdukService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class BuyProductController {

    @Autowired
    private ProdukService produkService;

    private Map<String, Object> unpackedProdukDetail(Produk produkId) {
        Map<String, Object> productDetail = new HashMap<>();
        productDetail.put("id", produkId.getId());
        productDetail.put("nama", produkId.getNama());
        productDetail.put("harga", produkId.getHarga());
        productDetail.put("stock", produkId.getStock());
        productDetail.put("category", produkId.getProductCategory());

        if (produkId.getGambar() != null && produkId.getGambar().length > 0) {
            String gambarAsli = Base64.getEncoder().encodeToString(produkId.getGambar());
            productDetail.put("gambar", gambarAsli);
        } else {
            productDetail.put("gambar", null);
        }

        return productDetail;
    }

    @PostMapping("/buyproduct")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView getPageBuyProduct(@RequestParam String idProduk) {

        Produk produkId = produkService.findById(idProduk);

        Map<String, Object> unpackedProdukDetail = unpackedProdukDetail(produkId);

        return new ModelAndView("visitor/buyPage", Map.of(
                "produkId", unpackedProdukDetail));
    }
}
