package com.springapp.mvc.model.business;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class InsuranceCompany {

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private double approvalRating;

    public InsuranceCompany(double approvalRating) {
        this.approvalRating = approvalRating;
    }

    public double getApprovalRating() {
        return approvalRating;
    }

    public void setApprovalRating(double approvalRating) {
        this.approvalRating = approvalRating;
    }
}
