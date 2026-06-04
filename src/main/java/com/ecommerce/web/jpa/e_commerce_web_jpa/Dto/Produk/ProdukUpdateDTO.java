package com.ecommerce.web.jpa.e_commerce_web_jpa.Dto.Produk;

import lombok.Data;

@Data
public class ProdukUpdateDTO {

    private String id;

    private String nama;

    private Integer stock;

    private double harga;

    private String productCategory;

    private byte[] gambar;
}
