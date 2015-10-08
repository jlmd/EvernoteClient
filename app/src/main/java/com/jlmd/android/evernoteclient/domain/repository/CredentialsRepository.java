package com.jlmd.android.evernoteclient.domain.repository;

import com.jlmd.android.evernoteclient.domain.model.Credentials;

/**
 * @author jlmd
 */
public interface CredentialsRepository {

  Credentials getCredentials();

  void setCredentials(Credentials credentials);
}
