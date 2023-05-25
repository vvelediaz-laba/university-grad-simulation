package com.solvd.universitygradsimulation;

import com.solvd.universitygradsimulation.interfaces.Clearable;

import java.util.ArrayList;

public class StaffDirectory implements Clearable {
    private ArrayList<Staff> staff;

    public StaffDirectory() {
        staff = new ArrayList<>();
    }

    public StaffDirectory(Staff[] staff){
        this.staff = new ArrayList<>();
        for(Staff staffMember : staff){
            this.staff.add(staffMember);
        }
    }

    public void addStaff(Staff staffMember) {
            staff.add(staffMember);
        }

    public void removeStaff(Staff staffMember) {
        staff.remove(staffMember);

    }

    public Staff findStaffById(String id) {
        for (Staff staffMember : staff) {
            if (staffMember.getId().equals(id)) {
                return staffMember;
            }
        }
        return null;
    }

    public Staff[] getStaff() {
        Staff[] staffArr = new Staff[staff.size()];
        staffArr = staff.toArray(staffArr);
        return staffArr;
    }

    @Override
    public void clear() {
        staff.clear();
    }
}

