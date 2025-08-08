/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duan1.dao;

import com.mycompany.baocaotonkho.BaoCaoTonKho;
import java.util.List;

/**
 *
 * @author BA KHANG
 */
public interface BaocaotonkhoDAO extends CrudDAO<BaoCaoTonKho, Integer> {
    List<BaoCaoTonKho> findBySanPham(String maSP);
}
