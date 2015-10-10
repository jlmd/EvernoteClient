package com.jlmd.android.evernoteclient.data.mapper;

/**
 * @author jlmd
 */
public interface Mapper<TFrom, TTo> {

  TTo map(TFrom from);
}
