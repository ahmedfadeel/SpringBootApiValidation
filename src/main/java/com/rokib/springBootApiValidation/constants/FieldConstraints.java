package com.rokib.springBootApiValidation.constants;

public class FieldConstraints {

    public class ForUser {
        public static final int MAX_EMAIL_LENGTH = 64;
        public static final int MIN_EMAIL_LENGTH = 4;
        public static final int MAX_FIRST_NAME_LENGTH = 128;
        public static final int MIN_FIRST_NAME_LENGTH = 1;
        public static final int MAX_LAST_NAME_LENGTH = 128;
        public static final int MIN_LAST_NAME_LENGTH = 1;
        public static final int MIN_PASSWORD_LENGTH = 8;
        public static final int MAX_PASSWORD_LENGTH = 32;
        public static final int MAX_ENCRYPTED_PASSWORD_LENGTH = 512;
    }


}
