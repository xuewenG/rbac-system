package cn.edu.hfut.rbac.backend.entity;

import java.sql.Timestamp;

/**
 * @author xuewenG
 * @date 2019/8/14 15:50
 */
public class StaffPassword {
    private String staffId;
    private String password;
    private Timestamp validStart;
    private Timestamp validEnd;

    @Override
    public String toString() {
        return "StaffPassword{" +
                "staffId='" + staffId + '\'' +
                ", password='" + password + '\'' +
                ", validStart=" + validStart +
                ", validEnd=" + validEnd +
                '}';
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getValidStart() {
        return validStart;
    }

    public void setValidStart(Timestamp validStart) {
        this.validStart = validStart;
    }

    public Timestamp getValidEnd() {
        return validEnd;
    }

    public void setValidEnd(Timestamp validEnd) {
        this.validEnd = validEnd;
    }
}
