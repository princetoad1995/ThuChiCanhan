package com.princetoad.costmanagement.Common;

/**
 * Created by PRINCE D. TOAD on 4/16/2017.
 */

public class Constant {

    public static class SHARED_PREFERENCE {
        public static final String REMEMBER = "remember";
    }

    public static class INTENT{
        public static final int REQUEST_CODE_DESCRIPTION = 1;
        public static final int RESULT_CODE_DESCRIPTION = 2;

        public static final int REQUEST_CODE_ACCOUNT = 3;
        public static final int RESULT_CODE_ACCOUNT = 4;

        public static final int REQUEST_CODE_EXPENSE = 5;
        public static final int RESULT_CODE_EXPENSE = 6;
    }

    public static class TABLE_ACCOUNT{
        public static final String TABLE_ACCOUNT_NAME = "account";
        public static final String ACCOUNT_ID = "id";
        public static final String ACCOUNT_NAME = "name";
        public static final String ACCOUNT_USER = "user";
        public static final String ACCOUNT_MONEY = "money";
        public static final String ACCOUNT_CHECK = "check";
    }

    public static class TABLE_EXPENSE{
        public static final String TABLE_EXPENSE_NAME = "expense";
        public static final String EXPENSE_ID = "id";
        public static final String EXPENSE_NAME = "name";
        public static final String EXPENSE_TYPE_EXPENSE = "expenseType";
        public static final String EXPENSE_CHECK = "check";
        public static final String EXPENSE_MANAGE = "manage";
    }

    public static class TABLE_TYPE_EXPENSE{
        public static final String TABLE_TYPE_EXPENSE_NAME = "type_expense";
        public static final String TYPE_EXPENSE_ID = "id";
        public static final String TYPE_EXPENSE_NAME = "name";
        public static final String TYPE_EXPENSE_EXPENSE = "expense";
        public static final String TYPE_EXPENSE_CHECK = "check";
        public static final String TYPE_EXPENSE_MANAGE = "manage";
    }

    public static class TABLE_USER{
        public static final String TABLE_USER_NAME = "user";
        public static final String USER_ID = "id";
        public static final String USER_NAME = "username";
        public static final String USER_PASS = "password";
        public static final String USER_ACCOUNT = "account";
        public static final String USER_MANAGE = "manage";
    }

    public static class TABLE_MANAGE{
        public static final String TABLE_MANAGE_NAME = "manage";
        public static final String MANAGE_ID = "id";
        public static final String MANAGE_TYPE = "type";
        public static final String MANAGE_USER = "user";
        public static final String MANAGE_MONEY = "money";
        public static final String MANAGE_EXPENSE = "expense";
        public static final String MANAGE_TYPE_EXPENSE = "type_expense";
        public static final String MANAGE_DESCRIPTION = "discription";
        public static final String MANAGE_ACCOUNT = "account";
        public static final String MANAGE_DATE = "date";
        public static final String MANAGE_HOUR = "hour";
    }
}
