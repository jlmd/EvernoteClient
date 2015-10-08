package com.jlmd.android.evernoteclient.domain.model;

/**
 * @author jlmd
 */
public class Credentials {

  private String accessToken;
  private double expirationTime;

  public Credentials(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public double getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(double expirationTime) {
    this.expirationTime = expirationTime;
  }
}
