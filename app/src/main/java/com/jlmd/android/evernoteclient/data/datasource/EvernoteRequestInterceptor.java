package com.jlmd.android.evernoteclient.data.datasource;

import com.jlmd.android.evernoteclient.domain.repository.CredentialsRepository;
import javax.inject.Inject;
import retrofit.RequestInterceptor;

/**
 * @author jlmd
 */
public class EvernoteRequestInterceptor implements RequestInterceptor {

  @Inject protected CredentialsRepository credentialsRepository;

  @Override
  public void intercept(RequestFacade request) {

  }
}
