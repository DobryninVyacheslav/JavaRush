package ru.lvl19.lecture11.task6;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private List<String> roles;
    private List<String> users;
    private List<String> dates;
    private List<RoleData> roleDataList;

    public Test() {
        roleDataList = Arrays.asList(new RoleData("PromotionNoticeProcess.DEV_ROLE",0),
                new RoleData("Проверить",14),
                new RoleData("Согласовать",27),
                new RoleData("Нормоконтроль",56),
                new RoleData("Утвердить",70));
        this.roles = new ArrayList(Arrays.asList("Нормоконтроль","Согласовать","Согласовать"));
        this.users = new ArrayList(Arrays.asList("1","2","3"));
        this.dates = new ArrayList(Arrays.asList("1","2","3"));
        checkUserData();
    }

    private void checkUserData() {
        if (roles == null || users == null || dates == null) {
            throw new RuntimeException("null exp");
        }
        if (roles.size() != users.size() || roles.size() != users.size()) {
            throw new RuntimeException("not eq");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        List<String> users = test.users;
        StringBuilder addedRoles = new StringBuilder();
        for (int i = 0; i < users.size(); i++) {
            RoleData roleData = test.getRoleData(test.roles.get(i));
            if (roleData == null) {
                continue;
            }
            if (addedRoles.toString().contains(roleData.roleName)) {
                if (roleData.roleName.equals("Согласовать") &&
                        StringUtils.countMatches(addedRoles, "Согласовать") == 1) {
                    roleData.deltaY = roleData.deltaY + 14;
                } else {
                    continue;
                }
            }
            addedRoles.append(roleData.roleName);
            System.out.println(i + ":" + addedRoles);
            System.out.println(roleData.deltaY);
        }
    }
    private RoleData getRoleData(String role) {
        for (RoleData roleData : roleDataList) {
            if (role.contains(roleData.roleName)) {
                return roleData;
            }
        }
        return null;
    }
    class RoleData {
        private String roleName;
        private int deltaY;

        public RoleData(String roleName, int deltaY) {
            this.roleName = roleName;
            this.deltaY = deltaY;
        }
    }
}
