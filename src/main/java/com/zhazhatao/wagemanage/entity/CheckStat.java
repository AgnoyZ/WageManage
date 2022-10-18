package com.zhazhatao.wagemanage.entity;

public class CheckStat {
    private Integer checkId;

    private String employeeId;

    private String employeeName;

    private Short overtimeDay;

    private Short evectionDay;

    private Short absentDay;

    private Short lateDay;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
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

    public Short getOvertimeDay() {
        return overtimeDay;
    }

    public void setOvertimeDay(Short overtimeDay) {
        this.overtimeDay = overtimeDay;
    }

    public Short getEvectionDay() {
        return evectionDay;
    }

    public void setEvectionDay(Short evectionDay) {
        this.evectionDay = evectionDay;
    }

    public Short getAbsentDay() {
        return absentDay;
    }

    public void setAbsentDay(Short absentDay) {
        this.absentDay = absentDay;
    }

    public Short getLateDay() {
        return lateDay;
    }

    public void setLateDay(Short lateDay) {
        this.lateDay = lateDay;
    }

    @Override
    public String toString() {
        return "CheckStat{" +
                "checkId=" + checkId +
                ", employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", overtimeDay=" + overtimeDay +
                ", evectionDay=" + evectionDay +
                ", absentDay=" + absentDay +
                ", lateDay=" + lateDay +
                '}';
    }
}
