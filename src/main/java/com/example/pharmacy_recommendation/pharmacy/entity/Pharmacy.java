package com.example.pharmacy_recommendation.pharmacy.entity;

import com.example.pharmacy_recommendation.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "pharmacy")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Pharmacy extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pharmacyId;

    private String pharmacyName;
    private String pharmacyAddress;
    private double longitude;
    private double latitude;

    public void changePharmacyAddress(String address) {
        this.pharmacyAddress = address;
    }
}
