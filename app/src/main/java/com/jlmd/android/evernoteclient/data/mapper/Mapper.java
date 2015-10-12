package com.jlmd.android.evernoteclient.data.mapper;

/**
 * Generic mapper interface which receive from and to classes as generic types
 *
 * @author jlmd
 */
public interface Mapper<TFrom, TTo> {

  TTo map(TFrom from);
}
