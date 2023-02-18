package com.example.calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Plate {

    private double diameter_min;
    private double diameter_max;
    private double feed_length;
    private double skip_epe;
    private double skip_laminated;
    private final double step_epe = 300;
    private final double step_laminated = 250;
    private double epe_kszt;
    private double laminated_kszt;
    private double epe_kszt_h;
    private double laminated_kszt_h;



    public Plate(double diameter_min, double diameter_max, double feed_length, double skip_epe, double skip_laminated) {
        this.diameter_min = diameter_min;
        this.diameter_max = diameter_max;
        this.feed_length = feed_length;
        this.skip_epe = skip_epe;
        this.skip_laminated = skip_laminated;
        kszt_mb_epe();
        kszt_mb_laminated();
        kszt_h_epe();
        kszt_h_laminated();
    }

    @Override
    public String toString() {
        return "Plate{" +
                "diameter_min=" + diameter_min +
                ", diameter_max=" +diameter_max +
                ", feed_length=" + feed_length +
                ", skip_epe=" + skip_epe +
                ", skip_laminated=" + skip_laminated +
                ", step_epe=" + step_epe +
                ", step_laminated=" + step_laminated +
                ", epe_kszt=" + epe_kszt +
                ", laminated_kszt=" + laminated_kszt +
                ", epe_kszt_h=" + epe_kszt_h +
                ", laminated_kszt_h=" + laminated_kszt_h +
                '}';
    }

    private void kszt_mb_epe(){
        this.epe_kszt= Math.round(((this.skip_epe/(this.feed_length/1000))/1000)*1000)/1000.0;
    }
    private void kszt_mb_laminated(){

        this.laminated_kszt =  Math.round(((this.skip_laminated/(this.feed_length/1000))/1000)*1000)/1000.0;
    }
    private void kszt_h_epe(){
        this.epe_kszt_h = (((step_epe*skip_epe)*60)/1000);
    }
    private void kszt_h_laminated(){
        this.laminated_kszt_h = (((step_laminated*skip_epe)*60)/1000);
    }

    public double getDiameter_min() {
        return diameter_min;
    }

    public double getDiameter_max() {
        return diameter_max;
    }

    public double getFeed_length() {
        return feed_length;
    }

    public double getSkip_epe() {
        return skip_epe;
    }

    public double getSkip_laminated() {
        return skip_laminated;
    }

    public double getStep_epe() {
        return step_epe;
    }

    public double getStep_laminated() {
        return step_laminated;
    }

    public double getEpe_kszt() {
        return epe_kszt;
    }

    public double getLaminated_kszt() {
        return laminated_kszt;
    }

    public double getEpe_kszt_h() {
        return epe_kszt_h;
    }

    public double getLaminated_kszt_h() {
        return laminated_kszt_h;
    }
}
