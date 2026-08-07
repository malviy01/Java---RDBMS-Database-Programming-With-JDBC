package com.main;

import com.dao.UserDao;

public class CRUDTest {
    public static void main(String[] args) {

        UserDao dao = new UserDao();

        // 👉 Uncomment ONLY ONE at a time

        // ===== USING STATEMENT =====
        // dao.insertUsingStatement();
        // dao.updateUsingStatement();
        // dao.selectUsingStatement();
        // dao.deleteUsingStatement();

        // ===== USING PREPARED STATEMENT =====
        // dao.insertUsingPrepared();
        // dao.updateUsingPrepared();
        // dao.selectUsingPrepared();
        // dao.deleteUsingPrepared();
    }
}