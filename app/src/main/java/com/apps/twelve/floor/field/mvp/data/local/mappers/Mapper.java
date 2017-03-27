package com.apps.twelve.floor.field.mvp.data.local.mappers;

/**
 * Created by John on 27.03.2017.
 */

public interface Mapper<A, B> {
  B transform(A obj) throws RuntimeException;
}
