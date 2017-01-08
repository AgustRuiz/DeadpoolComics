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
        comicList.add(new ComicPresentation(1, "Uno", null));
        comicList.add(new ComicPresentation(2, "Dos", null));
        comicList.add(new ComicPresentation(3, "Tres", null));
        comicList.add(new ComicPresentation(4, "Cuatro", null));
        comicList.add(new ComicPresentation(5, "Cinco", null));
        comicList.add(new ComicPresentation(6, "Seis", null));
        comicList.add(new ComicPresentation(7, "Siete", null));
        comicList.add(new ComicPresentation(8, "Ocho", null));
        comicList.add(new ComicPresentation(9, "Nueve", null));
        comicList.add(new ComicPresentation(10, "Diez", null));
        comicList.add(new ComicPresentation(11, "Once", null));
        comicList.add(new ComicPresentation(12, "Doce", null));
        comicList.add(new ComicPresentation(13, "Trece", null));
        comicList.add(new ComicPresentation(14, "Catorce", null));
        comicList.add(new ComicPresentation(15, "Quince", null));
        comicList.add(new ComicPresentation(16, "Dieciseis", null));
        comicList.add(new ComicPresentation(17, "Diecisiete", null));
        comicList.add(new ComicPresentation(18, "Dieciocho", null));
        comicList.add(new ComicPresentation(19, "Diecinueve", null));
        comicList.add(new ComicPresentation(20, "Veinte", null));
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

    public static final String stringJoiner(String separator, List<String> collection) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < collection.size(); ++i) {
            sb.append(collection.get(i));
            if (i < collection.size() - 1){
                sb.append(separator);
            }
        }
        return sb.toString();
    }

}
