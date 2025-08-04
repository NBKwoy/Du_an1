/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duan1.dao;

import java.util.List;

/**
 *
 * @author BA KHANG
 */
public interface QuanlyxuatnhapkhoDAO extends CrudDAO<XuatNhapKho, Long> {
    List<XuatNhapKho> findBySanPham(String maSP);
    List<XuatNhapKho> findByLoai(String loai); // Xuất hoặc Nhập
}