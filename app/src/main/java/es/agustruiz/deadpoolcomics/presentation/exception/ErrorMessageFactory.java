package es.agustruiz.deadpoolcomics.presentation.exception;

import android.content.Context;

import java.net.SocketTimeoutException;

import es.agustruiz.deadpoolcomics.data.exception.ComicNotFoundException;
import es.agustruiz.deadpoolcomics.data.exception.NetworkConnectionException;
import es.agustruiz.deadpoolcomics.R;

public class ErrorMessageFactory {

    private ErrorMessageFactory(){
        // Private empty factory
    }

    public static String create(Context context, Exception exception){
        String message;
        if(exception instanceof NetworkConnectionException){
            message = context.getString(R.string.errormsg_no_network);
        }else if(exception instanceof ComicNotFoundException){
            message = context.getString(R.string.errormsg_comic_not_found);
        }else if(exception instanceof SocketTimeoutException){
            message = context.getString(R.string.errormsg_timeout);
        }else{
            //TODO Remove unfriendly info
            message = String.format("%s: %s", context.getString(R.string.errormsg_generic),
                    exception.getMessage());
        }
        return message;
    }

}
