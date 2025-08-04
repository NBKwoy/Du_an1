/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duan1.dao;

import java.util.List;


public interface BaocaodoanhthuDAO extends CrudDAO<BaoCaoDoanhThu, Integer> {
    List<BaoCaoDoanhThu> findByThang(int thang, int nam);
}