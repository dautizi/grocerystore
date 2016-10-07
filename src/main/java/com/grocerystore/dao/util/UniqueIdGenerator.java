package com.grocerystore.dao.util;

public enum UniqueIdGenerator {

    INSTANCE;
    private String idApp;
    private long prevTime;
    private short counter;

    private UniqueIdGenerator() {
        idApp = padString("", 18);
        prevTime = 0;
        counter = 0;
    }

    public boolean init(String idAppUnivoco) {
        if (idAppUnivoco == null || idAppUnivoco.length() > 18)
            return false;

        idApp = idAppUnivoco;
        return true;
    }

    public String getId() {
        long time = System.currentTimeMillis();
        if (time == prevTime) {
            counter++;
        } else {
            counter = 0;
        }
        prevTime = time;
        return idApp+padString(String.valueOf(counter), 2)+padString(String.valueOf(time), 20);
    }

    private String padString(String s, int len) {
        String bf = s;
        if (s.length() > len) {
            bf = s.substring(0, len);
        }

        while (bf.length() < len) {
            bf = "0" + bf;
        }
        return bf;
    }
}
