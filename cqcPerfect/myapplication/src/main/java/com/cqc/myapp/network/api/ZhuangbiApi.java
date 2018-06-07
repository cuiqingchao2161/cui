// (c)2016 Flipboard Inc, All Rights Reserved.

package com.cqc.myapp.network.api;

import com.cqc.myapp.rxjavaSample.model.ZhuangbiImage;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface ZhuangbiApi {
    @GET("search")
    Observable<List<ZhuangbiImage>> search(@Query("q") String query);
}
