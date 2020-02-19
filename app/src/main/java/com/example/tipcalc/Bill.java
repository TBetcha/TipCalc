package com.example.tipcalc;

import android.widget.EditText;

public class Bill {

    private double tipAmt;
    private double tipPercentage;
    private double billWithOut;
    private double billWith;
    boolean GoodService;
    boolean FastService;
    boolean personable;


    public Bill(){
       this.tipAmt=tipAmt;
       this.billWithOut=billWithOut;

    }

    public void setBillWith(double billWith) {
        this.billWith = billWith;
    }

    public void setBillWithOut(double billWithOut) {
        this.billWithOut = billWithOut;
    }

    public void setTipAmt(double tipAmt) {
        this.tipAmt = tipAmt;
    }

    public void setTipPercentage(double tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    public void setFastService(boolean fastService) {
        this.FastService = fastService;
    }

    public void setGoodService(boolean goodService) {
        this.GoodService = goodService;
    }

    public void setPersonable(boolean personable) {
        this.personable = personable;
    }

    public double getTipAmt() {
        return this.tipAmt/100.0;
    }

    public double getBillWith() {
        return this.billWith;
    }

    public double getBillWithOut() {
        return this.billWithOut;
    }

    public boolean isFastService() {
        return this.FastService;
    }

    public boolean isPersonable() {
        return this.personable;
    }

    public boolean isGoodService() {
        return this.GoodService;
    }

    public double getTipPercentage() {
        return this.tipPercentage;
    }

    public double getTotal(double tip, double bill){
        double totTip = tip * bill;
        return totTip + bill;

    }
}
