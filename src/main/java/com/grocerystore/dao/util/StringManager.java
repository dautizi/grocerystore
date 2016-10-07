package com.grocerystore.dao.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class StringManager {

    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_ISO8859_1 = "ISO-8859-1";

    public static String Left(String text, int length) {
        return (text.length() < length) ? text : text.substring(0, length);
    }

    public static String Right(String text, int length) {
        return (text.length() < length) ? text : text.substring(text.length() - length, length);
    }

    public static String Mid(String text, int start, int end) {
        return (text.length() < end + 1) ? text.substring(start, text.length() - 1) : text.substring(start, end);
    }

    public static String Mid(String text, int start) {
        return (text.length() < start + 1) ? "" : text.substring(start, text.length() - start);
    }

    public static String stringFromByte(byte b) {
        return new String(new byte[] { b });
    }

    public static byte[] decodeBASE64(String dato) {
        byte[] buffer = null;
        try {
            BASE64Decoder decode = new BASE64Decoder();
            buffer = decode.decodeBuffer(dato);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static String encodeBASE64(String dato) {
        String buffer = null;
        try {
            BASE64Encoder encode = new BASE64Encoder();
            buffer = encode.encodeBuffer(dato.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static byte[] bytesFromHexString(String hexString) {
        if (hexString.length() % 2 > 0) {
            hexString = "0" + hexString;
        }
        int arrayLen = hexString.length() / 2;
        byte[] byteArray = new byte[arrayLen];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = (byte) Integer.parseInt(hexString.substring(2 * i, 2 * i + 2), 16);
        }
        return byteArray;
    }

    public static String hexStringFromBytes(byte[] byteArray) {
        String hexString = "";
        for (int jj = 0; jj < byteArray.length; jj++) {
            int decValue = new Byte(byteArray[jj]).intValue() & 0x000000ff;
            hexString += align(Integer.toHexString(decValue), 2, "0");
        }
        return hexString;
    }

    public static String align(String s, int len, String c) {
        String bf = s;
        if (s.length() > len) {
            bf = s.substring(0, len);
        }
        while (bf.length() < len) {
            bf = c + bf;
        }
        return bf;
    }

    public static String alignString_left(float f, int len) {
        return alignString_left(valuta(f), len, " ");
    }

    public static String alignString_left(int f, int len) {
        return alignString_left("" + f, len, " ");
    }

    public static String alignString_left(String s, int len) {
        return alignString_left(s, len, " ");
    }

    public static String alignString_left(String s, int len, String c) {
        String bf = s;
        if (s.length() > len) {
            bf = s.substring(0, len);
        }
        while (bf.length() < len) {
            bf = bf + c;
        }
        return bf;
    }

    public static String alignString_right(float f, int len) {
        return alignString_right(valuta(f), len, " ");

    }

    public static String alignString_right(int f, int len) {
        return alignString_right("" + f, len, " ");
    }

    public static String alignString_right(int f, int len, String c) {
        return alignString_right("" + f, len, c);
    }

    public static String alignString_right(String s, int len) {
        return alignString_right(s, len, " ");
    }

    public static String alignString_right(String s, int len, String c) {
        String bf = s;
        if (s.length() > len) {
            bf = s.substring(0, len);
        }
        while (bf.length() < len) {
            bf = c + bf;
        }
        return bf;
    }

    public static String valuta(int num) {
        String h1 = (new Integer(num)).toString();
        if (num < 0)
            h1 = h1.substring(1, h1.length());
        int p1 = h1.length() % 3;
        String bf = h1.substring(0, p1);
        while (p1 + 3 <= h1.length()) {
            bf = bf + (p1 > 0 ? "." : "") + h1.substring(p1, p1 + 3);
            p1 = p1 + 3;
        }
        if (num < 0)
            bf = "-" + bf;
        return bf;
    }

    public static String valuta(long num) {
        String h1 = (new Long(num)).toString();
        if (num < 0)
            h1 = h1.substring(1, h1.length());
        int p1 = h1.length() % 3;
        String bf = h1.substring(0, p1);
        while (p1 + 3 <= h1.length()) {
            bf = bf + (p1 > 0 ? "." : "") + h1.substring(p1, p1 + 3);
            p1 = p1 + 3;
        }
        if (num < 0)
            bf = "-" + bf;
        return bf;
    }

    public static String valuta(float num) {
        long l = (long) num;
        String h1 = (new Long(l)).toString();
        if (num < 0)
            h1 = h1.substring(1, h1.length());
        int p1 = h1.length() % 3;
        String bf = h1.substring(0, p1);
        while (p1 + 3 <= h1.length()) {
            bf = bf + (p1 > 0 ? "." : "") + h1.substring(p1, p1 + 3);
            p1 = p1 + 3;
        }
        if (num < 0)
            bf = "-" + bf;
        return bf;
    }

    public static String toValutaCent(int valuta) {
        String ret = "" + valuta;
        if (valuta > 0) {
            ret = ret.substring(0, ret.length() - 2) + "." + ret.substring(ret.length() - 2, ret.length());
        }
        return ret;
    }

    /**
     * Dump to standard output any blob with hex offset at any line start hex
     * blob data grouped into 16 byte segment ASCII conversion of printable
     * characters (print a dot if not printable)
     * 
     * @param byte[] blob byte array to dump
     * @return String Total dump string
     */
    public static String dumpBlob(byte[] blob) {
        String sLine = new String();
        for (int i = 0; i < blob.length;) {
            StringBuffer line = new StringBuffer();
            line.append("\n");
            // print line offset in the blob
            // add four leading zero's
            int ofsLen = Integer.toHexString(i).length();
            if (ofsLen < 4) {
                ofsLen = 4 - ofsLen;
                for (; ofsLen > 0; --ofsLen)
                    line.append("0");
            }
            line.append(Integer.toHexString(i) + " - ");
            // print blob data as two hex characters
            int j;
            for (j = 0; j < 16; ++j, ++i) {
                if (i < blob.length) {
                    int valueLen = Integer.toHexString(blob[i]).length();
                    if (valueLen < 2) {
                        valueLen = 2 - valueLen;
                        for (; valueLen > 0; --valueLen)
                            line.append("0");
                        line.append(Integer.toHexString(blob[i]));
                    } else {
                        if (valueLen > 2) {
                            line.append(Integer.toHexString(blob[i]).substring(valueLen - 2, valueLen));
                        } else {
                            line.append(Integer.toHexString(blob[i]));
                        }
                    }
                    line.append(" ");
                } else {
                    line.append("   ");
                }
            }
            i = i - j;
            for (j = 0; j < 16; ++j, ++i) {
                if (i < blob.length) {
                    if (blob[i] < 128 & blob[i] > 31) {
                        char ch = (char) blob[i];
                        line.append(ch);
                    } else {
                        line.append(".");
                    }
                } else {
                    line.append("  ");
                }
            }
            sLine = sLine + line;
        }
        return sLine;
    }

    public static String dumpException(Exception e) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n\n" + e.getClass().getName() + ": " + e.getMessage() + "\n");
        for (int i = 0; i < e.getStackTrace().length; i++) {
            stringBuffer.append("\tat " + e.getStackTrace()[i] + "\n");
        }
        return stringBuffer.toString();
    }

    public static String dumpException(Throwable e) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n\n" + e.getClass().getName() + ": " + e.getMessage() + "\n");
        for (int i = 0; i < e.getStackTrace().length; i++) {
            stringBuffer.append("\tat " + e.getStackTrace()[i] + "\n");
        }
        return stringBuffer.toString();
    }

    public static byte[] getBuffer(byte[] buffer, int fixedLength) {
        byte[] mybuffer = new byte[fixedLength];
        int len = (buffer.length > fixedLength ? fixedLength : buffer.length);
        System.arraycopy(buffer, 0, mybuffer, 0, len);
        return mybuffer;
    }

    public static String getTimeString(short anno, short mese, short giorno, short ora, short min, short sec) {
        String key = new Formatter().format("%1$04d%2$02d%3$02d %4$02d:%5$02d:%6$02d", anno, mese, giorno, ora, min, sec).toString();
        return key;
    }

    public static String getDataString(short anno, short mese, short giorno) {
        String key = new Formatter().format("%1$04d%2$02d%3$02d", anno, mese, giorno).toString();
        return key;
    }

    public static String getStringFromBytes(byte[] array) {
        String ret = new String(array);
        return ret;
    }

    public static String replaceSpecialChar(String strToBeReplaced) {
        return strToBeReplaced.replaceAll("[^ -~]", " ");
    }

    public static String getEmptyFromNull(String value) {
        String ret = value;
        if (value == null)
            ret = "";
        return ret;
    }

    public static String getNullFromEmpty(String value) {
        String ret = value;
        if (value.equals(""))
            ret = null;
        return ret;
    }

    public static Short convertStringToShort(String value) {
        short ret = 0;
        if (value == null || value.equals("")) {
            ret = Short.valueOf(value);
        }
        return ret;
    }

    public static String bytesToString(byte[] dati) {
        String s = "";
        for (int i = 0; i < dati.length; i++) {
            s += (i > 0 ? "," + dati[i] : dati[i]);
        }
        return s;
    }

    public static String intArrayToString(int[] dati) {
        String s = "";
        for (int i = 0; i < dati.length; i++) {
            s += (i > 0 ? "," + dati[i] : dati[i]);
        }
        return s;
    }

    public static String shortArrayToString(short[] dati) {
        String s = "";
        for (int i = 0; i < dati.length; i++) {
            s += (i > 0 ? "," + dati[i] : dati[i]);
        }
        return s;
    }

    public static String readFile(String filePath) {
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
                contents.append(text).append(System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException e) {
            return ""; // file not found
        } catch (IOException e) {
            return ""; // error I/O
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                ; // errore I/O file enclosure
            }
        }

        return contents.toString();
    }

    public static String removeLast(String str) {
        final char LF = '\n';
        final char CR = '\r';

        if (str == null) {
            return null;
        }
        int strLen = str.length();
        if (strLen < 2) {
            return "";
        }
        int lastIdx = strLen - 1;
        String ret = str.substring(0, lastIdx);
        char last = str.charAt(lastIdx);
        if (last == LF) {
            if (ret.charAt(lastIdx - 1) == CR) {
                return ret.substring(0, lastIdx - 1);
            }
        }
        return ret;
    }

    public static String toAsciiString(String stringa) {
        Charset c = Charset.forName("US-ASCII");
        CharsetDecoder dc = c.newDecoder();
        CharsetEncoder ec = c.newEncoder();
        ec.onUnmappableCharacter(CodingErrorAction.IGNORE);
        String ret = stringa;
        try {
            ByteBuffer buf1 = ec.encode(CharBuffer.wrap(stringa));
            CharBuffer buf2 = dc.decode(buf1);
            ret = buf2.toString();
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String md5(String value) {
        String s = value;
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(s.getBytes(), 0, s.length());
        // System.out.println("MD5: "+new
        // BigInteger(1,m.digest()).toString(16));
        return new BigInteger(1, m.digest()).toString(16);
    }

    public static String convertCharset(String value, String chSrc, String chTarget) {
        byte[] newString = {};
        try {
            newString = new String(value.getBytes(), chSrc).getBytes(chTarget);
            return new String(newString);
        } catch (Exception e) {
            return "";
        }
    }

    public static String getCurrCharset() {
        return System.getProperty("file.encoding");
    }

    public static String getKeytranWithCodiceConto(String codiceConto, short titolare, String idTransazione) {
        String data = new SimpleDateFormat("yyMMdd").format(new Date());
        String key = new Formatter().format("%1$6s%2$16s%3$02d%4$15s", data, codiceConto, titolare, idTransazione).toString();
        if (key.length() < 40) {
            int value = key.length();
            int numero = 40 - value;
            for (int i = 0; i < numero; i++)
                key += "0";
        }

        key = key.replaceAll(" ", "0");

        return key;
    }

    public static String byteArrayToString(byte[] arrayBYTE) {
        String value = "";
        for (int i = 0; i < arrayBYTE.length; i++) {
            if (String.valueOf(arrayBYTE[i]).length() == 1) {
                value += "0" + arrayBYTE[i];
            } else if (String.valueOf(arrayBYTE[i]).length() == 0) {
                value += "00";
            } else {
                value += String.valueOf(arrayBYTE[i]);
            }
        }
        return value;
    }

    public static String padString(String s, int len) {
        String bf = s;
        if (s.length() > len) {
            bf = s.substring(0, len);
        }
        while (bf.length() < len) {
            bf = "0" + bf;
        }
        return bf;
    }

    public static String emptyToNull(String value){
        try {
            if (value.equals("")) {
                return null;
            } else {
                return value;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String fixDataCalendarioJquery(String value) {
        String data = "00/00/0000";
        String ora  = "00:00:00";

        try {
            
            data  = value.split(" ")[0];
            ora  = value.split(" ")[1];

            String hh = ora.split(":")[0];
            String mm = ora.split(":")[1];

            if (hh.length()==1) {
                ora = "0"+hh;
            } else {
                ora = hh;
            }

            if (mm.length() ==1) {
                ora += ":0"+mm;
            } else {
                ora += ":"+mm;
            }

            ora += ":00";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return data + " " + ora;
    }

}