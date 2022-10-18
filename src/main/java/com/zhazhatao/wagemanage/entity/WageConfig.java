package com.zhazhatao.wagemanage.entity;

import java.math.BigDecimal;

public class WageConfig {
    private String duty;

    private BigDecimal baseWage;

    private BigDecimal dayWage;

    private Float overtimeJob;

    private BigDecimal evectionStandard;

    private BigDecimal absentStandard;

    private BigDecimal lateStandard;

    private BigDecimal etcStandard;

    private BigDecimal bonus;

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public BigDecimal getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(BigDecimal baseWage) {
        this.baseWage = baseWage;
    }

    public BigDecimal getDayWage() {
        return dayWage;
    }

    public void setDayWage(BigDecimal dayWage) {
        this.dayWage = dayWage;
    }

    public Float getOvertimeJob() {
        return overtimeJob;
    }

    public void setOvertimeJob(Float overtimeJob) {
        this.overtimeJob = overtimeJob;
    }

    public BigDecimal getEvectionStandard() {
        return evectionStandard;
    }

    public void setEvectionStandard(BigDecimal evectionStandard) {
        this.evectionStandard = evectionStandard;
    }

    public BigDecimal getAbsentStandard() {
        return absentStandard;
    }

    public void setAbsentStandard(BigDecimal absentStandard) {
        this.absentStandard = absentStandard;
    }

    public BigDecimal getLateStandard() {
        return lateStandard;
    }

    public void setLateStandard(BigDecimal lateStandard) {
        this.lateStandard = lateStandard;
    }

    public BigDecimal getEtcStandard() {
        return etcStandard;
    }

    public void setEtcStandard(BigDecimal etcStandard) {
        this.etcStandard = etcStandard;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "WageConfig{" +
                "duty='" + duty + '\'' +
                ", baseWage=" + baseWage +
                ", dayWage=" + dayWage +
                ", overtimeJob=" + overtimeJob +
                ", evectionStandard=" + evectionStandard +
                ", absentStandard=" + absentStandard +
                ", lateStandard=" + lateStandard +
                ", etcStandard=" + etcStandard +
                ", bonus=" + bonus +
                '}';
    }
}
