package cn.edu.hfut.rbac.backend.util;

import cn.edu.hfut.rbac.backend.entity.StaffRole;

import java.util.HashSet;
import java.util.List;

public class HashSetUtil {

    public HashSetUtil() {
    }

    public static List<StaffRole> getDifferenceList(List<StaffRole> list1, List<StaffRole> list2) {
        HashSet<StaffRole> h1 = new HashSet(list1);
        HashSet<StaffRole> h2 = new HashSet(list2);
        h1.removeAll(h2);
        list1.clear();
        list1.addAll(h1);
        return list1;
    }
}
