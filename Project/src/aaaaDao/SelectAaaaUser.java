package aaaaDao;
import java.util.List;

import model.AaaaUser;

public class SelectAaaaUser {





    public static void main(String[] args) {
        // employeeテーブルの全レコードを取得
        AaaaUserDao aaaaDao = new AaaaUserDao();
        List<AaaaUser> aaaaList = aaaaDao.findAll();

        // 取得したレコードの内容を出力
        for (AaaaUser aaaa : aaaaList) {
            System.out.println(aaaa.getId());
            System.out.println(aaaa.getLogin_id());
            System.out.println(aaaa.getName());
            System.out.println(aaaa.getBirth_date());
            System.out.println(aaaa.getPossword());
            System.out.println(aaaa.getCreate_date());
            System.out.println(aaaa.getUpdate_date());
        }
    }
}

