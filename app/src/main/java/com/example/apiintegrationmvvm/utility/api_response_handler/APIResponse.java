package com.example.apiintegrationmvvm.utility.api_response_handler;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class APIResponse {

    public final Status status;
    public final Integer requestID;

    @Nullable
    public final Object data;

    @Nullable
    public final Exception error;

    @Nullable
    public final Throwable failure;

    private APIResponse(Status status, @Nullable Object data, @Nullable Exception error, @Nullable Throwable failure, @NonNull Integer requestID) {
        this.status = status;
        this.data = data;
        this.error = error;
        this.failure = failure;
        this.requestID = requestID;
    }

    public static APIResponse loading(@NonNull Integer requestID) {
        return new APIResponse(Status.LOADING, null, null, null, requestID);
    }

    public static APIResponse success(@NonNull Object data, @NonNull Integer requestID) {
        return new APIResponse(Status.SUCCESS, data, null, null, requestID);
    }

    public static APIResponse error(@NonNull Exception error, @NonNull Integer requestID) {
        return new APIResponse(Status.ERROR, null, error, null, requestID);
    }

    public static APIResponse failure(@NonNull Throwable failure, @NonNull Integer requestID) {
        return new APIResponse(Status.FAILURE, null, null, failure, requestID);
    }

}
