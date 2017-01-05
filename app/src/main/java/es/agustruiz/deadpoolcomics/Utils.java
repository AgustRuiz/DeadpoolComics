package es.agustruiz.deadpoolcomics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import es.agustruiz.deadpoolcomics.presentation.model.ComicPresentation;

@SuppressWarnings("SpellCheckingInspection")
public class Utils {

    public static final String AGUST_TAG = "[A]";

    public static String buildLogTag(String baseName) {
        return baseName + AGUST_TAG;
    }

    public static List<ComicPresentation> getTestComicList() {
        List<ComicPresentation> comicList = new ArrayList<>();
        comicList.add(new ComicPresentation("Uno", null));
        comicList.add(new ComicPresentation("Dos", null));
        comicList.add(new ComicPresentation("Tres", null));
        comicList.add(new ComicPresentation("Cuatro", null));
        comicList.add(new ComicPresentation("Cinco", null));
        comicList.add(new ComicPresentation("Seis", null));
        comicList.add(new ComicPresentation("Siete", null));
        comicList.add(new ComicPresentation("Ocho", null));
        comicList.add(new ComicPresentation("Nueve", null));
        comicList.add(new ComicPresentation("Diez", null));
        comicList.add(new ComicPresentation("Once", null));
        comicList.add(new ComicPresentation("Doce", null));
        comicList.add(new ComicPresentation("Trece", null));
        comicList.add(new ComicPresentation("Catorce", null));
        comicList.add(new ComicPresentation("Quince", null));
        comicList.add(new ComicPresentation("Dieciseis", null));
        comicList.add(new ComicPresentation("Diecisiete", null));
        comicList.add(new ComicPresentation("Dieciocho", null));
        comicList.add(new ComicPresentation("Diecinueve", null));
        comicList.add(new ComicPresentation("Veinte", null));
        return comicList;
    }

    public static boolean isThereInternetConnection(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }

    public static final String md5(final String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
