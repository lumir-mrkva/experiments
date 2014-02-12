package cz.mrq.experiments;

import org.apache.commons.codec.binary.Base64;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        byte[] key = Signature.generateSecretKey();
        System.out.println(Base64.encodeBase64String(key));


        byte[] sharedKey = Base64.decodeBase64("Nzg1NDM1ODktYjZhZi00ZjIxLWI4ZWMtMTFmY2YyYjY4YTJl");
        String value =
           "243750CD-37CC-45F7-8320-013033EA87271392164639865/webapi/api/v1/servicehello world";
        System.out.println(value);
        System.out.println(Signature.hmacSha1(value,sharedKey));


        //String key2 = "qnscAdgRlkIhAUPY44oiexBKtQbGY0orf7OV1I50";
        //System.out.println(Signature.hmacSha1("foo",key2.getBytes()));
    }






}
