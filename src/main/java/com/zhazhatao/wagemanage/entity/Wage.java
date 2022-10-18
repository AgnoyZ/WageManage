package com.zhazhatao.wagemanage.entity;

import java.math.BigDecimal;

public class Wage {
    private Integer wageId;

    private String employeeId;

    private String employeeName;

    private BigDecimal baseWage;

    private BigDecimal overtimeWage;

    private BigDecimal evectionWage;

    private BigDecimal absentWage;

    private BigDecimal lateWage;

    private BigDecimal etcWage;

    private BigDecimal bonusWage;

    private BigDecimal totalWage;

    public Integer getWageId() {
        return wageId;
    }

    public void setWageId(Integer wageId) {
        this.wageId = wageId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public BigDecimal getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(BigDecimal baseWage) {
        this.baseWage = baseWage;
    }

    public BigDecimal getOvertimeWage() {
        return overtimeWage;
    }

    public void setOvertimeWage(BigDecimal overtimeWage) {
        this.overtimeWage = overtimeWage;
    }

    public BigDecimal getEvectionWage() {
        return evectionWage;
    }

    public void setEvectionWage(BigDecimal evectionWage) {
        this.evectionWage = evectionWage;
    }

    public BigDecimal getAbsentWage() {
        return absentWage;
    }

    public void setAbsentWage(BigDecimal absentWage) {
        this.absentWage = absentWage;
    }

    public BigDecimal getLateWage() {
        return lateWage;
    }

    public void setLateWage(BigDecimal lateWage) {
        this.lateWage = lateWage;
    }

    public BigDecimal getEtcWage() {
        return etcWage;
    }

    public void setEtcWage(BigDecimal etcWage) {
        this.etcWage = etcWage;
    }

    public BigDecimal getBonusWage() {
        return bonusWage;
    }

    public void setBonusWage(BigDecimal bonusWage) {
        this.bonusWage = bonusWage;
    }

    public BigDecimal getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(BigDecimal totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "wageId=" + wageId +
                ", employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", baseWage=" + baseWage +
                ", overtimeWage=" + overtimeWage +
                ", evectionWage=" + evectionWage +
                ", absentWage=" + absentWage +
                ", lateWage=" + lateWage +
                ", etcWage=" + etcWage +
                ", bonusWage=" + bonusWage +
                ", totalWage=" + totalWage +
                '}';
    }
}
