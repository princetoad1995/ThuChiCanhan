package com.princetoad.costmanagement.Common;

/**
 * Created by PRINCE D. TOAD on 4/16/2017.
 */

public class Constant {
    public static class TABLE_ACCOUNT{
        public static final String TABLE_ACCOUNT_NAME = "account";
        public static final String ACCOUNT_ID = "id";
        public static final String ACCOUNT_NAME = "name";
        public static final String ACCOUNT_USER = "user";
    }

    public static class TABLE_EXPENSE{
        public static final String TABLE_EXPENSE_NAME = "expense";
        public static final String EXPENSE_ID = "id";
        public static final String EXPENSE_NAME = "name";
        public static final String EXPENSE_TYPE_EXPENSE = "expenseType";
    }

    public static class TABLE_TYPE_EXPENSE{
        public static final String TABLE_TYPE_EXPENSE_NAME = "type_expense";
        public static final String TYPE_EXPENSE_ID = "id";
        public static final String TYPE_EXPENSE_NAME = "name";
        public static final String TYPE_EXPENSE_EXPENSE = "expense";
    }

    public static class TABLE_USER{
        public static final String USER_ID = "id";
        public static final String USER_NAME = "username";
        public static final String USER_PASS = "password";
        public static final String USER_ACCOUNT = "account";
    }
}
